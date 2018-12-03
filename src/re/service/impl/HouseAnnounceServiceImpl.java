package re.service.impl;

import re.dao.HouseAnnounceDao;
import re.model.AdvancedSearch;
import re.model.HouseAnnouncement;
import re.service.HouseAnnounceService;

import java.util.List;

public class HouseAnnounceServiceImpl implements HouseAnnounceService {

    private HouseAnnounceDao houseAnnounceDao;

    public HouseAnnounceServiceImpl(HouseAnnounceDao houseAnnounceDao) {
        this.houseAnnounceDao = houseAnnounceDao;
    }

    @Override
    public List<HouseAnnouncement> getHouseAnnouncementList() throws Exception {
        return  houseAnnounceDao.getHouseAnnouncementList();
    }

    @Override
    public boolean addHouseAnnounce(HouseAnnouncement houseAnnouncement) throws Exception {
        return houseAnnounceDao.addHouseAnnounce(houseAnnouncement);
    }

    @Override
    public boolean updateHouseAnnounce(HouseAnnouncement houseAnnouncement, int houseAnnounceId) throws Exception {
        return houseAnnounceDao.updateHouseAnnounce(houseAnnouncement, houseAnnounceId);
    }

    @Override
    public boolean deleteHouseAnnounce(int houseAnnounceId) throws Exception {
        return houseAnnounceDao.deleteHouseAnnounce(houseAnnounceId);
    }

    @Override
    public HouseAnnouncement getHouseAnnouncementById(int houseAnnounceId) throws Exception {
        return houseAnnounceDao.getHouseAnnouncementById(houseAnnounceId);
    }

    @Override
    public List<HouseAnnouncement> searchHouseAnnounce(String keyword) throws Exception {
        return houseAnnounceDao.searchHouseAnnounce(keyword);
    }

    @Override
    public List<HouseAnnouncement> advancedSearchHouseList(AdvancedSearch advancedSearch) throws Exception {
        return houseAnnounceDao.advancedSearchHouseList(advancedSearch);
    }
}
