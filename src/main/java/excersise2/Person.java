package excersise2;

public class Person {
    private String firstname;
    private String lastname;
    private String phone;
    private String address;

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Person of(String s) {
        String[] split = s.split(":");
        Person person = new Person();
        person.setFirstname(split[0]);
        person.setLastname(split[1]);
        person.setPhone(split[2]);
        person.setAddress(split[3]);
        return person;
    }
}
