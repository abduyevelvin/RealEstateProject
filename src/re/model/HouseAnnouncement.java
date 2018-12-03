package re.model;

import java.sql.Blob;

public class HouseAnnouncement extends RealEstateModel {

    private City city;
    private District district;
    private int room_nr;
    private double area;
    private String address;
    private double price;
    private AnnouncementType announcementType;
    private ContactType contactType;
    private String contact;
    private Users users;
    private String action_type;
    private String approved;
    private Blob image;

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getRoom_nr() {
        return room_nr;
    }

    public void setRoom_nr(int room_nr) {
        this.room_nr = room_nr;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AnnouncementType getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(AnnouncementType announcementType) {
        this.announcementType = announcementType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "HouseAnnouncement{" +
                "city=" + city +
                ", district=" + district +
                ", room_nr=" + room_nr +
                ", area=" + area +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", announcementType=" + announcementType +
                ", contactType=" + contactType +
                ", contact='" + contact + '\'' +
                ", users=" + users +
                ", action_type='" + action_type + '\'' +
                ", approved='" + approved + '\'' +
                ", image=" + image +
                '}';
    }
}
