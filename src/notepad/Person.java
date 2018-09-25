package notepad;

public class Person {

    private static int count = 0;
    // for all persons count = 0 as it si private
    private int id;

    private String name;
    private String surname;
    private String phone;

    public Person() {
        // id = 10;
        count++;
        // increases with avery new peron
        id= count;

    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}' + count;
    }
}