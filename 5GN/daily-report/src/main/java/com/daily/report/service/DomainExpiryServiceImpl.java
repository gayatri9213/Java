package com.daily.report.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.*;

@Service
public class DomainExpiryServiceImpl implements DomainExpiryService {
    private static final Logger logger = LoggerFactory.getLogger(DomainExpiryServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Environment env;

    @Autowired
    private AmazonSimpleEmailService amazonSimpleEmailService;

    public StringWriter exportToCSV() throws IOException {
        logger.info("This {} export to the CSV", env.getProperty("report.domain.expiry.query"));
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(env.getProperty("report.domain.expiry.query"));
        StringWriter writer = new StringWriter();
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        Set<String> headers = rows.isEmpty() ? Collections.emptySet() : rows.get(0).keySet();
        logger.info("CSV file Headers : {}", headers);
        csvPrinter.printRecord(headers);
        for (Map<String, Object> row : rows) {
            List<Object> rowData = new ArrayList<>();
            for (String header : headers) {
                rowData.add(row.get(header));
            }
            csvPrinter.printRecord(rowData);
        }
        logger.info("CSV file converted successfully");
        csvPrinter.flush();
        csvPrinter.close();
        return writer;
    }

    public void sendEmailWithAttachment() throws MessagingException, IOException {
        StringWriter writer = exportToCSV();
        String csvData = writer.toString();
        Session session = Session.getDefaultInstance(new Properties());
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(env.getProperty("sender.email")));
        String[] receiverEmails = env.getProperty("receiver.email").split(",");
        InternetAddress[] addresses = new InternetAddress[receiverEmails.length];
        for (int i = 0; i < receiverEmails.length; i++) {
            addresses[i] = new InternetAddress(receiverEmails[i].trim());
        }
        message.setRecipients(Message.RecipientType.TO, addresses);
        message.setSubject(env.getProperty("subject.email"));
        MimeBodyPart contentPart = new MimeBodyPart();
        contentPart.setContent("This is the test email .", "text/plain");
        DataSource source = new ByteArrayDataSource(csvData, "text/csv");
        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.setDataHandler(new DataHandler(source));
        attachmentPart.setFileName("report " + LocalDate.now() + ".csv");
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(attachmentPart);
        multipart.addBodyPart(contentPart);
        message.setContent(multipart);
        ByteArrayOutputStream rawMessageStream = new ByteArrayOutputStream();
        message.writeTo(rawMessageStream);
        byte[] rawMessageData = rawMessageStream.toByteArray();
        SendRawEmailRequest rawEmailRequest = new SendRawEmailRequest()
                .withRawMessage(new RawMessage(ByteBuffer.wrap(rawMessageData)));
        amazonSimpleEmailService.sendRawEmail(rawEmailRequest);
    }
}
