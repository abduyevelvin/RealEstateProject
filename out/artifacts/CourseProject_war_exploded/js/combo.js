$(function () {
    $('#usernameInfoId').dialog({
        autoOpen: false,
        modal: true,
        height: 145,
        width: 300,
        buttons: {
            Ok: function() {
                $( this ).dialog("close");
            }
        }
    });

});

function getDistrictListByCityId(cityId) {

    $.ajax({
        url: 'cs?action=getDistrictListByCityId',
        type: 'GET',
        data: 'cityId='+cityId,
        dataType: 'html',
        success: function (data) {
            $('#advDistrictComboId').html(data);
        }
    });
}

function getDistrictListByCityIdEdit(cityId) {

    $.ajax({
        url: 'cs?action=getDistrictListByCityId',
        type: 'GET',
        data: 'cityId='+cityId,
        dataType: 'html',
        success: function (data) {
            $('#districtComboIdU').html(data);
        }
    });
}

function getDistrictListByCityIdAdd(cityId) {

    $.ajax({
        url: 'cs?action=getDistrictListByCityId',
        type: 'GET',
        data: 'cityId='+cityId,
        dataType: 'html',
        success: function (data) {
            $('#districtComboId').html(data);
        }
    });
}

function checkUserName(userName) {

    $.ajax({
        url: 'cs?action=checkUserName',
        type: 'GET',
        data: 'userName='+userName,
        dataType: 'html',
        success: function (data) {
            if(data == 'success') {
                $('#usernameInfoId').dialog('open');
                $("#registerBtnId").prop( "disabled", true );
                $('#usernameId').focus();
            } else {
                $("#registerBtnId").prop( "disabled", false );
            }
        }
    });
}