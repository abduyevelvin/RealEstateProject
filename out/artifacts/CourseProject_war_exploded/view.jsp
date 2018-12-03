<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 23/04/2018
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

${message}
<br>

<form action="us?action=download" method="post">
    <input type="hidden" name="fileName" value="${imagePath}" style="width: 100%">
    <input type="submit" value="Download">
</form>

<br>

<img src="${imagePath2}" height="400" width="400">