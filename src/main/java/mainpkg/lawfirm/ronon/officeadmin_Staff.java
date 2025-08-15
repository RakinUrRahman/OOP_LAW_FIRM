package mainpkg.lawfirm.ronon;

public class officeadmin_Staff {
    private String name;
    private String role;
    private Integer contact;
    private String accessLevel;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public officeadmin_Staff(String name, String role, Integer contact, String accessLevel) {
        this.name = name;
        this.role = role;
        this.contact = contact;
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", contact=" + contact +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
};
