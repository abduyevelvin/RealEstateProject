<%@ page import="re.model.GroundAnnouncement" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 02/04/2018
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<GroundAnnouncement> groundAnnouncementList = (List<GroundAnnouncement>) request.getAttribute("groundAnnouncementList"); %>

<script type="text/javascript">
    $(function () {
        $('#GroundAnnounceTblId').DataTable( {
            "pagingType": "full_numbers"
        } );
    });
</script>

<table id="GroundAnnounceTblId" class="display" style="width:100%">
    <thead>
    <tr>
        <th>№</th>
        <th>City</th>
        <th>District</th>
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
    <% for(GroundAnnouncement ga: groundAnnouncementList) { %>
    <tr>
        <td><%= ga.getId() %></td>
        <td><%= ga.getCity().getName() %></td>
        <td><%= ga.getDistrict().getName() %></td>
        <td><%= ga.getArea() %></td>
        <td><%= ga.getAddress() %></td>
        <td><%= ga.getPrice() %></td>
        <td><%= ga.getAnnouncementType().getType() %></td>
        <td><%= ga.getUsers().getName() + " " + ga.getUsers().getSurname() %></td>
        <td><%= ga.getContactType().getType() %></td>
        <td><%= ga.getContact() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

