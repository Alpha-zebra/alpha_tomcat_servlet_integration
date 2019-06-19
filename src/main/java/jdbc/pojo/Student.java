package jdbc.pojo;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String gender;
    private Date bornday;

    public Student() {
    }

    public Student(String name, String gender, Date bornday) {
        this.name = name;
        this.gender = gender;
        this.bornday = bornday;
    }

    public Student(int id, String name, String gender, Date bornday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bornday = bornday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBornday() {
        return bornday;
    }

    public void setBornday(Date bornday) {
        this.bornday = bornday;
    }
}
