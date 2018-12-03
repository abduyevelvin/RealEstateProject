var globBtnId = '';
var globHouseAnnounceId = 0;

$(function () {

    $('body').layout({ applyDemoStyles: true });

    $('.ui-layout-center, .ui-layout-east, .ui-layout-north, .ui-layout-south, .ui-layout-west').css('background-color', 'aqua');

    $('#newHouseDialogId').dialog({
        autoOpen: false,
        modal: true,
        show: {
            effect: "blind",
            duration: 1000
        },
        hide: {
            effect: "explode",
            duration: 1000
        },
        title: 'New House Announcement',
        height: 475,
        width: 400,
        buttons: {
            "Save": function () {
                addHouseAnnounce();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#editHouseDialogId').dialog({
        autoOpen: false,
        modal: true,
        show: {
            effect: "blind",
            duration: 1000
        },
        hide: {
            effect: "explode",
            duration: 1000
        },
        title: 'Edit House Announcement',
        height: 475,
        width: 400,
        buttons: {
            "Edit": function () {
                updateHouseAnnounce();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#newPropertyDialogId').dialog({
        autoOpen: false,
        modal: true,
        show: {
            effect: "blind",
            duration: 1000
        },
        hide: {
            effect: "explode",
            duration: 1000
        },
        title: 'New Property Announcement',
        height: 475,
        width: 400,
        buttons: {
            "Save": function () {
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#newGroundDialogId').dialog({
        autoOpen: false,
        modal: true,
        show: {
            effect: "blind",
            duration: 1000
        },
        hide: {
            effect: "explode",
            duration: 1000
        },
        title: 'New Property Announcement',
        height: 445,
        width: 400,
        buttons: {
            "Save": function () {
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#newUserDialogId').dialog({
        autoOpen: false,
        modal: true,
        show: {
            effect: "blind",
            duration: 1000
        },
        hide: {
            effect: "explode",
            duration: 1000
        },
        title: 'New User',
        height: 460,
        width: 434,
        buttons: {
            "Save": function () {
                addUser();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#dobId').datepicker({
        changeMonth: true,
        changeYear: true
    });

    $('#houseDataBtnId').click(function () {
        $('#newBtnId').show();
        $('#searchDiv').show();
        $('#searchTxtId').val('');
        $('#newBtnId').val('New House Announce');
        getHouseList();
    });

    $('#propertyDataBtnId').click(function () {
        $('#newBtnId').show();
        $('#searchDiv').show();
        $('#searchTxtId').val('');
        $('#newBtnId').val('New Property Announce');
        getPropertyList();
    });

    $('#groundDataBtnId').click(function () {
        $('#newBtnId').show();
        $('#searchDiv').show();
        $('#searchTxtId').val('');
        $('#newBtnId').val('New Ground Announce');
        getGroundList();
    });

    $('#userDataBtnId').click(function () {
        $('#newBtnId').show();
        $('#searchDiv').show();
        $('#searchTxtId').val('');
        $('#newBtnId').val('New User');
        getUsersList();
    });

    $('#logoutId').click(function () {
        logOut();
    });

   /* $('#newBtnId').click(function () {
        $('#newHouseDialogId').dialog('open');
    });*/

    $('.btnDesign').click(function () {
        globBtnId = $(this).attr('id');
    });

    $('#newBtnId').click(function () {
        switch (globBtnId) {
            case 'houseDataBtnId':
                $('#newHouseDialogId').load('cs?action=newHouseAnnounce', function () {
                    $(this).dialog('open');
                });
                break;
            case 'propertyDataBtnId':
                $('#newPropertyDialogId').load('cs?action=newPropertyAnnounce', function () {
                    $(this).dialog('open');
                });
                break;
            case 'groundDataBtnId':
                $('#newGroundDialogId').load('cs?action=newGroundAnnounce', function () {
                    $(this).dialog('open');
                });
                break;
            case 'userDataBtnId':
                $('#newUserDialogId').load('cs?action=newUser', function () {
                    $(this).dialog('open');
                });
                break;
        }
    });

    $('#searchBtnId').click(function () {
        var keyword = $('#searchTxtId').val();

        switch (globBtnId) {
            case 'houseDataBtnId':
                searchHouseAnnounce(keyword);
                break;
            case 'propertyDataBtnId':

                break;
            case 'groundDataBtnId':

                break;
        }
    });

    $('#searchTxtId').keyup(function () {
        var keyword = $(this).val();

        switch (globBtnId) {
            case 'houseDataBtnId':
                searchHouseAnnounce(keyword);
                break;
            case 'propertyDataBtnId':

                break;
            case 'groundDataBtnId':

                break;
        }
    });

});

function getHouseList() {
    $.ajax({
        url: 'cs?action=getHouseList',
        type: 'GET',
        dataType: 'html', //xml, json, html, text
        success: function (data) {
            $('.ui-layout-center').html(data);
        },
        error: function () {
            alert('Error!!!');
        }
    });
}

function getPropertyList() {
    $.ajax({
        url: 'cs?action=getPropertyList',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('.ui-layout-center').html(data);
        },
        error: function () {
            alert('Error!!!');
        }
    });
}

function getGroundList() {
    $.ajax({
        url: 'cs?action=getGroundList',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('.ui-layout-center').html(data);
        },
        error: function () {
            alert('Error!!!');
        }
    });
}

function getUsersList() {
    $.ajax({
        url: 'cs?action=getUsersList',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('.ui-layout-center').html(data);
        },
        error: function () {
            alert('Error!!!');
        }
    });
}


function addHouseAnnounce() {

    var cityCombo = $('#cityComboId').val();
    var districtCombo = $('#districtComboId').val();
    var roomCount = $('#roomNrId').val();
    var area = $('#areaId').val();
    var price = $('#priceId').val();
    var address = $('#addressId').val();
    var anounceTypeCombo = $('#anounceTypeComboId').val();
    var userCombo = $('#usersId').val();
    var contactTypeCombo = $('#contactTypeId').val();
    var contact = $('#contactId').val();

    var data = {
        cityCombo: cityCombo,
        districtCombo: districtCombo,
        roomCount: roomCount,
        area: area,
        price: price,
        address: address,
        anounceTypeCombo: anounceTypeCombo,
        userCombo: userCombo,
        contactTypeCombo: contactTypeCombo,
        contact: contact
    };

    $.ajax({
        url: 'cs?action=addHouseAnnounce',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (data) {
            if(data == 'success') {
                alert('House has been added successfully...');
                getHouseList();
            } else {
                alert('Problem occurred! House cannot been added...');
            }
        }
    });
}

function addUser() {

    var firstName = $('#firstNameId').val();
    var surname = $('#surnameId').val();
    var genderCombo = $('#genderComboId').val();
    var datepicker = $('#datepicker').val();
    var questionCombo = $('#questionComboId').val();
    var secretAnswer = $('#secretAnswerId').val();
    var email = $('#emailId').val();
    var userName = $('#userName1Id').val();
    var roleCombo = $('#roleComboId').val();
    var roleCode = $('#roleCodeId').val();

    var data = {
        firstName: firstName,
        surname: surname,
        genderCombo: genderCombo,
        datepicker: datepicker,
        questionCombo: questionCombo,
        secretAnswer: secretAnswer,
        email: email,
        userName: userName,
        roleCombo: roleCombo,
        roleCode: roleCode
    };

    $.ajax({
        url: 'cs?action=addUser',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (data) {
            if(data == 'success') {
                alert('User has been added successfully...');
                getUsersList();
            } else {
                alert(data);
            }
        }
    });
}

function editHouseAnnounce(houseAnnounceId) {
    globHouseAnnounceId = houseAnnounceId;
    $.ajax({
        url: 'cs?action=editHouseAnnounce',
        type: 'GET',
        data: 'houseAnnounceId='+houseAnnounceId,
        dataType: 'text',
        success: function (data) {
            $('#editHouseDialogId').html(data);
            $('#editHouseDialogId').dialog('open');
        }
    });
}

function updateHouseAnnounce() {
    var cityCombo = $('#cityComboIdU').val();
    var districtCombo = $('#districtComboIdU').val();
    var roomCount = $('#roomNrIdU').val();
    var area = $('#areaIdU').val();
    var price = $('#priceIdU').val();
    var address = $('#addressIdU').val();
    var anounceTypeCombo = $('#anounceTypeComboIdU').val();
    var userCombo = $('#usersIdU').val();
    var contactTypeCombo = $('#contactTypeIdU').val();
    var contact = $('#contactIdU').val();

    var data = {
        cityCombo: cityCombo,
        districtCombo: districtCombo,
        roomCount: roomCount,
        area: area,
        price: price,
        address: address,
        anounceTypeCombo: anounceTypeCombo,
        userCombo: userCombo,
        contactTypeCombo: contactTypeCombo,
        contact: contact,
        houseAnnounceId: globHouseAnnounceId
    };

    $.ajax({
        url: 'cs?action=updateHouseAnnounce',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function (data) {
            if(data == 'success') {
                alert('House has been updated successfully...');
                getHouseList();
            } else {
                alert('Problem occurred! House cannot been updated...');
            }
        }
    });
}

function delHouseAnnounce(houseAnnounceId) {
    var isDelete = confirm("Are you sure to delete?");
    if(isDelete) {
        $.ajax({
            url: 'cs?action=deleteHouseAnnounce',
            type: 'POST',
            data: 'houseAnnounceId='+houseAnnounceId,
            dataType: 'text',
            success: function (data) {
                if(data == 'success') {
                    alert("House has been deleted successfully...");
                    getHouseList();
                } else {
                    alert('Problem occurred! House cannot been deleted...');
                }
            }
        });
    }
}

function approveUsers(userId) {
    var isApprove = confirm("Are you sure to approve?");
    if(isApprove) {
        $.ajax({
            url: 'cs?action=approveUser',
            type: 'POST',
            data: 'userId='+userId,
            dataType: 'text',
            success: function (data) {
                if(data == 'success') {
                    alert("The user has been approved successfully...");
                    getUsersList();
                } else {
                    alert('Problem occurred! The user is not approved...');
                }
            }
        });
    }
}

function searchHouseAnnounce(keyword) {
    $.ajax({
        url: 'cs?action=searchHouseAnnounce',
        type: 'GET',
        data: 'keyword='+keyword,
        dataType: 'html',
        success: function (data) {
            $('.ui-layout-center').html(data);
        }
    });
}

function logOut() {
    var isExit = confirm("Are you sure to logout?");
    if(isExit) {
        $.ajax({
            url: 'cs?action=logout',
            type: 'GET',
            dataType: 'text',
            success: function (data) {
                window.location = "http://localhost:8085/realestate/";
            },
            error: function () {
                alert('Error!!!');
            }
        });
    }
}

function advancedSearchHouse() {
    var advCityCombo = $('#advCityComboId').val();
    var advDistrictCombo = $('#advDistrictComboId').val();
    var advAnnounceTypeCombo = $('#advAnnounceTypeComboId').val();
    var advStartRoom = $('#advStartRoomId').val();
    var advEndRoom = $('#advEndRoomId').val();
    var advStartArea = $('#advStartAreaId').val();
    var advEndArea = $('#advEndAreaId').val();
    var advStartPrice = $('#advStartPriceId').val();
    var advEndPrice = $('#advEndPriceId').val();

    if(advCityCombo == null) {
        advCityCombo = 0;
    }
    if(advDistrictCombo == null) {
        advDistrictCombo = 0;
    }
    if(advAnnounceTypeCombo == null) {
        advAnnounceTypeCombo = 0;
    }
    if(advStartRoom.length === 0) {
        advStartRoom = 0;
    }
    if(advEndRoom.length === 0) {
        advEndRoom = 0;
    }
    if(advStartArea.length === 0){
        advStartArea = 0;
    }
    if(advEndArea.length === 0) {
        advEndArea = 0;
    }
    if(advStartPrice.length === 0) {
        advStartPrice = 0;
    }
    if(advEndPrice.length === 0) {
        advEndPrice = 0;
    }


    var data = {
        advCityCombo: advCityCombo,
        advDistrictCombo: advDistrictCombo,
        advAnnounceTypeCombo: advAnnounceTypeCombo,
        advStartRoom: advStartRoom,
        advEndRoom: advEndRoom,
        advStartArea: advStartArea,
        advEndArea: advEndArea,
        advStartPrice: advStartPrice,
        advEndPrice: advEndPrice
    };

    $.ajax({
        url: 'cs?action=advancedSearchHouse',
        type: 'GET',
        data: data,
        dataType: 'html',
        success: function (data) {
            $('#houseDivId').html(data);
        }
    });
}