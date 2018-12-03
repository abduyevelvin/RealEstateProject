<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 23/04/2018
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="us?action=upload" method="post" enctype="multipart/form-data">

    File: <input type="file" name="fileName"><br>
    Name: <input type="text" name="studentName"><br>
    <input type="submit" value="Send">

</form>

</body>
</html>
