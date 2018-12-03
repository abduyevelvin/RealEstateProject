package re.service.impl;

import re.dao.GeneralDao;
import re.model.*;
import re.service.GeneralService;

import java.util.List;

public class GeneralServiceImpl implements GeneralService {

    private GeneralDao generalDao;

    public GeneralServiceImpl(GeneralDao generalDao) {
        this.generalDao = generalDao;
    }

    @Override
    public List<City> getCityList() throws Exception {
        return generalDao.getCityList();
    }

    @Override
    public List<Genders> getGendersList() throws Exception {
        return generalDao.getGendersList();
    }

    @Override
    public List<Questions> getQuestionsList() throws Exception {
        return generalDao.getQuestionsList();
    }

    @Override
    public List<Roles> getRolesList() throws Exception {
        return generalDao.getRolesList();
    }

    @Override
    public List<District> getDistrictList() throws Exception {
        return generalDao.getDistrictList();
    }

    @Override
    public List<AnnouncementType> getAnnouncementTypeList() throws Exception {
        return generalDao.getAnnouncementTypeList();
    }

    @Override
    public List<ContactType> getContactTypeList() throws Exception {
        return generalDao.getContactTypeList();
    }

    @Override
    public List<Users> getUsersList() throws Exception {
        return generalDao.getUsersList();
    }

    @Override
    public List<District> getDistrictListByCityId(int cityId) throws Exception {
        return generalDao.getDistrictListByCityId(cityId);
    }

    @Override
    public boolean registrationUsers(Users user) throws Exception {
        return generalDao.registrationUsers(user);
    }

    @Override
    public boolean checkUserName(String userName) throws Exception {
        return generalDao.checkUserName(userName);
    }

    @Override
    public boolean approveUser(int userId) throws Exception {
        return generalDao.approveUser(userId);
    }

    @Override
    public int countNewUsers() throws Exception {
        return generalDao.countNewUsers();
    }

    @Override
    public Users login(String username, String password) throws Exception {
        return generalDao.login(username, password);
    }
}
