/**
 * Created by admin on 27.04.2018.
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

function activeClickTr() {
    $("#tbodyTerminal tr").click(function () {
        var id = $(this).attr("id");
        $.ajax({
            url: "/api/currency/search/" + id,
            type: "GET",
            success: function (termCurrency) {
               console.log(termCurrency)

                $('#terminalName').html(termCurrency.terminals.termName);
                $('#currency1').val(termCurrency.curr1);
                $('#currency2').val(termCurrency.curr2);
                $('#currency3').val(termCurrency.curr3);
                $('#currency4').val(termCurrency.curr4);
                $("#searchTerminal").css("display", "none");
                $("#outputTermCurrency").css("display", "");
                //activeClickTr();
            }
        })
    })
}
function searchTerminalByName(searchInputTerminal) {
    $.ajax({
        url: "/api/terminals/searchName/" + searchInputTerminal,
        type: "GET",
        success: function (data) {
            outputTerminal(data)
            activeClickTr();
        }
    })
}
function searchTerminalById(searchInputTerminal) {
    $.ajax({
        url: "/api/terminals/searchId/" + searchInputTerminal,
        type: "GET",
        success: function (data) {
            outputTerminal(data)
            activeClickTr();
        }
    })
}
$(document).ready(function () {
    $("#searchInput").on('input', function () {
        searchInputTerminal = $(this).val();
        if (searchInputTerminal === "") {
            $('#tbodyTerminal').empty();
        }
        else if ($.isNumeric(searchInputTerminal)) {
            $.when(searchTerminalById(searchInputTerminal)).done(function () {
                $('#tbodyTerminal').empty();
            });

        }
        else if ($.isNumeric(searchInputTerminal) != true) {
            $('#tbodyTerminal').empty();
            searchTerminalByName(searchInputTerminal)
        }

    })

});

