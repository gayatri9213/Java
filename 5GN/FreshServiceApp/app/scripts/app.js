let currentPage = 1;
let perPage = 30;

async function fetchAssetData(page) {
  const apiKey = 'HUdE3W2nXJFBmTGCWy6';
  const domain = '5gn-dev';
  const apiUrl = `https://${domain}.freshservice.com/api/v2/assets?page=${page}&filter="asset_type_id:76000259448"&include=type_fields`;
  let relationships = null;
  const xhr = new XMLHttpRequest();
  xhr.open('GET', apiUrl, true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.setRequestHeader('Authorization', `Basic ${btoa(apiKey + ':x')}`);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        const assetData = JSON.parse(xhr.responseText);
        const assets = assetData.assets.map(async function (item) {
          const assetType = await fetchAssetType(item.asset_type_id);
          relationships = await fetchRelationshipsForAsset(item.display_id);
          const displayIds = relationships.map(relationship => relationship.secondary_id);
          const count = relationships.length;
          item.asset_type = assetType;
          item.count = {
            "text": count,
            "href": "javascript:void(0);",
            "variant": count > 0 ? "anchor" : "text",
            "onClick": () => {
              if (count > 0) {
                fetchAssociatedAssets(item.name, displayIds);
              }
            }
          };
          item.role = item.type_fields.role_76000259448;
          item.status = item.type_fields.status_76000259448;
          return item;
        });
        Promise.all(assets).then(async (updatedAssets) => {
          const data = {
            columns: [
              { "key": "name", "text": "Name" },
              { "key": "asset_type", "text": "Asset Type" },
              { "key": "impact", "text": "Impact" },
              { "key": "asset_tag", "text": "Asset Tag" },
              { "key": "role", "text": "Role" },
              { "key": "status", "text": "Status" },
              { "key": "count", "text": "Asset Count", "variant": "anchor" }
            ],
            assets: updatedAssets.filter(Boolean)
          };
          const totalCount = await fetchAssetCount();
          const totalrecords = totalCount;
          const totalPages = Math.ceil(data.assets.length / perPage);
          const pagination = document.getElementById('pagination');
          pagination.setAttribute('page', currentPage.toString());
          pagination.setAttribute('total', totalrecords.toString());
          pagination.setAttribute('total-pages', totalPages.toString());
          pagination.addEventListener('fwChange', function (event) {
            const newPage = parseInt(event.detail.page);
            currentPage = newPage;
            fetchAssetData(newPage);
          });
          var datatable = document.getElementById('datatable');
          datatable.columns = data.columns;
          datatable.rows = data.assets;
        });
      } else {
        console.error('Error fetching asset data. Status:', xhr.status);
      }
    }
  };
  xhr.send();
}

function fetchAssetType(assetTypeId) {
  return new Promise(function (resolve, reject) {
    const apiKey = 'HUdE3W2nXJFBmTGCWy6';
    const domain = '5gn-dev';
    const apiUrl = `https://${domain}.freshservice.com/api/v2/asset_types/${assetTypeId}`;
    const xhr = new XMLHttpRequest();
    xhr.open('GET', apiUrl, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader('Authorization', `Basic ${btoa(apiKey + ':x')}`);
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          const assetTypeData = JSON.parse(xhr.responseText);
          const name = assetTypeData.asset_type.name;
          resolve(name);
        } else {
          console.error('Error fetching asset type data. Status:', xhr.status);
          reject();
        }
      }
    };
    xhr.send();
  });
}

function fetchRelationshipsForAsset(assetDisplayId) {
  return new Promise(function (resolve, reject) {
    const apiKey = 'HUdE3W2nXJFBmTGCWy6';
    const domain = '5gn-dev';
    const apiUrl = `https://${domain}.freshservice.com/api/v2/assets/${assetDisplayId}/relationships`;
    const xhr = new XMLHttpRequest();
    xhr.open('GET', apiUrl, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader('Authorization', `Basic ${btoa(apiKey + ':x')}`);
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          const relationshipData = JSON.parse(xhr.responseText);
          const relationships = [];
          for (const key in relationshipData) {
            if (Object.hasOwnProperty.call(relationshipData, key)) {
              const relationship = relationshipData[key];
              if (Array.isArray(relationship) && relationship.length >= 0) {
                relationship.forEach(function (item) {
                  relationships.push(item);
                });
              } else {
                console.error('Error: relationshipData is not an array or does not contain any records');
              }
            }
          }
          resolve(relationships);
        } else {
          console.error('Error fetching relationship data. Status:', xhr.status);
          reject();
        }
      }
    };
    xhr.send();
  });
}

