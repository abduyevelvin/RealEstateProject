package re.service.impl;

import re.dao.PropertyAnnounceDao;
import re.model.PropertyAnnouncement;
import re.service.PropertyAnnounceService;

import java.util.List;

public class PropertyAnnounceServiceImpl implements PropertyAnnounceService {

    private PropertyAnnounceDao propertyAnnounceDao;

    public PropertyAnnounceServiceImpl(PropertyAnnounceDao propertyAnnounceDao) {
        this.propertyAnnounceDao = propertyAnnounceDao;
    }

    @Override
    public List<PropertyAnnouncement> getPropertyAnnouncementList() throws Exception {
        return propertyAnnounceDao.getPropertyAnnouncementList();
    }
}
