package re.web;

import re.dao.GeneralDao;
import re.dao.GroundAnnounceDao;
import re.dao.HouseAnnounceDao;
import re.dao.PropertyAnnounceDao;
import re.dao.impl.GeneralDaoImpl;
import re.dao.impl.GroundAnnounceDaoImpl;
import re.dao.impl.HouseAnnounceDaoImpl;
import re.dao.impl.PropertyAnnounceDaoImpl;
import re.model.*;
import re.service.GeneralService;
import re.service.GroundAnnounceService;
import re.service.HouseAnnounceService;
import re.service.PropertyAnnounceService;
import re.service.impl.GeneralServiceImpl;
import re.service.impl.GroundAnnounceServiceImpl;
import re.service.impl.HouseAnnounceServiceImpl;
import re.service.impl.PropertyAnnounceServiceImpl;
import re.util.MethodConstants;
import re.util.Methods;

import javax.management.relation.Role;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ControllerServlet", urlPatterns = "/cs")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String action = null;
        String address = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        HouseAnnounceDao houseAnnounceDao = new HouseAnnounceDaoImpl();
        HouseAnnounceService houseAnnounceService = new HouseAnnounceServiceImpl(houseAnnounceDao);

        PropertyAnnounceDao propertyAnnounceDao = new PropertyAnnounceDaoImpl();
        PropertyAnnounceService propertyAnnounceService = new PropertyAnnounceServiceImpl(propertyAnnounceDao);

        GroundAnnounceDao groundAnnounceDao = new GroundAnnounceDaoImpl();
        GroundAnnounceService groundAnnounceService = new GroundAnnounceServiceImpl(groundAnnounceDao);

        GeneralDao generalDao = new GeneralDaoImpl();
        GeneralService generalService = new GeneralServiceImpl(generalDao);

        if(request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        try{
            if(action.equalsIgnoreCase(MethodConstants.GET_HOUSE_LIST)) {
                HttpSession session = request.getSession(false);
                if(session != null) {
                    List<HouseAnnouncement> houseAnnouncementList = houseAnnounceService.getHouseAnnouncementList();
                    List<City> cityList = generalService.getCityList();
                    List<District> districtList = generalService.getDistrictList();
                    List<AnnouncementType> announcementTypeList = generalService.getAnnouncementTypeList();
                    request.setAttribute("houseAnnouncementList", houseAnnouncementList);
                    request.setAttribute("cityList", cityList);
                    request.setAttribute("districtList", districtList);
                    request.setAttribute("announcementTypeList", announcementTypeList);
                    address = "WEB-INF/pages/getHouseList.jsp";
                }
            } else if(action.equalsIgnoreCase(MethodConstants.GET_USERS_LIST)) {
                HttpSession session = request.getSession(false);
                if(session != null) {
                    List<Users> usersList = generalService.getUsersList();
                    request.setAttribute("usersList", usersList);
                    address = "WEB-INF/pages/getUsersList.jsp";
                }
            } else if(action.equalsIgnoreCase("registration")) {
                List<Questions> questionsList = generalService.getQuestionsList();
                List<Roles> rolesList = generalService.getRolesList();
                List<Genders> gendersList = generalService.getGendersList();
                request.setAttribute("questionsList", questionsList);
                request.setAttribute("rolesList", rolesList);
                request.setAttribute("gendersList", gendersList);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if(action.equalsIgnoreCase(MethodConstants.GET_DISTRICT_LIST_BY_CITY_ID)) {
                int cityId = Integer.parseInt(request.getParameter("cityId"));
                List<District> districtListByCityId = generalService.getDistrictListByCityId(cityId);
                request.setAttribute("districtListByCityId", districtListByCityId);
                address = "WEB-INF/pages/getDistrictListByCityId.jsp";
            } else if (action.equalsIgnoreCase(MethodConstants.GET_PROPERTY_LIST)) {
                List<PropertyAnnouncement> propertyAnnouncementList = propertyAnnounceService.getPropertyAnnouncementList();
                request.setAttribute("propertyAnnouncementList", propertyAnnouncementList);
                address = "WEB-INF/pages/getPropertyList.jsp";
            } else if(action.equalsIgnoreCase(MethodConstants.GET_GROUND_LIST)) {
                List<GroundAnnouncement> groundAnnouncementList = groundAnnounceService.getGroundAnnouncementList();
                request.setAttribute("groundAnnouncementList", groundAnnouncementList);
                address = "WEB-INF/pages/getGroundList.jsp";
            } else if(action.equalsIgnoreCase(MethodConstants.NEW_HOUSE_ANNOUNCE)) {
                List<City> cityList = generalService.getCityList();
                List<District> districtList = generalService.getDistrictList();
                List<AnnouncementType> announcementTypeList = generalService.getAnnouncementTypeList();
                List<ContactType> contactTypeList = generalService.getContactTypeList();
                List<Users> usersList = generalDao.getUsersList();
                request.setAttribute("cityList", cityList);
                request.setAttribute("districtList", districtList);
                request.setAttribute("announcementTypeList", announcementTypeList);
                request.setAttribute("contactTypeList", contactTypeList);
                request.setAttribute("usersList", usersList);
                address = "views/newHouseAnnounce.jsp";
            } else if(action.equalsIgnoreCase(MethodConstants.NEW_USER)) {
                List<Genders> gendersList = generalService.getGendersList();
                List<Questions> questionsList = generalService.getQuestionsList();
                List<Roles> rolesList = generalService.getRolesList();
                request.setAttribute("gendersList",gendersList);
                request.setAttribute("questionsList", questionsList);
                request.setAttribute("rolesList", rolesList);
                address = "views/newUser.jsp";
            } else if(action.equalsIgnoreCase(MethodConstants.NEW_PROPERTY_ANNOUNCE)) {
                List<City> cityList = generalService.getCityList();
                List<District> districtList = generalService.getDistrictList();
                List<AnnouncementType> announcementTypeList = generalService.getAnnouncementTypeList();
                List<ContactType> contactTypeList = generalService.getContactTypeList();
                List<Users> usersList = generalDao.getUsersList();
                request.setAttribute("cityList", cityList);
                request.setAttribute("districtList", districtList);
                request.setAttribute("announcementTypeList", announcementTypeList);
                request.setAttribute("contactTypeList", contactTypeList);
                request.setAttribute("usersList", usersList);
                address = "views/newPropertyAnnounce.jsp";
            } else if(action.equalsIgnoreCase(MethodConstants.NEW_GROUND_ANNOUNCE)) {
                List<City> cityList = generalService.getCityList();
                List<District> districtList = generalService.getDistrictList();
                List<AnnouncementType> announcementTypeList = generalService.getAnnouncementTypeList();
                List<ContactType> contactTypeList = generalService.getContactTypeList();
                List<Users> usersList = generalDao.getUsersList();
                request.setAttribute("cityList", cityList);
                request.setAttribute("districtList", districtList);
                request.setAttribute("announcementTypeList", announcementTypeList);
                request.setAttribute("contactTypeList", contactTypeList);
                request.setAttribute("usersList", usersList);
                address = "views/newGroundAnnounce.jsp";
            } else if(action.equalsIgnoreCase(MethodConstants.ADD_HOUSE_ANNOUNCE)) {
                HouseAnnouncement ha = new HouseAnnouncement();
                int cityCombo = Integer.parseInt(request.getParameter("cityCombo"));
                int districtCombo = Integer.parseInt(request.getParameter("districtCombo"));
                int roomCount = Integer.parseInt(request.getParameter("roomCount"));
                double area = Double.parseDouble(request.getParameter("area"));
                double price = Double.parseDouble(request.getParameter("price"));
                String addressHouse = request.getParameter("address");
                int anounceTypeCombo = Integer.parseInt(request.getParameter("anounceTypeCombo"));
                int userCombo = Integer.parseInt(request.getParameter("userCombo"));
                int contactTypeCombo = Integer.parseInt(request.getParameter("contactTypeCombo"));
                String contact = request.getParameter("contact");
                City c = new City();
                c.setId(cityCombo);
                District d = new District();
                d.setId(districtCombo);
                AnnouncementType at = new AnnouncementType();
                at.setId(anounceTypeCombo);
                Users u = new Users();
                u.setId(userCombo);
                ContactType ct = new ContactType();
                ct.setId(contactTypeCombo);
                ha.setCity(c);
                ha.setDistrict(d);
                ha.setRoom_nr(roomCount);
                ha.setArea(area);
                ha.setPrice(price);
                ha.setAddress(addressHouse);
                ha.setAnnouncementType(at);
                ha.setUsers(u);
                ha.setContactType(ct);
                ha.setContact(contact);
                boolean isAdded = houseAnnounceService.addHouseAnnounce(ha);
                response.setContentType("text/html");
                if(isAdded){
                    pw.print("success");
                } else {
                    pw.print("failed");
                }
            } else if(action.equalsIgnoreCase(MethodConstants.ADD_USER)) {
                Users users = new Users();
                String firstName = request.getParameter("firstName");
                String surname = request.getParameter("surname");
                int genderCombo = Integer.parseInt(request.getParameter("genderCombo"));
                String datepicker = request.getParameter("datepicker");
                Date dob = dateFormat.parse(datepicker);
                int questionCombo = Integer.parseInt(request.getParameter("questionCombo"));
                String secretAnswer = request.getParameter("secretAnswer");
                String email = request.getParameter("email");
                String userName = request.getParameter("userName");
                int roleCombo = Integer.parseInt(request.getParameter("roleCombo"));
                int roleCode = Integer.parseInt(request.getParameter("roleCode"));
                Genders genders = new Genders();
                genders.setId(genderCombo);
                Questions questions = new Questions();
                questions.setId(questionCombo);
                Roles roles = new Roles();
                roles.setId(roleCombo);
                //UUID code = UUID.randomUUID();
                String pass = Methods.generatePassword();

                users.setName(firstName);
                users.setSurname(surname);
                users.setGenders(genders);
                users.setDob(dob);
                users.setQuestions(questions);
                users.setAnswer(secretAnswer);
                users.setEmail(email);
                users.setUsername(userName);
                users.setRoles(roles);
                users.setAdmin_code(roleCode);
                //users.setPassword(code.toString());
                //users.setConfirm_pass(code.toString());
                users.setPassword(pass);
                users.setConfirm_pass(pass);
                boolean isSent = Methods.sendMail("Login Password", "Your password is: " + pass, email);
                boolean isAdded = generalService.registrationUsers(users);
                response.setContentType("text/html");
                if(isAdded && isSent){
                    pw.print("success");
                } else {
                    pw.print("failed");
                }
            } else if(action.equalsIgnoreCase(MethodConstants.EDIT_HOUSE_ANNOUNCE)) {
                int houseAnnounceId = Integer.parseInt(request.getParameter("houseAnnounceId"));
                HouseAnnouncement houseAnnouncement = houseAnnounceService.getHouseAnnouncementById(houseAnnounceId);
                List<City> cityList = generalService.getCityList();
                List<District> districtList = generalService.getDistrictList();
                List<AnnouncementType> announcementTypeList = generalService.getAnnouncementTypeList();
                List<ContactType> contactTypeList = generalService.getContactTypeList();
                List<Users> usersList = generalDao.getUsersList();
                request.setAttribute("houseAnnouncement", houseAnnouncement);
                request.setAttribute("cityList", cityList);
                request.setAttribute("districtList", districtList);
                request.setAttribute("announcementTypeList", announcementTypeList);
                request.setAttribute("contactTypeList", contactTypeList);
                request.setAttribute("usersList", usersList);
                address = "views/editHouseAnnounce.jsp";
            } else if(action.equalsIgnoreCase(MethodConstants.UPDATE_HOUSE_ANNOUNCE)) {
                int houseAnnounceId = Integer.parseInt(request.getParameter("houseAnnounceId"));
                HouseAnnouncement ha = new HouseAnnouncement();
                int cityCombo = Integer.parseInt(request.getParameter("cityCombo"));
                int districtCombo = Integer.parseInt(request.getParameter("districtCombo"));
                int roomCount = Integer.parseInt(request.getParameter("roomCount"));
                double area = Double.parseDouble(request.getParameter("area"));
                double price = Double.parseDouble(request.getParameter("price"));
                String addressHouse = request.getParameter("address");
                int anounceTypeCombo = Integer.parseInt(request.getParameter("anounceTypeCombo"));
                int userCombo = Integer.parseInt(request.getParameter("userCombo"));
                int contactTypeCombo = Integer.parseInt(request.getParameter("contactTypeCombo"));
                String contact = request.getParameter("contact");
                City c = new City();
                c.setId(cityCombo);
                District d = new District();
                d.setId(districtCombo);
                AnnouncementType at = new AnnouncementType();
                at.setId(anounceTypeCombo);
                Users u = new Users();
                u.setId(userCombo);
                ContactType ct = new ContactType();
                ct.setId(contactTypeCombo);
                ha.setCity(c);
                ha.setDistrict(d);
                ha.setRoom_nr(roomCount);
                ha.setArea(area);
                ha.setPrice(price);
                ha.setAddress(addressHouse);
                ha.setAnnouncementType(at);
                ha.setUsers(u);
                ha.setContactType(ct);
                ha.setContact(contact);
                boolean isUpdated = houseAnnounceService.updateHouseAnnounce(ha, houseAnnounceId);
                response.setContentType("text/html");
                if(isUpdated){
                    pw.print("success");
                } else {
                    pw.print("failed");
                }
            } else if(action.equalsIgnoreCase(MethodConstants.DELETE_HOUSE_ANNOUNCE)) {
                int houseAnnounceId = Integer.parseInt(request.getParameter("houseAnnounceId"));
                boolean isDeleted = houseAnnounceService.deleteHouseAnnounce(houseAnnounceId);
                response.setContentType("text/html");
                if(isDeleted){
                    pw.print("success");
                } else {
                    pw.print("failed");
                }
            } else if(action.equalsIgnoreCase(MethodConstants.APPROVE_USER)) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                boolean isApproved = generalService.approveUser(userId);
                response.setContentType("text/html");
                if(isApproved){
                    pw.print("success");
                } else {
                    pw.print("failed");
                }
            } else if(action.equalsIgnoreCase(MethodConstants.CHECK_USER_NAME)) {
                String userName = request.getParameter("userName");
                boolean isExist = generalService.checkUserName(userName);
                response.setContentType("text/html");
                if(isExist) {
                    pw.print("success");
                } else {
                    pw.print("failed");
                }
            } else if(action.equalsIgnoreCase(MethodConstants.SEARCH_HOUSE_ANNOUNCE)) {
                String keyword = request.getParameter("keyword");
                List<HouseAnnouncement> houseAnnouncementList = houseAnnounceService.searchHouseAnnounce(keyword);
                request.setAttribute("houseAnnouncementList", houseAnnouncementList);
                address = "WEB-INF/pages/getHouseList.jsp";
            } else if(action.equalsIgnoreCase(MethodConstants.ADVANCED_SEARCH_HOUSE)) {
                int advCityCombo = Integer.parseInt(request.getParameter("advCityCombo"));
                int advDistrictCombo = Integer.parseInt(request.getParameter("advDistrictCombo"));
                int advAnnounceTypeCombo = Integer.parseInt(request.getParameter("advAnnounceTypeCombo"));
                int advStartRoom = Integer.parseInt(request.getParameter("advStartRoom"));
                int advEndRoom = Integer.parseInt(request.getParameter("advEndRoom"));
                int advStartArea = Integer.parseInt(request.getParameter("advStartArea"));
                int advEndArea = Integer.parseInt(request.getParameter("advEndArea"));
                int advStartPrice = Integer.parseInt(request.getParameter("advStartPrice"));
                int advEndPrice = Integer.parseInt(request.getParameter("advEndPrice"));
                AdvancedSearch advancedSearch = new AdvancedSearch();
                advancedSearch.setCityId(advCityCombo);
                advancedSearch.setDistrictId(advDistrictCombo);
                advancedSearch.setAnnounceTypeId(advAnnounceTypeCombo);
                advancedSearch.setStartRoom(advStartRoom);
                advancedSearch.setEndRoom(advEndRoom);
                advancedSearch.setStartArea(advStartArea);
                advancedSearch.setEndArea(advEndArea);
                advancedSearch.setStartPrice(advStartPrice);
                advancedSearch.setEndPrice(advEndPrice);
                List<HouseAnnouncement> houseAnnouncementList = houseAnnounceService.advancedSearchHouseList(advancedSearch);
                request.setAttribute("houseAnnouncementList", houseAnnouncementList);
                address = "WEB-INF/pages/getAdvSearchHouseList.jsp";
            } else if(action.equalsIgnoreCase("logout")) {
                address = "logout.jsp";
            } else if (action.equalsIgnoreCase("register")) {
                Users users = new Users();
                Genders genders = new Genders();
                Questions questions = new Questions();
                Roles roles = new Roles();

                String firstName = request.getParameter("firstName");
                String surname = request.getParameter("surname");
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String confirmPass = request.getParameter("confirmPass");
                int gender = Integer.parseInt(request.getParameter("gender"));
                genders.setId(gender);
                String datepicker = request.getParameter("datepicker");
                int secretQuestion = Integer.parseInt(request.getParameter("secretQuestion"));
                questions.setId(secretQuestion);
                String secretAnswer = request.getParameter("secretAnswer");
                int role = Integer.parseInt(request.getParameter("role"));
                roles.setId(role);
                int roleCode = Integer.parseInt(request.getParameter("roleCode"));
                Date dob = dateFormat.parse(datepicker);

                users.setName(firstName);
                users.setSurname(surname);
                users.setUsername(username);
                users.setEmail(email);
                users.setPassword(password);
                users.setConfirm_pass(confirmPass);
                users.setGenders(genders);
                users.setDob(dob);
                users.setQuestions(questions);
                users.setAnswer(secretAnswer);
                users.setRoles(roles);
                users.setAdmin_code(roleCode);

                boolean isAdded = generalService.registrationUsers(users);
                if(isAdded){
                    pw.println("You are registered successfully. Waiting for admin approve. Thanks");
                    response.setHeader("Refresh", "10; URL=http://localhost:8085/realestate/login.jsp");
                } else {
                    pw.println("Problem!!! You cannot registered successfully!");
                    response.setHeader("Refresh", "10; URL=http://localhost:8085/realestate/cs?action=registration");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(address != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
    }
}
