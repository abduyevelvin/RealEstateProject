<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 09/04/2018
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $('#HouseAnnounceTblId').DataTable( {
        "pagingType": "full_numbers"
    } );
</script>

<table id="HouseAnnounceTblId" class="display" style="width:100%">
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
        <c:if test="${users.roles.role eq 'admin'}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${houseAnnouncementList}" var="ha">
        <tr>
            <td>${ha.id}</td>
            <td>${ha.city.name}</td>
            <td>${ha.district.name}</td>
            <td>${ha.room_nr}</td>
            <td>${ha.area}</td>
            <td>${ha.address}</td>
            <td>${ha.price}</td>
            <td>${ha.announcementType.type}</td>
            <td>${ha.users.name} ${ha.users.surname}</td>
            <td>${ha.contactType.type}</td>
            <td>${ha.contact}</td>
            <c:if test="${users.roles.role eq 'admin'}">
                <td><a href="javascript: editHouseAnnounce('${ha.id}');">Edit</a></td>
                <td><a href="javascript: delHouseAnnounce('${ha.id}');">Delete</a></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>