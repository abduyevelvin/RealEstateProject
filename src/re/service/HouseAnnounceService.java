package re.service;

import re.model.AdvancedSearch;
import re.model.HouseAnnouncement;

import java.util.List;

public interface HouseAnnounceService {

    List<HouseAnnouncement> getHouseAnnouncementList() throws Exception;
    HouseAnnouncement getHouseAnnouncementById(int houseAnnounceId) throws Exception;
    List<HouseAnnouncement> searchHouseAnnounce(String keyword) throws Exception;
    List<HouseAnnouncement> advancedSearchHouseList(AdvancedSearch advancedSearch) throws Exception;

    boolean addHouseAnnounce(HouseAnnouncement houseAnnouncement) throws Exception;
    boolean updateHouseAnnounce(HouseAnnouncement houseAnnouncement, int houseAnnounceId) throws Exception;
    boolean deleteHouseAnnounce(int houseAnnounceId) throws Exception;

}
