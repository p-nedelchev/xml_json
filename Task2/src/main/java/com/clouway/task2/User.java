package com.clouway.task2;

public class User {
    private String firstName, lasteName;
    private int age;

    public User(String firstName, String lasteName, int age) {
        this.firstName = firstName;
        this.lasteName = lasteName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasteName() {
        return lasteName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLasteName(String lasteName) {
        this.lasteName = lasteName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lasteName='" + lasteName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        return lasteName != null ? lasteName.equals(user.lasteName) : user.lasteName == null;
    }
}
