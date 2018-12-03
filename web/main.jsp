<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 29/03/2018
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="images/icons/realestate.png">
    <script type="text/javascript" src="js/jquery/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css" />
    <title>Real Estate</title>
</head>
<body>
<div id="container" style="width: 100%; height: 84%">
    <div id="header" style="height:90px; border: 1px solid; text-align: center">
        <h1 style="margin-bottom:0;">RE Project</h1>
    </div>
    <div id="menu"  style="height:100%;width:14.7%;float:left; border: 1px solid">
        <input type="button" class="btnDesign" id="houseDataBtnId" value="House Announcement" /> <br />
        <input type="button" class="btnDesign" id="propertyDataBtnId" value="Property Announcement" /> <br />
        <input type="button" class="btnDesign" id="groundDataBtnId" value="Ground Announcement" /> <br />
    </div>
    <div id="content" style="height:100%;width:85%;float:left; border: 1px solid">
        <%--   <table border="1" style="width: 100%; display: none" id="HouseAnnounceTblId">
               <thead>
                   <tr>
                       <th>No</th>
                       <th>Ad</th>
                       <th>Soyad</th>
                       <th>Unvan</th>
                   </tr>
               </thead>
               <tbody>
                   <tr>
                       <td>1</td>
                       <td>Elvin</td>
                       <td>Abduyev</td>
                       <td>Xirdalan</td>
                   </tr>
                   <tr>
                       <td>2</td>
                       <td>Mehman</td>
                       <td>Almardanov</td>
                       <td>Baki</td>
                   </tr>
                   <tr>
                       <td>3</td>
                       <td>Malik</td>
                       <td>Mammadli</td>
                       <td>Elmler</td>
                   </tr>
               </tbody>
           </table> --%>
    </div>
    <div id="footer" style="border: 1px solid; clear:both;text-align:center">
        Copyright © Elvin Abduyev
    </div> </div>
</body>
</html>
