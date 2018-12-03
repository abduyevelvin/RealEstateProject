package re.dao.impl;

import re.dao.DBHelper;
import re.dao.PropertyAnnounceDao;
import re.model.*;
import re.util.JdbcUtility;
import re.util.SQLMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PropertyAnnounceDaoImpl implements PropertyAnnounceDao {
    @Override
    public List<PropertyAnnouncement> getPropertyAnnouncementList() throws Exception {
        List<PropertyAnnouncement> propertyAnnouncementList = new ArrayList<PropertyAnnouncement>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_PROPERTY_LIST;

        try{
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    PropertyAnnouncement pa = new PropertyAnnouncement();
                    City c = new City();
                    District d = new District();
                    AnnouncementType a = new AnnouncementType();
                    ContactType ct = new ContactType();
                    Users u = new Users();
                    pa.setId(rs.getInt("pa.id"));
                    c.setId(rs.getInt("c.id"));
                    c.setName(rs.getString("c.name"));
                    pa.setCity(c);
                    d.setId(rs.getInt("d.id"));
                    d.setName(rs.getString("d.name"));
                    pa.setDistrict(d);
                    pa.setRoom_nr(rs.getInt("room_nr"));
                    pa.setArea(rs.getDouble("area"));
                    pa.setAddress(rs.getString("address"));
                    pa.setPrice(rs.getDouble("price"));
                    a.setId(rs.getInt("a.id"));
                    a.setType(rs.getString("a.type"));
                    pa.setAnnouncementType(a);
                    pa.setContacts(rs.getString("contact"));
                    ct.setId(rs.getInt("ct.id"));
                    ct.setType(rs.getString("ct.type"));
                    pa.setContactType(ct);
                    u.setId(rs.getInt("u.id"));
                    u.setName(rs.getString("u.name"));
                    u.setSurname(rs.getString("u.surname"));
                    pa.setUsers(u);
                    propertyAnnouncementList.add(pa);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return propertyAnnouncementList;
    }
}
