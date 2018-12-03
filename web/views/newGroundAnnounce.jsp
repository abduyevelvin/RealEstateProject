<%@ page import="java.util.List" %>
<%@ page import="re.model.*" %><%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 04/04/2018
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  List<City> cityList = (List<City>) request.getAttribute("cityList");
    List<District> districtList = (List<District>) request.getAttribute("districtList");
    List<AnnouncementType> announcementTypeList = (List<AnnouncementType>) request.getAttribute("announcementTypeList");
    List<ContactType> contactTypeList = (List<ContactType>) request.getAttribute("contactTypeList");
    List<Users> usersList = (List<Users>) request.getAttribute("usersList");
%>

<div class="lblDesign">City:</div>
<select id="cityComboId" class="cmbDesign" required>
    <option value="0" disabled selected>Select City</option>
    <% for(City c: cityList) { %>
    <option value="<%=c.getId() %>"><%=c.getName() %></option>
    <% } %>
</select><br>
<div class="lblDesign">District:</div>
<select id="districtComboId" class="cmbDesign" required>
    <option value="0" disabled selected>Select District</option>
    <% for(District d: districtList) { %>
    <option value="<%=d.getId() %>"><%=d.getName() %></option>
    <% } %>
</select><br>
<div class="lblDesign"><label for="areaId">Area:</label></div><input type="text" class="lblInput" id="areaId" placeholder="Enter area" required> <br>
<div class="lblDesign"><label for="priceId">Price:</label></div><input type="text" class="lblInput" id="priceId" placeholder="Enter price" required> <br>
<div class="lblAddress"><label for="addressId">Address:</label></div><textarea class="lblInput" id="addressId" placeholder="Enter address" rows="3" cols="30" required></textarea> <br>
<div class="lblDesign">Announce Type:</div>
<select id="anounceTypeComboId" class="cmbDesign" required>
    <option value="0" disabled selected>Select Announce Type</option>
    <% for(AnnouncementType at: announcementTypeList) { %>
    <option value="<%=at.getId() %>"><%=at.getType() %></option>
    <% } %>
</select><br>
<div class="lblDesign">User:</div>
<select id="usersId" class="cmbDesign" required>
    <option value="0" disabled selected>Select User</option>
    <% for(Users u: usersList) { %>
    <option value="<%=u.getId() %>"><%=u.getName() + ' ' + u.getSurname() %></option>
    <% } %>
</select><br>
<div class="lblDesign">Contact Type:</div>
<select id="contactTypeId" class="cmbDesign" required>
    <option value="0" disabled selected>Select Contact Type</option>
    <% for(ContactType ct: contactTypeList) { %>
    <option value="<%=ct.getId() %>"><%=ct.getType() %></option>
    <% } %>
</select><br>
<div class="lblDesign"><label for="contactId">Contact:</label></div><input type="text" class="lblInput" id="contactId" placeholder="Enter your contact" required> <br>
