/**
 * Created by admin on 03.05.2018.
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
var merchTabList = [];

function viewAllLegalEntities() {
    $('#tbodyLegalEntity').empty();
    $.get("/api/merchTab/", function (data) {
        outputLegalEntity(data);
        activeClickTr()
    });
}

function activeClickTr() {
    $("#tbodyLegalEntity tr").click(function () {
        var id = $(this).attr("id");
        $("#viewSearchLegalEntityTab").removeClass("active");
        $("#registrationLegalEntityTab").removeClass("active");
        $("#editDeleteLegalEntityTab").addClass("active");
        $("#editDeleteLegalEntityTab").css("display", "");
        $("#viewSearchLegalEntities").css("display", "none");
        $("#registrationLegalEntities").css("display", "none");
        $("#editDeleteLegalEntities").css("display", "");
        for (let i = 0; i <= merchTabList.length; i++) {
            if (merchTabList[i].idMerchTab == id) {
                merchTab = merchTabList[i];
                break;
            }
        }
        $('#idLegalEntity').html(merchTab.idMerchTab);
        $('#editNameLegalEntity').val(merchTab.merchName);
        $('#editPhoneLegalEntity').val(merchTab.phone);
        $('#editEmailLegalEntity').val(merchTab.eMail);
        $('#editAddress1LegalEntity').val(merchTab.addr1);
        $('#editAddress2LegalEntity').val(merchTab.addr2);
        $('#editZipcodeLegalEntity').val(merchTab.zipcode);

    })
}

function updateLegalEntity(idLegalEntity, nameLegalEntity, phoneLegalEntity, emailLegalEntity, address1LegalEntity, address2LegalEntity, zipcodeLegalEntity) {

    merchTab.idMerchTab = idLegalEntity;
    merchTab.merchName = nameLegalEntity;
    merchTab.phone = phoneLegalEntity;
    merchTab.eMail = emailLegalEntity;
    merchTab.addr1 = address1LegalEntity;
    merchTab.addr2 = address2LegalEntity;
    merchTab.zipcode = zipcodeLegalEntity;

    // console.log(JSON.stringify(merchTab));

    $.ajax({
        url: "/api/merchTab/update",
        type: "POST",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(merchTab),
        success: function (data) {
            console.log(data)
        }
    })
    $("#editDeleteLegalEntities").find(".form-control").prop('disabled', true);
    $("#editLegalEntity").css("display", "");
    $("#updateLegalEntity").css("display", "none");
    $("#deleteLegalEntity").css("display", "none");

}

function searchsearchInputLegalEntityByName(searchInputLegalEntity) {
    $.ajax({
        url: "/api/merchTab/search/" + searchInputLegalEntity,
        type: "GET",
        success: function (data) {
            outputLegalEntity(data)
            activeClickTr();
        }
    })
}

function createTrTbodyLegalEntity(merchTab) {
    let elementClassic = '<tr id="' + merchTab.idMerchTab + '"> <td>' + merchTab.merchName + '</td><td>' + merchTab.addr1 + '</td><td>' + merchTab.addr2 +
        '</td><td>' + merchTab.zipcode + '</td><td>' + merchTab.phone + '</td><td>' + merchTab.eMail + '</td></tr>';
    $('#tbodyLegalEntity').append(elementClassic);
}

function outputLegalEntity(data) {
    for (var i = 0; i < data.length; i++) {
        merchTabList[i] = data[i];
        createTrTbodyLegalEntity(merchTabList[i]);
    }

}

function createLegalEntity(nameLegalEntity, phoneLegalEntity, emailLegalEntity, address1LegalEntity, address2LegalEntity, zipcodeLegalEntity) {

    merchTab.merchName = nameLegalEntity;
    merchTab.phone = phoneLegalEntity;
    merchTab.eMail = emailLegalEntity;
    merchTab.addr1 = address1LegalEntity;
    merchTab.addr2 = address2LegalEntity;
    merchTab.zipcode = zipcodeLegalEntity;

    $.ajax({
        url: "/api/merchTab/add",
        type: "POST",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(merchTab),
        success: function (data) {
            console.log(data)
        }
    })

}
$(document).ready(function () {

    viewAllLegalEntities();

    $("#editDeleteLegalEntities").find(".form-control").prop('disabled', true);

    $("#registrationLegalEntityTab").click(function () {
        $("#viewSearchLegalEntityTab").removeClass("active");
        $("#editDeleteLegalEntityTab").removeClass("active");
        $("#editDeleteLegalEntityTab").css("display", "none");
        $(this).addClass("active");
        $("#viewSearchLegalEntities").css("display", "none");
        $("#registrationLegalEntities").css("display", "");
        $("#editDeleteLegalEntities").css("display", "none");
    })

    $("#viewSearchLegalEntityTab").click(function () {
        $("#registrationLegalEntityTab").removeClass("active");
        $("#editDeleteLegalEntityTab").removeClass("active");
        $("#editDeleteLegalEntityTab").css("display", "none");
        $(this).addClass("active");
        $("#viewSearchLegalEntities").css("display", "");
        $("#registrationLegalEntities").css("display", "none");
        $("#editDeleteLegalEntities").css("display", "none");
        viewAllLegalEntities();
    })

    $("#searchInput").on('input', function () {
        searchInputLegalEntity = $(this).val();
        if (searchInputLegalEntity === "") {

            viewAllLegalEntities();
        }
        else {
            $.when(searchsearchInputLegalEntityByName(searchInputLegalEntity)).done(function () {
                $('#tbodyLegalEntity').empty();
            });

        }

    });

    $("#editLegalEntity").click(function () {
        $("#editDeleteLegalEntities").find(".form-control").prop('disabled', false);
        $("#editLegalEntity").css("display", "none");
        $("#updateLegalEntity").css("display", "");
        $("#deleteLegalEntity").css("display", "");

    })

    $("#updateLegalEntity").click(function () {

        let idLegalEntity = $('#idLegalEntity').html();
        let nameLegalEntity = $('#editNameLegalEntity').val();
        let phoneLegalEntity = $('#editPhoneLegalEntity').val();
        let emailLegalEntity = $('#editEmailLegalEntity').val();
        let address1LegalEntity = $('#editAddress1LegalEntity').val();
        let address2LegalEntity = $('#editAddress2LegalEntity').val();
        let zipcodeLegalEntity = $('#editZipcodeLegalEntity').val();
        if (idLegalEntity == "" || nameLegalEntity == "" || phoneLegalEntity == "" || emailLegalEntity == "" || address1LegalEntity == "" || address2LegalEntity == "" || $.isNumeric(zipcodeLegalEntity) == false) {
            $("#editDeleteLegalEntities").before('<div class="alert alert-danger alert-dismissible fade in shadowed" role="alert" id="panelAlert" >' +
                ' <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> ' +
                ' <i class="fa fa-fw fa-info-circle"></i> Заполните все поля! </div>');
        }
        else {
            updateLegalEntity(idLegalEntity, nameLegalEntity, phoneLegalEntity, emailLegalEntity, address1LegalEntity, address2LegalEntity, zipcodeLegalEntity);
        }

    })

    $("#addLegalEntity").click(function () {

        let nameLegalEntity = $('#nameLegalEntity').val();
        let phoneLegalEntity = $('#phoneLegalEntity').val();
        let emailLegalEntity = $('#emailLegalEntity').val();
        let address1LegalEntity = $('#address1LegalEntity').val();
        let address2LegalEntity = $('#address2LegalEntity').val();
        let zipcodeLegalEntity = $('#zipcodeLegalEntity').val();
        if (nameLegalEntity == "" || phoneLegalEntity == "" || emailLegalEntity == "" || address1LegalEntity == "" || address2LegalEntity == "" || $.isNumeric(zipcodeLegalEntity) == false) {
            $("#registrationLegalEntities").before('<div class="alert alert-danger alert-dismissible fade in shadowed" role="alert" id="panelAlert" >' +
                ' <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> ' +
                ' <i class="fa fa-fw fa-info-circle"></i> Заполните все поля! </div>');
        }
        else {
            createLegalEntity(nameLegalEntity, phoneLegalEntity, emailLegalEntity, address1LegalEntity, address2LegalEntity, zipcodeLegalEntity);

        }
        $("#registrationLegalEntities").find(".form-control").val("");
    })

})
