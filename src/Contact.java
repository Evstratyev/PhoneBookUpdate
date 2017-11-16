/**
 * Created by Евген on 08.11.2017.
 */
public class Contact {
    private String name;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Name: " + this.name + " Phone: " + this.phone + " E-mail: " + this.email;
    }
}
