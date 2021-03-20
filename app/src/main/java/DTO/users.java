package DTO;

public class users {
    private String email;
    private String pw;
    private String name;
    private String phone;
    private String key;
    private String age;

    public users(String email, String pw, String name, String phone, String key, String age) {
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.key = key;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
