package com.daily.report.service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.StringWriter;

public interface DomainExpiryService {

    public StringWriter exportToCSV() throws IOException;

    public void sendEmailWithAttachment() throws MessagingException, IOException;
}
