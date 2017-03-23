
var orderData = [
       { orderNumber: 1, buyer: "Party1", seller: "Party4", orderDate: "01/01/2017", status: "Complete" },
       { orderNumber: 2, buyer: "Party2", seller: "Party4", orderDate: "01/01/2017", status: "Complete" },
       { orderNumber: 3, buyer: "Party1", seller: "Party5", orderDate: "01/01/2017", status: "Complete" },
       { orderNumber: 4, buyer: "Party3", seller: "Party6", orderDate: "01/01/2017", status: "Complete" },
       { orderNumber: 5, buyer: "Party4", seller: "Party7", orderDate: "01/01/2017", status: "Complete" },
       { orderNumber: 6, buyer: "Party6", seller: "Party7", orderDate: "01/01/2017", status: "Complete" },
       { orderNumber: 7, buyer: "Party5", seller: "Party7", orderDate: "01/01/2017", status: "Complete" },

];



var buyerSellerMaster = {
    "page": "1",
    "records": "5",
    "rows": [
        { "id": "1", Name: "bikas" },
                { "id": "2", Name: "adarsh" },
                { "id": "3", Name: "balaji" },
                { "id": "4", Name: "nidhi" },
                { "id": "5", Name: "mayank" },

    ]
};

var getQueryStringValue = function (queryStringKey) {
    var url = window.location;
    if (!url) {
        url = window.location.href;
    }
    var name = queryStringKey.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

var redirectUser = function (url) {
    window.location = url;
}

var showMessage = function (message, msgType) {
    if (messageType == messageType.information) {
        alert(message);
    }
    if (messageType == messageType.error) {
        alert(message);
    }
    if (messageType == messageType.warning) {
        alert(message);
    }
}
var messageType = { error: "error", information: "information", warning: "warning" };
var party = { buyer: "buyer", seller: "seller", bank: "bank" };
var action = { create: "create", edit: "edit", view: "view", remove: "remove" };


//setTimeout(function () {
//    alert("Hello");
//}, 3000
//);
// Get status wise class

var getClassByOrderStatus = function (orderStatus) {
    var cls = "label label-default";
    switch (orderStatus) {
        case 1:
            cls = "label label-primary";
            break;
        case 2:
            cls = "btn btn-info";
            break;
        case 3:
            cls = "label label-success";
            break;
        case 4:
            cls = "label label-info";
            break;
        case 5:
            cls = "label label-danger";
            break;
        case 6:
            cls = "label label-primary";
            break;
        default:
            cls = "label label-primary";
            break;
    }
    return cls;
}
var currentUser = { userID: getQueryStringValue("userID"), userName: '' };

// STATIC DATA

var partyData = [
       { id: 1, name: "Party1", orderDate: "01/01/2017" },
       { id: 2, name: "Party2", orderDate: "02/01/2017" },
       { id: 3, name: "Party3", orderDate: "03/01/2017" },
       { id: 4, name: "Party4", orderDate: "04/01/2017" },
       { id: 5, name: "Party5", orderDate: "05/01/2017" },
       { id: 6, name: "Party6", orderDate: "06/01/2017" },
       { id: 7, name: "Party7", orderDate: "07/01/2017" },
       { id: 8, name: "Party8", orderDate: "08/01/2017" },
       { id: 9, name: "Party9", orderDate: "09/01/2017" },
       { id: 10, name: "Party10", orderDate: "10/01/2017" },
];


var userMaster = [
    { id: 1, userName: "bikas", password: "bikas", name: "Bikas", bank: { company: "Bank of Scotland", bankName: "Bank of Scotland", vat: "BOS12SB8EGHAS", iban: "BOS12SB", address: "45 Henderson St, Bridge of Allan, Stirling FK9 4HG, UK" } },
    { id: 2, userName: "adarsh", password: "adarsh", name: "Adarsh", bank: { company: "China Construction Bank", bankName: "China Construction Bank", vat: "CCB84588A8SS8", iban: "CCB845", address: "No.25, Finance Street, Beijing-100033, China" } },
    { id: 3, userName: "balaji", password: "balaji", name: "Balaji", bank: { company: "DTC Corp Balaji", bankName: "Wells Fargo & Co", vat: "WFC5DHBSD834SS", iban: "WFC5", address: "Wells Fargo 420 Montgomery Street San Francisco, CA 94104" } },
    { id: 4, userName: "nidhi", password: "nidhi", name: "Nidhi", bank: { company: "Wells Fargo & Co", bankName: "HSBC Holdings", vat: "HSBC5544SDZA88", iban: "HSBC", address: "	Canary Wharf London, E14 United Kingdom" } },
    { id: 5, userName: "mayank", password: "mayank", name: "Mayank", bank: { company: "JP Morgan Chase", bankName: "JP Morgan Chase", vat: "JPMC93sKLPFF", iban: "JPMC", address: "270 Park Avenue New York, NY 10017 U.S." } }
];


var data = {
    "page": "1",
    "records": "5",
    "rows": [
         { id: 1, userName: "bikas", password: "bikas", name: "Bikas", bank: { company: "Bank of Scotland", bankName: "Bank of Scotland", vat: "BOS12SB8EGHAS", iban: "BOS12SB", address: "45 Henderson St, Bridge of Allan, Stirling FK9 4HG, UK" } },
    { id: 2, userName: "adarsh", password: "adarsh", name: "Adarsh", bank: { company: "China Construction Bank", bankName: "China Construction Bank", vat: "CCB84588A8SS8", iban: "CCB845", address: "No.25, Finance Street, Beijing-100033, China" } },
    { id: 3, userName: "balaji", password: "balaji", name: "Balaji", bank: { company: "DTC Corp Balaji", bankName: "Wells Fargo & Co", vat: "WFC5DHBSD834SS", iban: "WFC5", address: "Wells Fargo 420 Montgomery Street San Francisco, CA 94104" } },
    { id: 4, userName: "nidhi", password: "nidhi", name: "Nidhi", bank: { company: "Wells Fargo & Co", bankName: "HSBC Holdings", vat: "HSBC5544SDZA88", iban: "HSBC", address: "	Canary Wharf London, E14 United Kingdom" } },
    { id: 5, userName: "mayank", password: "mayank", name: "Mayank", bank: { company: "JP Morgan Chase", bankName: "JP Morgan Chase", vat: "JPMC93sKLPFF", iban: "JPMC", address: "270 Park Avenue New York, NY 10017 U.S." } }

    ]
};

function getPartyBankDetails(id) {
    var bankDetails = null;
    $.each(data.rows, function (index, item) {
        if (item.id == id) {
            bankDetails = item.bank;
        }
    });
    return bankDetails;
}

var serviceURL = window.location.protocol + "//" + window.location.host + "/api/dtc/";

function validateCridentials(userName, password) {
    debugger;
    var isValid = false;
    var user = { userId: userName, password: password };
    $.ajax({
        type: "PUT",
        url: serviceURL + "validate-login", //TODO: Change the web service URL to make it live
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(user),
        dataType: "json",
        async: false,
        beforeSend: function () {
            $("#divBusyStatus").show();
        },
        complete: function () {
            $("#divBusyStatus").hide();
        },
        success: function (data) {
            debugger;
            isValid = (null != data && undefined != data && undefined != data.dtcId && data.dtcId.length > 0);
        },
        error: function (errMsg) {
            debugger;
            alert(errMsg.status + ' \n\r ' +
            errMsg.statusText + '\n\r' +
            errMsg.responseText);
            debugger;
        }
    });

    //$.each(userMaster, function (index, item) {
    //    if (item.userName == userName && item.password == password) {
    //        isValid = true;
    //    }
    //});
    return isValid;
}

/*

var Response =
      {
          state: {
              data: {
                  purchaseOrder: {
                      orderNumber: 100,
                      deliveryDate: 1536969600000,
                      deliveryAddress: {
                          city: "London",
                          country: "UK"
                      },
                      items: [
                        {
                            name: "widget",
                            amount: 3
                        },
                        {
                            name: "thing",
                            amount: 4
                        }
                      ]
                  },
                  buyer: "NodeA",
                  seller: "NodeB",
                  contract: {
                      legalContractReference: "4C8742993015156C5364274BD512DC59E720E2F886AB2B09E4822A7F9FB8FA9B"
                  },
                  linearId: {
                      externalId: "100",
                      id: "08bdafb9-b86c-456f-9edd-7743ab1de71b"
                  },
                  ref: "100",
                  participants: [
                    "bzs7kf4QChH5vzmmgKnSaUx9BzBnNRKUo3J2oYgBrQA9uGWVX6",
                    "bzs7kfAMYDEw9QbG5PaL4VkRayVfFpz9Boxis5B2aoFkESK8Bw",
                    "bzs7kezvBSm9XWCT5nsCGSaDv5fc7tvtbBMkPDmWGd2wpeXw3N"
                  ],
                  parties: [
                    "NodeA",
                    "NodeB",
                    "NodeC"
                  ]
              },
              notary: "corda.notary.validating|Controller",
              encumbrance: null
          },
          ref: {
              txhash: "F0010692257E555E36D7BC7A4333D6C039A1DB80F96FC1D6ED14786ED883FD61",
              index: 0
          }
      };
*/

// Ajax Busy Status
$(document)
  .ajaxStart(function () {
      $('#divBusyStatus').show();
  })
  .ajaxStop(function () {
      $('#divBusyStatus').hide();
  });

function getPurchaseOrderNumber() {
    var d = new Date();
    var orderNumber = d.getFullYear().toString();
    orderNumber += d.getMonth() > 9 ? d.getMonth() : "0" + d.getMonth();
    orderNumber += d.getDate() > 9 ? d.getDate() : "0" + d.getDate();
    orderNumber += d.getHours() > 9 ? d.getHours() : "0" + d.getHours();
    orderNumber += d.getMinutes() > 9 ? d.getMinutes() : "0" + d.getMinutes();
    orderNumber += d.getSeconds() > 9 ? d.getSeconds() : "0" + d.getSeconds();
    return orderNumber;
}

function updateTotalPrice() {

    var totalAmount = 0;
    $('#tblArticleDetails > tbody  > tr').each(function (index, tr) {
        if (($('td:eq(2)', this).find("input:text").val().length > 0) && (!isNaN($('td:eq(2)', this).find("input:text").val()))) {
            totalAmount += parseInt($('td:eq(2)', this).find("input:text").val());
        }
    });
    $("#txtTotalPrice").val(totalAmount);
}