async function fetchAssociatedAssets(name, displayIds) {
  const modal = document.querySelector('#large');
  const apiKey = 'HUdE3W2nXJFBmTGCWy6';
  const domain = '5gn-dev';
  const modalTitle = document.querySelector('#name');
  modalTitle.textContent = name;

  const fetchPromises = displayIds.map((displayId) => {
    return new Promise((resolve, reject) => {
      const apiUrl = `https://${domain}.freshservice.com/api/v2/assets/${displayId}?include=type_fields`;
      const xhr = new XMLHttpRequest();
      xhr.open('GET', apiUrl, true);
      xhr.setRequestHeader('Content-Type', 'application/json');
      xhr.setRequestHeader('Authorization', `Basic ${btoa(apiKey + ':x')}`);
      xhr.onreadystatechange = async function () {
        if (xhr.readyState === 4) {
          if (xhr.status === 200) {
            const associatedAssetsData = JSON.parse(xhr.responseText);
            let assets = associatedAssetsData.asset;
            if (!Array.isArray(assets)) {
              assets = [assets];
            }
            const updatedAssets = await Promise.all(
              assets.map(async function (item) {
                const assetType = await fetchAssetType(item.asset_type_id);
                item.asset_type = assetType;
                item.vendor = item.type_fields.vendormodel_76000259450;
                item.model = item.type_fields.model_76001219586;
                item.role = item.type_fields.role_76000259450;
                return item;
              })
            );
            resolve(updatedAssets);
          } else {
            reject(`Error fetching associated assets. Status: ${xhr.status}`);
          }
        }
      };
      xhr.send();
    });
  });
  try {
    const allAssets = await Promise.all(fetchPromises);
    const mergedAssets = allAssets.flat();
    const data = {
      columns: [
        { key: 'name', text: 'Name' },
        { key: 'asset_type', text: 'Asset Type' },
        { key: 'impact', text: 'Impact' },
        { key: 'asset_tag', text: 'Asset Tag' },
        { key: 'vendor', text: 'Vendor' },
        { key: 'model', text: 'Model' },
        { key: 'role', text: 'Role' },
      ],
      assets: mergedAssets.filter(Boolean).map((item) => ({
        name: item.name,
        asset_type: item.asset_type,
        impact: item.impact,
        asset_tag: item.asset_tag,
        vendor: item.vendor,
        model: item.model,
        role: item.role
      })),
    };
    var datatable = document.getElementById('assetdatatable');
    datatable.columns = data.columns;
    datatable.rows = data.assets;
  } catch (error) {
    console.error('Error fetching associated assets:', error);
  }
  modal.open();
}

async function fetchAssetCount() {
  const pageSize = 30;
  let currentPage = 1;
  let totalCount = 0;
  let pageData;
  do {
    const response = await fetch(`https://5gn-dev.freshservice.com/api/v2/assets?page=${currentPage}&filter="asset_type_id:76000259448"&include=type_fields`, {
      headers: {
        Authorization: 'Basic SFVkRTNXMm5YSkZCbVRHQ1d5Ng==',
        'Content-Type': 'application/json'
      }
    });
    const data = await response.json();
    const assets = data.assets;
    const assetCount = assets.length;
    totalCount += assetCount;
    console.log(`Received ${assetCount} assets on page ${currentPage}`);
    currentPage++;
    pageData = data;
  } while (pageData.assets.length === pageSize);
  console.log(`Total asset count: ${totalCount}`);
  return totalCount;
}

fetchAssetData(currentPage)