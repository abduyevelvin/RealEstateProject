package re.model;

public class AdvancedSearch {

    private int cityId;
    private int districtId;
    private int announceTypeId;
    private int startRoom;
    private int endRoom;
    private int startArea;
    private int endArea;
    private int startPrice;
    private int endPrice;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getAnnounceTypeId() {
        return announceTypeId;
    }

    public void setAnnounceTypeId(int announceTypeId) {
        this.announceTypeId = announceTypeId;
    }

    public int getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(int startRoom) {
        this.startRoom = startRoom;
    }

    public int getEndRoom() {
        return endRoom;
    }

    public void setEndRoom(int endRoom) {
        this.endRoom = endRoom;
    }

    public int getStartArea() {
        return startArea;
    }

    public void setStartArea(int startArea) {
        this.startArea = startArea;
    }

    public int getEndArea() {
        return endArea;
    }

    public void setEndArea(int endArea) {
        this.endArea = endArea;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(int endPrice) {
        this.endPrice = endPrice;
    }

    @Override
    public String toString() {
        return "AdvancedSearch{" +
                "cityId=" + cityId +
                ", districtId=" + districtId +
                ", announceTypeId=" + announceTypeId +
                ", startRoom=" + startRoom +
                ", endRoom=" + endRoom +
                ", startArea=" + startArea +
                ", endArea=" + endArea +
                ", startPrice=" + startPrice +
                ", endPrice=" + endPrice +
                '}';
    }
}
