package re.dao;

import re.model.*;

import java.util.List;

public interface GeneralDao {

    List<City> getCityList() throws Exception;
    List<Genders> getGendersList() throws Exception;
    List<Questions> getQuestionsList() throws Exception;
    List<Roles> getRolesList() throws Exception;
    List<District> getDistrictList() throws Exception;
    List<AnnouncementType> getAnnouncementTypeList() throws Exception;
    List<ContactType> getContactTypeList() throws Exception;
    List<Users> getUsersList() throws Exception;
    List<District> getDistrictListByCityId(int cityId) throws Exception;

    boolean registrationUsers(Users user) throws Exception;
    boolean checkUserName(String userName) throws Exception;
    boolean approveUser(int userId) throws Exception;
    int countNewUsers() throws Exception;

    Users login(String username, String password) throws Exception;
}
