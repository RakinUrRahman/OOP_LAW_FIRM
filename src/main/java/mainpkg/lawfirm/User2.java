package mainpkg.lawfirm;

import java.io.Serializable;

public class User2 implements Serializable {
    protected String email;

    public User2(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}
