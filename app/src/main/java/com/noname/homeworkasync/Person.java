package com.noname.homeworkasync;

public class Person {

    private String name, dob, imageUrl;
    private int age;

    public Person(String name, String dob, String imageUrl, int age) {
        this.name = name;
        this.dob = dob;
        this.imageUrl = imageUrl;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
