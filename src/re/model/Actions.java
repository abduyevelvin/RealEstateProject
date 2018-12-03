package re.model;

public class Actions extends RealEstateModel {

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Actions{" +
                "action='" + action + '\'' +
                '}';
    }
}
