<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 17/04/2018
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#UsersTableId').DataTable( {
            "pagingType": "full_numbers"
        } );
    });
</script>

<table id="UsersTableId" class="display" style="width:100%">
    <thead>
    <tr>
        <th>№</th>
        <th>Full Name</th>
        <th>Username</th>
        <th>Email</th>
        <th>Password</th>
        <th>Birth Date</th>
        <th>Gender</th>
        <th>Secret Question</th>
        <th>Answer</th>
        <th>Role</th>
        <th>Activity</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Approve</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usersList}" var="ul">
        <tr>
            <td>${ul.id}</td>
            <td>${ul.name} ${ul.surname}</td>
            <td>${ul.username}</td>
            <td>${ul.email}</td>
            <td>${ul.password}</td>
            <td>${ul.dob}</td>
            <td>${ul.genders.gender}</td>
            <td>${ul.questions.question}</td>
            <td>${ul.answer}</td>
            <td>${ul.roles.role}</td>
            <td>${ul.active}</td>
            <td><a href="javascript: editUsers('${ul.id}');">Edit</a></td>
            <c:choose>
                <c:when test="${ul.active == 0}">
                    <td><img src="././images/icons/clear.png" alt="deleted"> &nbsp; &nbsp;  Deleted</td>
                </c:when>
                <c:otherwise>
                    <td><a href="javascript: delUsers('${ul.id}');">Delete</a></td>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${ul.active == 2}">
                    <td><a href="javascript: approveUsers('${ul.id}');">Approve</a></td>
                </c:when>
                <c:otherwise>
                    <td><img src="././images/icons/approve.gif" alt="approved">&nbsp;  Approved</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
