<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 06/04/2018
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<option value="0" selected disabled>Please select district for selected city</option>
<c:forEach items="${districtListByCityId}" var="dl">
    <option value="${dl.id}">${dl.name}</option>
</c:forEach>
