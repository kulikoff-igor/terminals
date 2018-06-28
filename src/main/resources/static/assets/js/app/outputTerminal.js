/**
 * Created by admin on 25.04.2018.
 */
var merchTab = {
    idMerchTab: "",
    merchName: "",
    addr1: "",
    addr2: "",
    zipcode: "",
    phone: "",
    eMail: ""
}
var termsDesc = {
    idTermDesc: "",
    description: ""

}
var tmodel = {
    idTModel: "",
    description: ""

}
var terminal = {
    idTerminals: "",
    merchTab: merchTab,
    termsDesc: termsDesc,
    termName: "",
    addr1: "",
    addr2: "",
    zipcode: "",
    tmodel: tmodel

};
var terminal_list = {};

$(document).ready(function () {

    $.get("/api/terminals/", function (data) {
        outputTerminal(data);
        $("#tbodyTerminal tr").click(function () {
            var id = $(this).attr("id");
            console.log(id)
            window.sessionStorage.setItem("idTerminal",id);
            window.open("/edit-terminal.html", '_blank');
        })
    });


});

function createTrTbodyTerminal(terminal) {
    var elementClassic = '<tr id="' + terminal.idTerminals + '"> <td>' + terminal.idTerminals + '</td><td>' + terminal.termName + '</td><td>' + terminal.merchTab.merchName + '</td><td>' + terminal.tmodel.description + '</td><td>' + terminal.termsDesc.description + '</td> ' +
        '<td>' + terminal.addr1 + '</td><td>' + terminal.addr2 + '</td> <td>' + terminal.zipcode + '</td></tr>';
    $('#tbodyTerminal').append(elementClassic);
}

function outputTerminal(data) {
    for (var i = 0; i < data.length; i++) {
        terminal_list[i] = data[i];
        createTrTbodyTerminal(terminal_list[i]);
    }

}
