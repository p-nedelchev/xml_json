package com.clouway.taskone;

import com.google.common.base.Function;
import com.google.common.base.Objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */

@XStreamAlias("person")
public class Person {
    public final String firstName;
    public final String lastName;
    public final Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equal(firstName, person.firstName) &&
                Objects.equal(lastName, person.lastName) &&
                Objects.equal(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, age);
    }

}
