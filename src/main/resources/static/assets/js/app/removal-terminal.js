/**
 * Created by admin on 26.04.2018.
 */
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
var terminal_list = [];

function outputTerminalForm(terminal) {
    $('#idTerminal').html(terminal.idTerminals);
    $('#modelTerminal').val(terminal.tmodel.description);
    $('#typeTerminal ').val(terminal.termsDesc.description);
    $('#nameTerminal').val(terminal.termName);
    $('#address1Terminal').val(terminal.addr1);
    $('#address2Terminal').val(terminal.addr2);
    $('#zipcodeTerminal').val(terminal.zipcode);
    $('#tbodyLegalEntity').empty();
    let elementClassic = '<tr id="' + terminal.merchTab.idMerchTab + '"> <td>' + terminal.merchTab.merchName + '</td><td>' + terminal.merchTab.addr1 + '</td><td>' + terminal.merchTab.addr2 +
        '</td><td>' + terminal.merchTab.zipcode + '</td><td>' + terminal.merchTab.phone + '</td><td>' + terminal.merchTab.eMail + '</td></tr>';
    $('#tbodyLegalEntity').append(elementClassic);
}
$(document).ready(function () {
    $("#deleteTerminal").click(function () {
        let selectTerminal = $('#terminal option:selected').val();
        if (selectTerminal === "") {
            $("#row").before('<div class="alert alert-danger alert-dismissible fade in shadowed" role="alert" id="panelAlert" >' +
                ' <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> ' +
                ' <i class="fa fa-fw fa-info-circle"></i> Выберите терминал для удаления! </div>');
        }
        else {
            $.ajax({
                url: "/api/terminals/delete/"+ terminal.idTerminals,
                type: "DELETE",
                success: function (data) {
                }
            })
            $('#idTerminal').html('');
            $('#modelTerminal').val('');
            $('#typeTerminal ').val('');
            $('#nameTerminal').val('');
            $('#address1Terminal').val('');
            $('#address2Terminal').val('');
            $('#zipcodeTerminal').val('');
            $('#tbodyLegalEntity').empty();
        }
    })
    $("#terminal").change(function () {
        let selectTerminal = $('#terminal option:selected').val();
        for (let i = 0; i <= terminal_list.length; i++) {
            if (terminal_list[i].termName === selectTerminal) {
                terminal = terminal_list[i];
                outputTerminalForm(terminal);
                break;
            }
        }
    });
    $.get("/api/terminals/", function (terminals) {
        outputTerminal(terminals);
    });
});


function createOptionSelectTerminal(terminal) {
    let elementClassic = '<option>' + terminal.termName + '</option>';
    $('#terminal').append(elementClassic);

}
function outputTerminal(terminalsData) {
    for (let i = 0; i < terminalsData.length; i++) {
        terminal = terminalsData[i];
        terminal_list[i] = terminal
        createOptionSelectTerminal(terminal);
    }

}
