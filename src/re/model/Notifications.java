package re.model;

public class Notifications extends RealEstateModel {

    private HouseAnnouncement hAnounce;
    private String seen;

    public HouseAnnouncement gethAnounce() {
        return hAnounce;
    }

    public void sethAnounce(HouseAnnouncement hAnounce) {
        this.hAnounce = hAnounce;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }

}
