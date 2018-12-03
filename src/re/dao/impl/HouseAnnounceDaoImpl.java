package re.dao.impl;

import re.dao.DBHelper;
import re.dao.HouseAnnounceDao;
import re.model.*;
import re.util.JdbcUtility;
import re.util.SQLMapping;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HouseAnnounceDaoImpl implements HouseAnnounceDao {
    @Override
    public List<HouseAnnouncement> getHouseAnnouncementList() throws Exception {
        List<HouseAnnouncement> houseAnnouncementList = new ArrayList<HouseAnnouncement>();
        Connection con = null;
        //PreparedStatement ps = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_HOUSE_LIST_PROC;

        try {
            con = DBHelper.getConnection();
            if(con != null) {
                cs = con.prepareCall(sql);
                //ps = con.prepareStatement(sql);
                cs.execute();
                rs = cs.getResultSet();
                //rs = ps.executeQuery();
                while(rs.next()) {
                    HouseAnnouncement ha = new HouseAnnouncement();
                    City c = new City();
                    District d = new District();
                    AnnouncementType a = new AnnouncementType();
                    ContactType ct = new ContactType();
                    Users u = new Users();
                    ha.setId(rs.getInt("ha.id"));
                    c.setId(rs.getInt("c.id"));
                    c.setName(rs.getString("c.name"));
                    ha.setCity(c);
                    d.setId(rs.getInt("d.id"));
                    d.setName(rs.getString("d.name"));
                    ha.setDistrict(d);
                    ha.setRoom_nr(rs.getInt("room_nr"));
                    ha.setArea(rs.getDouble("area"));
                    ha.setAddress(rs.getString("address"));
                    ha.setContact(rs.getString("contact"));
                    ha.setPrice(rs.getDouble("price"));
                    a.setId(rs.getInt("a.id"));
                    a.setType(rs.getString("a.type"));
                    ha.setAnnouncementType(a);
                    ct.setId(rs.getInt("ct.id"));
                    ct.setType(rs.getString("ct.type"));
                    ha.setContactType(ct);
                    u.setId(rs.getInt("u.id"));
                    u.setName(rs.getString("u.name"));
                    u.setSurname(rs.getString("u.surname"));
                    ha.setUsers(u);
                    houseAnnouncementList.add(ha);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, cs, rs);
        }

        return houseAnnouncementList;
    }

    @Override
    public boolean addHouseAnnounce(HouseAnnouncement houseAnnouncement) throws Exception {
        boolean res = false;
        Connection con = null;
        //PreparedStatement ps = null;
        CallableStatement cs = null;
        //String sql = SQLMapping.ADD_HOUSE_ANNOUNCE;
        String sql = SQLMapping.ADD_HOUSE_ANNOUNCE_PROC;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                //ps = con.prepareStatement(sql);
                cs = con.prepareCall(sql);
                /*ps.setInt(1, houseAnnouncement.getCity().getId());
                ps.setInt(2, houseAnnouncement.getDistrict().getId());
                ps.setInt(3, houseAnnouncement.getRoom_nr());
                ps.setDouble(4, houseAnnouncement.getArea());
                ps.setString(5, houseAnnouncement.getAddress());
                ps.setString(6, houseAnnouncement.getContact());
                ps.setDouble(7, houseAnnouncement.getPrice());
                ps.setInt(8, houseAnnouncement.getAnnouncementType().getId());
                ps.setInt(9, houseAnnouncement.getContactType().getId());
                ps.setInt(10, houseAnnouncement.getUsers().getId());
                ps.execute();
                res = true;*/
                cs.setInt(1, houseAnnouncement.getCity().getId());
                cs.setInt(2, houseAnnouncement.getDistrict().getId());
                cs.setInt(3, houseAnnouncement.getRoom_nr());
                cs.setDouble(4, houseAnnouncement.getArea());
                cs.setString(5, houseAnnouncement.getAddress());
                cs.setString(6, houseAnnouncement.getContact());
                cs.setDouble(7, houseAnnouncement.getPrice());
                cs.setInt(8, houseAnnouncement.getAnnouncementType().getId());
                cs.setInt(9, houseAnnouncement.getContactType().getId());
                cs.setInt(10, houseAnnouncement.getUsers().getId());
                cs.execute();
                res = true;
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JdbcUtility.close(con, cs, null);
        }

        return res;
    }

    @Override
    public boolean updateHouseAnnounce(HouseAnnouncement houseAnnouncement, int houseAnnounceId) throws Exception {
        boolean res = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = SQLMapping.UPDATE_HOUSE_ANNOUNCE;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, houseAnnouncement.getCity().getId());
                ps.setInt(2, houseAnnouncement.getDistrict().getId());
                ps.setInt(3, houseAnnouncement.getRoom_nr());
                ps.setDouble(4, houseAnnouncement.getArea());
                ps.setString(5, houseAnnouncement.getAddress());
                ps.setString(6, houseAnnouncement.getContact());
                ps.setDouble(7, houseAnnouncement.getPrice());
                ps.setInt(8, houseAnnouncement.getAnnouncementType().getId());
                ps.setInt(9, houseAnnouncement.getContactType().getId());
                ps.setInt(10, houseAnnouncement.getUsers().getId());
                ps.setInt(11, houseAnnounceId);
                ps.execute();
                res = true;
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JdbcUtility.close(con, ps, null);
        }

        return res;
    }

    @Override
    public boolean deleteHouseAnnounce(int houseAnnounceId) throws Exception {
        boolean res = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = SQLMapping.DELETE_HOUSE_ANNOUNCE;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, houseAnnounceId);
                ps.execute();
                res = true;
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JdbcUtility.close(con, ps, null);
        }

        return res;
    }

    @Override
    public HouseAnnouncement getHouseAnnouncementById(int houseAnnounceId) throws Exception {
        HouseAnnouncement ha = new HouseAnnouncement();
        Connection con = null;
        //PreparedStatement ps = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        //String sql = SQLMapping.GET_HOUSE_LIST_BY_ID;
        String sql = SQLMapping.GET_HOUSE_LIST_BY_ID_PROC;

        try {
            con = DBHelper.getConnection();
            if(con != null) {
                //ps = con.prepareStatement(sql);
                cs = con.prepareCall(sql);
                //ps.setInt(1,houseAnnounceId);
                cs.setInt(1, houseAnnounceId);
                //rs = ps.executeQuery();
                cs.execute();
                rs = cs.getResultSet();
                if(rs.next()) {
                    City c = new City();
                    District d = new District();
                    AnnouncementType a = new AnnouncementType();
                    ContactType ct = new ContactType();
                    Users u = new Users();
                    ha.setId(rs.getInt("ha.id"));
                    c.setId(rs.getInt("c.id"));
                    c.setName(rs.getString("c.name"));
                    ha.setCity(c);
                    d.setId(rs.getInt("d.id"));
                    d.setName(rs.getString("d.name"));
                    ha.setDistrict(d);
                    ha.setRoom_nr(rs.getInt("room_nr"));
                    ha.setArea(rs.getDouble("area"));
                    ha.setAddress(rs.getString("address"));
                    ha.setContact(rs.getString("contact"));
                    ha.setPrice(rs.getDouble("price"));
                    a.setId(rs.getInt("a.id"));
                    a.setType(rs.getString("a.type"));
                    ha.setAnnouncementType(a);
                    ct.setId(rs.getInt("ct.id"));
                    ct.setType(rs.getString("ct.type"));
                    ha.setContactType(ct);
                    u.setId(rs.getInt("u.id"));
                    u.setName(rs.getString("u.name"));
                    u.setSurname(rs.getString("u.surname"));
                    ha.setUsers(u);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, cs, rs);
        }

        return ha;
    }

    @Override
    public List<HouseAnnouncement> searchHouseAnnounce(String keyword) throws Exception {
        List<HouseAnnouncement> houseAnnouncementList = new ArrayList<HouseAnnouncement>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.SEARCH_HOUSE_ANNOUNCE;

        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
                ps.setString(2, "%"+keyword+"%");
                ps.setString(3, "%"+keyword+"%");
                ps.setString(4, "%"+keyword+"%");
                ps.setString(5, "%"+keyword+"%");
                ps.setString(6, "%"+keyword+"%");
                ps.setString(7, "%"+keyword+"%");
                rs = ps.executeQuery();
                while(rs.next()) {
                    HouseAnnouncement ha = new HouseAnnouncement();
                    City c = new City();
                    District d = new District();
                    AnnouncementType a = new AnnouncementType();
                    ContactType ct = new ContactType();
                    Users u = new Users();
                    ha.setId(rs.getInt("ha.id"));
                    c.setId(rs.getInt("c.id"));
                    c.setName(rs.getString("c.name"));
                    ha.setCity(c);
                    d.setId(rs.getInt("d.id"));
                    d.setName(rs.getString("d.name"));
                    ha.setDistrict(d);
                    ha.setRoom_nr(rs.getInt("room_nr"));
                    ha.setArea(rs.getDouble("area"));
                    ha.setAddress(rs.getString("address"));
                    ha.setContact(rs.getString("contact"));
                    ha.setPrice(rs.getDouble("price"));
                    a.setId(rs.getInt("a.id"));
                    a.setType(rs.getString("a.type"));
                    ha.setAnnouncementType(a);
                    ct.setId(rs.getInt("ct.id"));
                    ct.setType(rs.getString("ct.type"));
                    ha.setContactType(ct);
                    u.setId(rs.getInt("u.id"));
                    u.setName(rs.getString("u.name"));
                    u.setSurname(rs.getString("u.surname"));
                    ha.setUsers(u);
                    houseAnnouncementList.add(ha);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return houseAnnouncementList;
    }

    @Override
    public List<HouseAnnouncement> advancedSearchHouseList(AdvancedSearch advancedSearch) throws Exception {
        List<HouseAnnouncement> houseAnnouncementList = new ArrayList<HouseAnnouncement>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_HOUSE_LIST;

        try {
            con = DBHelper.getConnection();
            if(con != null) {

                if(advancedSearch.getCityId() != 0) {
                    sql += " AND c.id = " + advancedSearch.getCityId();
                }
                if(advancedSearch.getDistrictId() != 0) {
                    sql += " AND d.id = " + advancedSearch.getDistrictId();
                }
                if(advancedSearch.getAnnounceTypeId() != 0) {
                    sql += " AND a.id = " + advancedSearch.getAnnounceTypeId();
                }
                if(advancedSearch.getStartRoom() != 0) {
                    sql += " AND room_nr >= " + advancedSearch.getStartRoom();
                }
                if(advancedSearch.getEndRoom() != 0) {
                    sql += " AND room_nr < " + advancedSearch.getEndRoom();
                }
                if(advancedSearch.getStartArea() != 0.0) {
                    sql += " AND area >= " + advancedSearch.getStartArea();
                }
                if(advancedSearch.getEndArea() != 0.0) {
                    sql += " AND area < " + advancedSearch.getEndArea();
                }
                if(advancedSearch.getStartPrice() != 0.0) {
                    sql += " AND price >= " + advancedSearch.getStartPrice();
                }
                if(advancedSearch.getEndPrice() != 0.0) {
                    sql += " AND price < " + advancedSearch.getEndPrice();
                }

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    HouseAnnouncement ha = new HouseAnnouncement();
                    City c = new City();
                    District d = new District();
                    AnnouncementType a = new AnnouncementType();
                    ContactType ct = new ContactType();
                    Users u = new Users();
                    ha.setId(rs.getInt("ha.id"));
                    c.setId(rs.getInt("c.id"));
                    c.setName(rs.getString("c.name"));
                    ha.setCity(c);
                    d.setId(rs.getInt("d.id"));
                    d.setName(rs.getString("d.name"));
                    ha.setDistrict(d);
                    ha.setRoom_nr(rs.getInt("room_nr"));
                    ha.setArea(rs.getDouble("area"));
                    ha.setAddress(rs.getString("address"));
                    ha.setContact(rs.getString("contact"));
                    ha.setPrice(rs.getDouble("price"));
                    a.setId(rs.getInt("a.id"));
                    a.setType(rs.getString("a.type"));
                    ha.setAnnouncementType(a);
                    ct.setId(rs.getInt("ct.id"));
                    ct.setType(rs.getString("ct.type"));
                    ha.setContactType(ct);
                    u.setId(rs.getInt("u.id"));
                    u.setName(rs.getString("u.name"));
                    u.setSurname(rs.getString("u.surname"));
                    ha.setUsers(u);
                    houseAnnouncementList.add(ha);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return houseAnnouncementList;
    }
}
