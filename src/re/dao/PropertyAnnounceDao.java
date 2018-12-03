package re.dao;

import re.model.PropertyAnnouncement;

import java.util.List;

public interface PropertyAnnounceDao {

    List<PropertyAnnouncement> getPropertyAnnouncementList() throws Exception;
}
