package com.udb.dsm.apilabphp;

public class Person {
    private String uid;
    private String name;
    private String age;
    private String number;
    private String email;

    public Person() {
    }

    public String getUid() { return uid; }

    public void setUid(String uid) { this.uid = uid; }

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

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
