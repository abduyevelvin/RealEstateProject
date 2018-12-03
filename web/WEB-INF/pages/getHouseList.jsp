<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="re.model.HouseAnnouncement" %>
<%@ page import="re.model.District" %><%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 30/03/2018
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<HouseAnnouncement> houseAnnouncementList = (List<HouseAnnouncement>) request.getAttribute("houseAnnouncementList"); %>

<script type="text/javascript">

    $(function () {

        $( "#accordion" ).accordion({
            collapsible: true,
            active: false
        });

        $('#HouseAnnounceTblId').DataTable( {
            "pagingType": "full_numbers"
        } );

        $('#advClearBtnId').click(function () {
            $('#advCityComboId').prop('selectedIndex',0);
            $('#advDistrictComboId').prop('disabled', true);
            $('#advDistrictComboId').prop('selectedIndex',0);
            $('#advAnnounceTypeComboId').prop('selectedIndex',0);
            $('#advStartRoomId').val('');
            $('#advEndRoomId').val('');
            $('#advStartAreaId').val('');
            $('#advEndAreaId').val('');
            $('#advStartPriceId').val('');
            $('#advEndPriceId').val('');
            getHouseList();
            $('#accordion').active(false);
        });

        $('#advEndRoomId').focusout(function () {
            var start = parseInt($('#advStartRoomId').val());
            var end = parseInt($('#advEndRoomId').val());
            if(end <= start) {
                $(this).focus();
                alert('Please enter bigger number than start');
            }
        });

        $('#advEndAreaId').focusout(function () {
            var start = parseInt($('#advStartAreaId').val());
            var end = parseInt($('#advEndAreaId').val());
            if(end <= start) {
                $(this).focus();
                alert('Please enter bigger area than start');
            }
        });

        $('#advEndPriceId').focusout(function () {
            var start = parseInt($('#advStartPriceId').val());
            var end = parseInt($('#advEndPriceId').val());
            if(end <= start) {
                $(this).focus();
                alert('Please enter bigger price than start');
            }
        });

        $('#advStartAreaId').keyup(function () {
            var start = $(this).val();
            $('#advEndAreaId').attr('placeholder', 'Enter value bigger than ' + start);
        });

        $('#advStartRoomId').keyup(function () {
            var start = $(this).val();
            $('#advEndRoomId').attr('placeholder', 'Enter value bigger than ' + start);
        });

        $('#advStartPriceId').keyup(function () {
            var start = $(this).val();
            $('#advEndPriceId').attr('placeholder', 'Enter value bigger than ' + start);
        });

        $('#advCityComboId').change(function () {
            $('#advDistrictComboId').prop('disabled', false);
            getDistrictListByCityId($(this).val());
        });

        $('#advSearchBtnId').click(function () {
            advancedSearchHouse();
        });
    });
</script>

<div id="accordion">
    <h3>Advanced Search</h3>
    <div>
        <select id="advCityComboId" class="advCmbDesign">
            <option value="0" selected disabled>Please select city</option>
            <c:forEach items="${cityList}" var="cl">
                <option value="${cl.id}">${cl.name}</option>
            </c:forEach>
        </select>&nbsp;
        <select id="advDistrictComboId" class="advCmbDesign" disabled>
            <option value="0" selected disabled>Please select district after city choice</option>
            <c:forEach items="${districtList}" var="dl">
                <option value="${dl.id}">${dl.name}</option>
            </c:forEach>
        </select>&nbsp;
        <select id="advAnnounceTypeComboId" class="advCmbDesign">
            <option value="0" selected disabled>Please select announce type</option>
            <c:forEach items="${announcementTypeList}" var="at">
                <option value="${at.id}">${at.type}</option>
            </c:forEach>
        </select><br>
        <input type="number" id="advStartRoomId" min="0" class="lblAdvInput" placeholder="Enter lowest room count">&nbsp;
        <input type="number" id="advEndRoomId" min="0" class="lblAdvInput" placeholder="Enter highest room count"><br>
        <input type="text" id="advStartAreaId" class="lblAdvInput" placeholder="Enter lowest area">&nbsp;
        <input type="text" id="advEndAreaId" class="lblAdvInput" placeholder="Enter highest area"><br>
        <input type="text" id="advStartPriceId" class="lblAdvInput" placeholder="Enter lowest price">&nbsp;
        <input type="text" id="advEndPriceId" class="lblAdvInput" placeholder="Enter highest price"><br>
        <input type="button" value="Clear" id="advClearBtnId" class="advClearBtn">
        <input type="button" value="Search" id="advSearchBtnId" class="advSearchBtn">
        <br>
    </div>
</div>
<br>

<div id="houseDivId">
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
        <% for(HouseAnnouncement ha: houseAnnouncementList) { %>
        <tr>
            <td><%= ha.getId() %></td>
            <td><%= ha.getCity().getName() %></td>
            <td><%= ha.getDistrict().getName() %></td>
            <td><%= ha.getRoom_nr() %></td>
            <td><%= ha.getArea() %></td>
            <td><%= ha.getAddress() %></td>
            <td><%= ha.getPrice() %></td>
            <td><%= ha.getAnnouncementType().getType() %></td>
            <td><%= ha.getUsers().getName() + " " + ha.getUsers().getSurname() %></td>
            <td><%= ha.getContactType().getType() %></td>
            <td><%= ha.getContact() %></td>
            <c:if test="${users.roles.role eq 'admin'}">
                <td><a href="javascript: editHouseAnnounce('<%=ha.getId() %>');">Edit</a></td>
                <td><a href="javascript: delHouseAnnounce('<%=ha.getId() %>');">Delete</a></td>
            </c:if>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>