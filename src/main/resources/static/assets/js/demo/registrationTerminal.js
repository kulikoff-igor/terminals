/**
 * Created by admin on 26.04.2018.
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
var tModel = {
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
    tmodel: tModel

};

var merchTabList = [];
var tModelList = [];
var termsDescList = [];

function createOptionSelectLegalEntity(merchTab) {
    let elementClassic = '<option>' + merchTab.merchName + '</option>';
    $('#legalEntitySelect').append(elementClassic);
}

function outputLegalEntity(legalEntityData) {
    for (let i = 0; i < legalEntityData.length; i++) {
        merchTab = legalEntityData[i];
        merchTabList[i] = merchTab
        createOptionSelectLegalEntity(merchTab);
    }

}
function createOptionSelectTermsDesc(termsDesc) {
    let elementClassic = '<option>' + termsDesc.description + '</option>';
    $('#typeTerminal').append(elementClassic);
}
function outputTermsDesc(termsDescData) {
    for (let i = 0; i < termsDescData.length; i++) {
        termsDesc = termsDescData[i];
        termsDescList[i] = termsDesc
        createOptionSelectTermsDesc(termsDesc);
    }
}

function createOptionSelectTModel(tModel) {
    let elementClassic = '<option>' + tModel.description + '</option>';
    $('#modelTerminal').append(elementClassic);
}
function outputTmodel(tModelData) {
    for (let i = 0; i < tModelData.length; i++) {
        tModel = tModelData[i];
        tModelList[i] = tModel
        createOptionSelectTModel(tModel);
    }
}
function createTrTbodyLegalEntity() {
    $('#tbodyLegalEntity').empty();
    let elementClassic = '<tr id="' + merchTab.idMerchTab + '"> <td>' + merchTab.merchName + '</td><td>' + merchTab.addr1 + '</td><td>' + merchTab.addr2 +
        '</td><td>' + merchTab.zipcode + '</td><td>' + merchTab.phone + '</td><td>' + merchTab.eMail + '</td></tr>';
    $('#tbodyLegalEntity').append(elementClassic);
}
function addTerminal(selectTModel, selectTypeTerminal, nameTerminal, address1Terminal, address2Terminal, zipcodeTerminal) {
    for (let i = 0; i <= tModelList.length; i++) {
        if (tModelList[i].description === selectTModel) {
            tModel = tModelList[i];
            break;
        }
    }
    for (let i = 0; i <= tModelList.length; i++) {
        if (termsDescList[i].description === selectTypeTerminal) {
            termsDesc = termsDescList[i];
            break;
        }
    }
    terminal.termName = nameTerminal;
    terminal.addr1 = address1Terminal;
    terminal.addr2 = address2Terminal;
    terminal.zipcode = zipcodeTerminal;
    terminal.merchTab = merchTab;
    terminal.tmodel = tModel;
    terminal.termsDesc = termsDesc;
    console.log(JSON.stringify(terminal));

    $.ajax({
        url: "/api/terminals/add",
        type: "POST",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(terminal),
        success: function (data) {
            $('#modelTerminal option:selected').val("");
            $('#typeTerminal option:selected').val("");
            $('#legalEntitySelect option:selected').val("");
            $('#nameTerminal').val("");
            $('#address1Terminal').val("");
            $('#address2Terminal').val("");
            $('#zipcodeTerminal').val("");
        }
    })

}
$(document).ready(function () {
    $("#legalEntitySelect").change(function () {
        let selectMerchName = $('#legalEntitySelect option:selected').val();

        for (let i = 0; i <= merchTabList.length; i++) {
            if (merchTabList[i].merchName === selectMerchName) {
                merchTab = merchTabList[i];
                createTrTbodyLegalEntity(merchTab);
                break;
            }
        }
    });
    $("#addTerminal").click(function () {
        let selectTModel = $('#modelTerminal option:selected').val();
        let selectTypeTerminal = $('#typeTerminal option:selected').val();
        let selectMerchName = $('#legalEntitySelect option:selected').val();
        let nameTerminal = $('#nameTerminal').val();
        let address1Terminal = $('#address1Terminal').val();
        let address2Terminal = $('#address2Terminal').val();
        let zipcodeTerminal = $('#zipcodeTerminal').val();
        if (selectTModel == "" || selectTypeTerminal == "" || nameTerminal == "" || address1Terminal == "" || address2Terminal == "" || zipcodeTerminal == "" || $.isNumeric(zipcodeTerminal) == false || selectMerchName == "") {
            $("#row").before('<div class="alert alert-danger alert-dismissible fade in shadowed" role="alert" id="panelAlert" >' +
                ' <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> ' +
                ' <i class="fa fa-fw fa-info-circle"></i> Заполните все поля! </div>');
        }
        else {
            addTerminal(selectTModel, selectTypeTerminal, nameTerminal, address1Terminal, address2Terminal, zipcodeTerminal);
        }
    })
    $.get("/api/merchTab/", function (legalEntityData) {
        outputLegalEntity(legalEntityData);
    });
    $.get("/api/terminals/description/", function (termsDescData) {
        outputTermsDesc(termsDescData);
    });
    $.get("/api/terminals/tmodel/", function (tModelData) {
        outputTmodel(tModelData);
    });

});
