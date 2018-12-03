<%@ page import="java.util.List" %>
<%@ page import="re.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 04/04/2018
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {

        $('#cityComboIdU').change(function () {
            getDistrictListByCityIdEdit($(this).val());
        });
    });
</script>

<%  List<City> cityList = (List<City>) request.getAttribute("cityList");
    List<District> districtList = (List<District>) request.getAttribute("districtList");
    List<AnnouncementType> announcementTypeList = (List<AnnouncementType>) request.getAttribute("announcementTypeList");
    List<ContactType> contactTypeList = (List<ContactType>) request.getAttribute("contactTypeList");
    List<Users> usersList = (List<Users>) request.getAttribute("usersList");
%>

<div class="lblDesign">City:</div>
<select id="cityComboIdU" class="cmbDesign">
    <option value="${houseAnnouncement.city.id}" selected>${houseAnnouncement.city}</option>
    <c:forEach items="${cityList}" var="cl">
        <option value="${cl.id}">${cl.name}</option>
    </c:forEach>
</select><br>
<div class="lblDesign">District:</div>
<select id="districtComboIdU" class="cmbDesign">
    <option value="${houseAnnouncement.district.id}" selected>${houseAnnouncement.district}</option>
    <c:forEach items="${districtList}" var="dl">
        <option value="${dl.id}">${dl.name}</option>
    </c:forEach>
</select><br>
<div class="lblDesign"><label for="roomNrIdU">Room N#:</label></div><input type="number" min="0" class="lblInput" id="roomNrIdU" value="${houseAnnouncement.room_nr}"> <br>
<div class="lblDesign"><label for="areaIdU">Area:</label></div><input type="text" class="lblInput" id="areaIdU" value="${houseAnnouncement.area}"> <br>
<div class="lblDesign"><label for="priceIdU">Price:</label></div><input type="text" class="lblInput" id="priceIdU" value="${houseAnnouncement.price}"> <br>
<div class="lblAddress"><label for="addressIdU">Address:</label></div><textarea class="lblInput" id="addressIdU" rows="3" cols="30">${houseAnnouncement.address}</textarea> <br>
<div class="lblDesign">Announce Type:</div>
<select id="anounceTypeComboIdU" class="cmbDesign">
    <option value="${houseAnnouncement.announcementType.id}" selected>${houseAnnouncement.announcementType}</option>
    <c:forEach items="${announcementTypeList}" var="at">
        <option value="${at.id}">${at.type}</option>
    </c:forEach>
</select><br>
<div class="lblDesign">User:</div>
<select id="usersIdU" class="cmbDesign">
    <option value="${houseAnnouncement.users.id}" selected>${houseAnnouncement.users.name} ${houseAnnouncement.users.surname}</option>
    <c:forEach items="${usersList}" var="ul">
        <option value="${ul.id}">${ul.name} ${ul.surname}</option>
    </c:forEach>
</select><br>
<div class="lblDesign">Contact Type:</div>
<select id="contactTypeIdU" class="cmbDesign">
    <option value="${houseAnnouncement.contactType.id}" selected>${houseAnnouncement.contactType}</option>
    <c:forEach items="${contactTypeList}" var="ct">
        <option value="${ct.id}">${ct.type}</option>
    </c:forEach>
</select><br>
<div class="lblDesign"><label for="contactIdU">Contact:</label></div><input type="text" class="lblInput" id="contactIdU" value="${houseAnnouncement.contact}"> <br>