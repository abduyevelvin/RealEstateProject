package re.service.impl;

import re.dao.GroundAnnounceDao;
import re.model.GroundAnnouncement;
import re.service.GroundAnnounceService;

import java.util.List;

public class GroundAnnounceServiceImpl implements GroundAnnounceService {

    private GroundAnnounceDao groundAnnounceDao;

    public GroundAnnounceServiceImpl(GroundAnnounceDao groundAnnounceDao) {
        this.groundAnnounceDao = groundAnnounceDao;
    }

    @Override
    public List<GroundAnnouncement> getGroundAnnouncementList() throws Exception {
        return groundAnnounceDao.getGroundAnnouncementList();
    }
}
