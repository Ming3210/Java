package homework.entity;

public class Person {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    public enum sex {
        MALE, FEMALE, OTHER
    }

    public Person(String address, int age, String email, String name, String phone) {
        this.address = address;
        this.age = age;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public Person() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
