package sk.kosickaacademic.simon.students;

public class Contact {
    private String phone;
    private String email;
    private String skype;

    public String setPhone(String phone){
        this.phone=phone;
        return this.phone;
    }

    public String setEmail(String email){
        this.email=email;
        return this.email;
    }

    public String setSkype(String skype){
        this.skype=skype;
        return this.skype;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }
}
