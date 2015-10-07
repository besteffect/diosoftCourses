package org.com.diosoft.hw5;

/**
 * Created by user on 9/23/15.
 */
public class Person {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final int id;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.age = builder.age;
        this.id = builder.id;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (id != person.id) return false;
        if (!firstName.equals(person.firstName)) return false;
        return secondName.equals(person.secondName);

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
        return "org.com.diosoft.hw5.Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age='" + age + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String secondName;
        private int age;
        private int id;

        public Builder() {
        }

        public Builder(Person original) {
            this.firstName = original.firstName;
            this.secondName = original.secondName;
            this.age = original.age;
            this.id = original.id;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
