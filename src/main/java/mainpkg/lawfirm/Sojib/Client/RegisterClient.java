package mainpkg.lawfirm.Sojib.Client;

import java.io.Serializable;
import java.time.LocalDate;

public class RegisterClient implements Serializable {
    private String clientname;
    private String email;
    private Integer phonenumber;
    private String occupation;
    private String address;
    private LocalDate dateofBirth;
    private String gender;

    public RegisterClient(String clientname, String email, Integer phonenumber, String occupation, String address, LocalDate dateofBirth, String gender) {
        this.clientname = clientname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.occupation = occupation;
        this.address = address;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "RegisterClient{" +
                "clientname='" + clientname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber=" + phonenumber +
                ", occupation='" + occupation + '\'' +
                ", address='" + address + '\'' +
                ", dateofBirth=" + dateofBirth +
                ", gender='" + gender + '\'' +
                '}';
    }
}