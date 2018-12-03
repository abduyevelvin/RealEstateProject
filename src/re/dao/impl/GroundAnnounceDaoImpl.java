package re.dao.impl;

import re.dao.DBHelper;
import re.dao.GroundAnnounceDao;
import re.model.*;
import re.util.JdbcUtility;
import re.util.SQLMapping;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroundAnnounceDaoImpl implements GroundAnnounceDao {
    @Override
    public List<GroundAnnouncement> getGroundAnnouncementList() throws Exception {
        List<GroundAnnouncement> groundAnnouncementList = new ArrayList<GroundAnnouncement>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = SQLMapping.GET_GROUND_LIST;

        try {
            con = DBHelper.getConnection();
            if(con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    GroundAnnouncement ga = new GroundAnnouncement();
                    City c = new City();
                    District d = new District();
                    AnnouncementType a = new AnnouncementType();
                    ContactType ct = new ContactType();
                    Users u = new Users();
                    ga.setId(rs.getInt("pa.id"));
                    c.setId(rs.getInt("c.id"));
                    c.setName(rs.getString("c.name"));
                    ga.setCity(c);
                    d.setId(rs.getInt("d.id"));
                    d.setName(rs.getString("d.name"));
                    ga.setDistrict(d);
                    ga.setArea(rs.getDouble("area"));
                    ga.setAddress(rs.getString("address"));
                    ga.setPrice(rs.getDouble("price"));
                    ga.setContact(rs.getString("contact"));
                    a.setId(rs.getInt("a.id"));
                    a.setType(rs.getString("a.type"));
                    ga.setAnnouncementType(a);
                    ct.setId(rs.getInt("ct.id"));
                    ct.setType(rs.getString("ct.type"));
                    ga.setContactType(ct);
                    u.setId(rs.getInt("u.id"));
                    u.setName(rs.getString("u.name"));
                    u.setSurname(rs.getString("u.surname"));
                    ga.setUsers(u);
                    groundAnnouncementList.add(ga);
                }
            } else {
                System.out.println("Connection is failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return groundAnnouncementList;
    }
}
