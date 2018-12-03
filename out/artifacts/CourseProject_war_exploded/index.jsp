<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 29/03/2018
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Real Estate</title>
  <link rel="shortcut icon" type="image/x-icon" href="images/icons/realestate.png">
  <script type="text/javascript" src="js/jquery/jquery-latest.js"></script>
  <script type="text/javascript" src="js/jquery/jquery.layout-latest.js"></script>
  <script type="text/javascript" src="js/jquery/jquery-ui.js"></script>
  <script type="text/javascript" src="js/jquery/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="js/main.js"></script>
  <script type="text/javascript" src="js/combo.js"></script>

  <link rel="stylesheet" type="text/css" href="css/main.css" />
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
  <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css" />

    <script type="text/javascript">
        history.pushState(null, null, 'index.jsp');
        window.addEventListener('popstate', function (event) {
            history.pushState(null, null, 'index.jsp');
        });
    </script>

</head>
<body>
<div class="ui-layout-north">
  <h1 style="margin-bottom:0; text-align: center">RE Project</h1>
    <div style="margin-left: 79%; margin-top: 1%; color: #505050; font-weight: bold; text-shadow: 3px 3px #fff">Welcome, ${users.name} ${users.surname}. You are ${users.roles.role}...
        <input type="button" value="Logout" id="logoutId" class="logoutBtn">
    </div>
</div>
<div class="ui-layout-center">

</div>
<div class="ui-layout-west">
  <input type="button" class="btnDesign" id="houseDataBtnId" value="House Announcement" /> <br />
  <input type="button" class="btnDesign" id="propertyDataBtnId" value="Property Announcement" /> <br />
  <input type="button" class="btnDesign" id="groundDataBtnId" value="Ground Announcement" /> <br />

    <c:if test="${users.roles.role eq 'admin'}">
        <c:choose>
            <c:when test="${count > 0}">
                <input type="button" class="btnDesign" id="userDataBtnId" value="Users + ${count} new" > <br>
            </c:when>
            <c:otherwise>
                <input type="button" class="btnDesign" id="userDataBtnId" value="Users"> <br>
            </c:otherwise>
        </c:choose>
    </c:if>
</div>
<div class="ui-layout-east">
    <c:if test="${users.roles.role eq 'admin'}">
        <input type="button" class="btnDesign1" id="newBtnId" value="New" style="display: none">
    </c:if>
    <div id="searchDiv" hidden style="margin-top: 10px;">
        <input type="text" class="lblDesign1" id="searchTxtId" placeholder="Search..." style="height: 22px; width: 76%;">&nbsp;
        <input type="button" id="searchBtnId" style="background-image: url('images/icons/searchIcon.png'); background-size: cover; height: 28px; width: 16%;">
    </div>
</div>
<div class="ui-layout-south">
  <div style="text-align: center">Copyright © Elvin Abduyev</div>
</div>
<div id="newHouseDialogId"></div>
<div id="newPropertyDialogId"></div>
<div id="newGroundDialogId"></div>
<div id="newUserDialogId"></div>
<div id="editHouseDialogId"></div>
</body>
</html>