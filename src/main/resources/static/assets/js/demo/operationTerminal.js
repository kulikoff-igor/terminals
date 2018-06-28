/**
 * Created by admin on 10.05.2018.
 */
$(document).ready(function () {

    $.get("/api/pid-group/", function (groupTerminals) {
        console.log(groupTerminals);
        outputOperationTerminal(groupTerminals);
    })

});

function createGroupTerminal(numberPidGroup, transSchemeListDescription) {
    var elementClassic = ' <div class="col-md-6"><div class="panel panel-default"><div class="panel-heading">Группа терминалов <label id="numberGroup">' + numberPidGroup + '</label></div>' +
        '<div class="panel-body"><div class="row"><div class="col-md-6"><div class="panel-heading">Терминалы в группе</div>' +
        '<div class="panel-body" style="padding-top: 0px" ><table class="table table-hover" > <thead>' +
        '<tr><th>ID</th><th>Название</th><th>Юр.лицо</th></tr></thead><tbody id="tbodyTerminal' + numberPidGroup + '"></tbody></table></div></div>' +
        ' <div class="col-md-6"><div class="panel-heading">Описание схемы операций</div><div class="panel-body" style="padding-top: 0px"><p id="descriptionSchemeOperation">' + transSchemeListDescription + '</p>' +
        '<ul class="list-unstyled" style="list-style-type: circle" id="listOperations' + numberPidGroup + '"></ul></div> </div> </div > </div ></div></div></div> ';
    $('#viewGroupTerminal').append(elementClassic);
}
function createTrTbodyTerminal(terminal, numberPidGroup) {
    var elementClassic = '<tr id="' + terminal.idTerminals + '"> <td>' + terminal.idTerminals + '</td><td>' + terminal.termName + '</td><td>' + terminal.merchTab.merchName + '</td></tr>';
    $('#tbodyTerminal' + numberPidGroup).append(elementClassic);
}
function createLiOperation(transSchemeList, numberPidGroup) {
    var elementClassic = '';
    for (var i = 0; i < transSchemeList.length; i++) {
        elementClassic += '<li>' + transSchemeList[i].transTypeDesc.description + '</li>';
    }

    $('#listOperations' + numberPidGroup).append(elementClassic);
}
function outputOperationTerminal(groupTerminals) {
    var tmpNumberGroup = groupTerminals[0].numberPidGroup;

    for (var i = 0; i < groupTerminals.length; i++) {
        if (tmpNumberGroup == groupTerminals[0].numberPidGroup && i == 0 && groupTerminals[i].transSchemeList.length != 0) {
            createGroupTerminal(groupTerminals[i].numberPidGroup, groupTerminals[i].transSchemeList[0].description);
            createLiOperation(groupTerminals[i].transSchemeList, tmpNumberGroup);
        }
        if (tmpNumberGroup == groupTerminals[0].numberPidGroup && i == 0 && groupTerminals[i].transSchemeList.length == 0) {
            createGroupTerminal(groupTerminals[i].numberPidGroup, "Операции не назначены");
        }
        if (tmpNumberGroup == groupTerminals[i].numberPidGroup) {
            createTrTbodyTerminal(groupTerminals[i].terminals, tmpNumberGroup);


        }
        if (tmpNumberGroup != groupTerminals[i].numberPidGroup && groupTerminals[i].transSchemeList.length != 0) {
            tmpNumberGroup = groupTerminals[i].numberPidGroup
            createGroupTerminal(groupTerminals[i].numberPidGroup, groupTerminals[i].transSchemeList[0].description);
            createTrTbodyTerminal(groupTerminals[i].terminals, tmpNumberGroup);
            createLiOperation(groupTerminals[i].transSchemeList, tmpNumberGroup);
        }
        if (tmpNumberGroup != groupTerminals[i].numberPidGroup && groupTerminals[i].transSchemeList.length == 0) {
            tmpNumberGroup = groupTerminals[i].numberPidGroup
            createGroupTerminal(groupTerminals[i].numberPidGroup, "Операции не назначены");
            createTrTbodyTerminal(groupTerminals[i].terminals, tmpNumberGroup);
        }
    }

}

