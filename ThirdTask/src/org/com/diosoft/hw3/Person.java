package org.com.diosoft.hw3;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private int id;

    public Person(String firstName, String secondName, int age, int id,JobTitleEnum director) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person people = (Person) o;
        if (age != people.age) return false;
        if (id != people.id) return false;
        if (!firstName.equals(people.firstName)) return false;
        if (!secondName.equals(people.secondName)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + age;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
