package re.model;

public class RoleAction extends RealEstateModel {

    private Roles roles;
    private Actions actions;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "RoleAction{" +
                "roles=" + roles +
                ", actions=" + actions +
                '}';
    }
}
