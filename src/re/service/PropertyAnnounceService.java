package re.service;

import re.model.PropertyAnnouncement;

import java.util.List;

public interface PropertyAnnounceService {

    List<PropertyAnnouncement> getPropertyAnnouncementList() throws Exception;
}
