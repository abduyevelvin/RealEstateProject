<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 19/04/2018
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="./js/combo.js"></script>

<script type="text/javascript">
    //Date picker
    $('#datepicker').datepicker({
        changeMonth: true,
        changeYear: true
    });

    $( "#tabs" ).tabs({
        collapsible: true
    });

    $('#roleComboId').change(function () {
        if (this.selectedIndex == 1) {
            $('#roleCodeId').show();
            $('#roleCodeDivId').show();
        } else if(this.selectedIndex == 2) {
            $('#roleCodeId').hide();
            $('#roleCodeDivId').hide();
        }
    });

    $('#userName1Id').keyup(function () {
        checkUserName($(this).val());
    });
</script>

<div id="tabs">
    <ul>
        <li><a href="#tabs-1">Private Info</a></li>
        <li><a href="#tabs-2">Credentials</a></li>
    </ul>
    <div id="tabs-1">
        <div class="lblDesign"><label for="firstNameId">First Name:</label></div><input type="text" class="lblInput" id="firstNameId" placeholder="Enter First Name" required> <br>
        <div class="lblDesign"><label for="surnameId">Surname:</label></div><input type="text" class="lblInput" id="surnameId" placeholder="Enter Surname" required> <br>
        <div class="lblDesign">Gender:</div>
        <select id="genderComboId" class="cmbDesign" required>
            <option value="0" disabled selected>Select Gender</option>
            <c:forEach items="${gendersList}" var="gl">
                <option value="${gl.id}">${gl.gender}</option>
            </c:forEach>
        </select><br>
        <div class="lblDesign"><label for="datepicker">Birth Date:</label></div><input type="text" class="lblInput" id="datepicker" placeholder="Enter Birth Date" required> <br>
        <div class="lblDesign">Secret Question:</div>
        <select id="questionComboId" class="cmbDesign" required>
            <option value="0" disabled selected>Select Secret Question</option>
            <c:forEach items="${questionsList}" var="ql">
                <option value="${ql.id}">${ql.question}</option>
            </c:forEach>
        </select><br>
        <div class="lblAddress"><label for="secretAnswerId">Answer:</label></div><textarea class="lblInput" id="secretAnswerId" placeholder="Enter Secret Answer..." rows="3" cols="30" required></textarea> <br>
        <div class="lblDesign"><label for="emailId">Email:</label></div><input class="lblInput" type="email" name="email" id="emailId" placeholder="Enter Email" required pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}">
    </div>
    <div id="tabs-2">
        <div class="lblDesign"><label for="userName1Id">Username:</label></div><input type="text" class="lblInput" id="userName1Id" placeholder="Enter Username" required> <br>
        <div class="lblDesign">Role:</div>
        <select id="roleComboId" class="cmbDesign" required>
            <option value="0" disabled selected>Select Role</option>
            <c:forEach items="${rolesList}" var="rl">
                <option value="${rl.id}">${rl.role}</option>
            </c:forEach>
        </select><br>
        <div class="lblDesign" id="roleCodeDivId" style="display: none"><label for="roleCodeId">Role Code:</label></div><input class="lblInput" type="text"  id="roleCodeId" placeholder="Enter role code" value="0" style="display: none;">
    </div>
</div>

<div id="usernameInfoId" title="Username info" style="display:none;">
    <p>
        <span class="ui-icon ui-icon-info" style="float:left; margin:0 7px 50px 0;"></span>
        <span>This username is already taken.</span>
    </p>
</div>
