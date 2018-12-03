package re.dao.impl;

import re.dao.DBHelper;
import re.dao.GeneralDao;
import re.model.*;
import re.util.JdbcUtility;
import re.util.SQLMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeneralDaoImpl implements GeneralDao{
    @Override
    public List<City> getCityList() throws Exception {
        List<City> cityList = new ArrayList<City>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_CITY_LIST;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    City city = new City();
                    city.setId(rs.getInt("id"));
                    city.setName(rs.getString("name"));
                    cityList.add(city);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return cityList;
    }

    @Override
    public List<Genders> getGendersList() throws Exception {
        List<Genders> gendersList = new ArrayList<Genders>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_GENDERS_LIST;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    Genders genders = new Genders();
                    genders.setId(rs.getInt("id"));
                    genders.setGender(rs.getString("gender"));
                    gendersList.add(genders);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return gendersList;
    }

    @Override
    public List<Questions> getQuestionsList() throws Exception {
        List<Questions> questionsList = new ArrayList<Questions>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_QUESTIONS_LIST;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    Questions questions = new Questions();
                    questions.setId(rs.getInt("id"));
                    questions.setQuestion(rs.getString("question"));
                    questionsList.add(questions);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return questionsList;
    }

    @Override
    public List<Roles> getRolesList() throws Exception {
        List<Roles> rolesList = new ArrayList<Roles>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_ROLES_LIST;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    Roles roles = new Roles();
                    roles.setId(rs.getInt("id"));
                    roles.setRole(rs.getString("role"));
                    rolesList.add(roles);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return rolesList;
    }

    @Override
    public List<District> getDistrictList() throws Exception {
        List<District> districtList = new ArrayList<District>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_DISTRICT_LIST;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    District d = new District();
                    d.setId(rs.getInt("id"));
                    d.setName(rs.getString("name"));
                    districtList.add(d);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return districtList;
    }

    @Override
    public List<AnnouncementType> getAnnouncementTypeList() throws Exception {
        List<AnnouncementType> announcementTypeList = new ArrayList<AnnouncementType>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_ANNOUNCE_TYPE_LIST;
        try {
            con = DBHelper.getConnection();
            if(con!= null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    AnnouncementType at = new AnnouncementType();
                    at.setId(rs.getInt("id"));
                    at.setType(rs.getString("type"));
                    announcementTypeList.add(at);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return announcementTypeList;
    }

    @Override
    public List<ContactType> getContactTypeList() throws Exception {
        List<ContactType> contactTypeList = new ArrayList<ContactType>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_CONTACT_TYPE_LIST;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    ContactType ct = new ContactType();
                    ct.setId(rs.getInt("id"));
                    ct.setType(rs.getString("type"));
                    contactTypeList.add(ct);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return contactTypeList;
    }

    @Override
    public List<Users> getUsersList() throws Exception {
        List<Users> userList = new ArrayList<Users>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_USERS_LIST;
        try {
            c = DBHelper.getConnection();
            if(c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    Users user = new Users();
                    Genders gender = new Genders();
                    Questions question = new Questions();
                    Roles role = new Roles();
                    user.setId(rs.getInt("u.id"));
                    user.setName(rs.getString("u.name"));
                    user.setSurname(rs.getString("u.surname"));
                    user.setUsername(rs.getString("u.username"));
                    user.setEmail(rs.getString("u.email"));
                    user.setPassword(rs.getString("u.password"));
                    user.setDob(rs.getDate("u.dob"));
                    user.setAnswer(rs.getString("u.answer"));
                    gender.setId(rs.getInt("g.id"));
                    gender.setGender(rs.getString("g.gender"));
                    user.setGenders(gender);
                    question.setId(rs.getInt("q.id"));
                    question.setQuestion(rs.getString("q.question"));
                    user.setQuestions(question);
                    role.setId(rs.getInt("r.id"));
                    role.setRole(rs.getString("r.role"));
                    user.setRoles(role);
                    user.setActive(rs.getInt("u.active"));
                    userList.add(user);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return userList;
    }

    @Override
    public List<District> getDistrictListByCityId(int cityId) throws Exception {
        List<District> districtList = new ArrayList<District>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_DISTRICT_LIST_BY_CITY_ID;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1,cityId);
                rs = ps.executeQuery();
                while(rs.next()) {
                    District d = new District();
                    d.setId(rs.getInt("id"));
                    d.setName(rs.getString("name"));
                    districtList.add(d);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return districtList;
    }

    @Override
    public boolean registrationUsers(Users user) throws Exception {
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = SQLMapping.REGISTRATION_USERS;
        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, user.getName());
                ps.setString(2, user.getSurname());
                ps.setString(3, user.getUsername());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getConfirm_pass());
                ps.setInt(6, user.getGenders().getId());
                ps.setDate(7, new java.sql.Date(user.getDob().getTime()));
                ps.setString(8, user.getEmail());
                ps.setInt(9, user.getQuestions().getId());
                ps.setString(10, user.getAnswer());
                ps.setInt(11, user.getRoles().getId());
                ps.setInt(12, user.getAdmin_code());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            JdbcUtility.close(con, ps, null);
        }

        return result;
    }

    @Override
    public boolean checkUserName(String userName) throws Exception {
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.CHECK_USER_NAME;

        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, userName);
                rs = ps.executeQuery();
                if(rs.next()) {
                    result = true;
                } else {
                    result = false;
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return result;
    }

    @Override
    public boolean approveUser(int userId) throws Exception {
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = SQLMapping.APPROVE_USER;

        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e){
            e.printStackTrace();
            result = false;
        } finally {
            JdbcUtility.close(con, ps, null);
        }

        return result;
    }

    @Override
    public int countNewUsers() throws Exception {
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.COUNT_NEW_USERS;

        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    result = rs.getInt("NEW_USER");
                }
            } else {
                System.out.println("Connection is failed!");
                result = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return result;
    }

    @Override
    public Users login(String username, String password) throws Exception {
        Users users = new Users();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.LOGIN_USERS;

        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if(rs.next()) {
                    users.setId(rs.getInt("u.id"));
                    users.setUsername(rs.getString("u.username"));
                    users.setName(rs.getString("u.name"));
                    users.setSurname(rs.getString("u.surname"));
                    users.setEmail(rs.getString("u.email"));
                    Roles roles = new Roles();
                    roles.setId(rs.getInt("r.id"));
                    roles.setRole(rs.getString("r.role"));
                    users.setRoles(roles);
                } else {
                    users = null;
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return users;
    }
}
