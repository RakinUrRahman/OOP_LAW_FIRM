package mainpkg.lawfirm.rakin;
<<<<<<< Updated upstream
import mainpkg.lawfirm.user;
=======
import mainpkg.user;
>>>>>>> Stashed changes

import java.time.LocalDate;
import java.util.Random;

public class Lawyer extends user {

    private int status ; // status ==2  pending, 1==accept, 0==rejected
    private String emergencyContact;


    public Lawyer(String name, String phoneNo, String email, String address, String gender, String password, LocalDate dob, int status, String emergencyContact) {
        super(name, phoneNo, email, address, gender, password, dob);
        this.setId(this.generateID());
        this.status = 2;
        this.emergencyContact = emergencyContact;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @Override
    public String  toString() {
        return
                super.toString() + '\n' +
                "EmergencyContact='" + emergencyContact + '\'' +
                "Status=" + status
                ;
    }

    @Override
    public String generateID() {
        String id= " ";

        Random random = new Random();
        id = Integer.toString(random.nextInt(1000000, 9999999));

        return id;
    }

    @Override
    public boolean login(String id, String password) {
        return false;
    }


}
