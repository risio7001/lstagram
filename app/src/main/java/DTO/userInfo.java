package DTO;

public class userInfo {
    private String email;
    private String name;
    private String age;
    private String phone;

    public userInfo(String email, String name, String age, String phone) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
