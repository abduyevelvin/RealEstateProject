package re.dao;

import re.model.GroundAnnouncement;

import java.util.List;

public interface GroundAnnounceDao {

    List<GroundAnnouncement> getGroundAnnouncementList() throws Exception;
}
