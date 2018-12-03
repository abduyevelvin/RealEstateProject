<%@ page import="java.util.List" %>
<%@ page import="re.model.PropertyAnnouncement" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/1/2018
  Time: 1:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<PropertyAnnouncement> propertyAnnouncementList = (List<PropertyAnnouncement>) request.getAttribute("propertyAnnouncementList"); %>

<script type="text/javascript">
    $(function () {
        $('#PropertyAnnounceTblId').DataTable( {
            "pagingType": "full_numbers"
        } );
    });
</script>

<table id="PropertyAnnounceTblId" class="display" style="width:100%">
    <thead>
    <tr>
        <th>№</th>
        <th>City</th>
        <th>District</th>
        <th>Room N#</th>
        <th>Area</th>
        <th>Address</th>
        <th>Price</th>
        <th>Announcement Type</th>
        <th>Announcement Owner</th>
        <th>Contact Type</th>
        <th>Contact</th>
    </tr>
    </thead>
    <tbody>
    <% for(PropertyAnnouncement pa: propertyAnnouncementList) { %>
    <tr>
        <td><%= pa.getId() %></td>
        <td><%= pa.getCity().getName() %></td>
        <td><%= pa.getDistrict().getName() %></td>
        <td><%= pa.getRoom_nr() %></td>
        <td><%= pa.getArea() %></td>
        <td><%= pa.getAddress() %></td>
        <td><%= pa.getPrice() %></td>
        <td><%= pa.getAnnouncementType().getType() %></td>
        <td><%= pa.getUsers().getName() + " " + pa.getUsers().getSurname() %></td>
        <td><%= pa.getContactType().getType() %></td>
        <td><%= pa.getContact() %></td>
    </tr>
    <% } %>
    </tbody>
</table>