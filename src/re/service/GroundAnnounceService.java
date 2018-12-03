package re.service;

import re.model.GroundAnnouncement;

import java.util.List;

public interface GroundAnnounceService {

    List<GroundAnnouncement> getGroundAnnouncementList() throws Exception;
}
