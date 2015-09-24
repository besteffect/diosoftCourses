/**
 * Created by vsv on 9/22/2015.
 * �������� POJO ����� DONE
* �������� POJO �����, ���� �������� �������� final (Person) DONE
* �������� Enum ������� ������������� �������� POJO ������ (���������:DIRECTOR, DEVELOPER, QA) DONE
* �������� Enum ��� ���� � POJO DONE
* C����������� equals/hashcode ������ DONE
* �������� Main �����, � main ������ �������� ��������� ��������� ����������� �� ������ � ����� ����� equals �  �� hashcode  DONE
 */
public class Person {

    private final String firstName;
    private final String secoundName;
    private final int age;
    private final JobTitle title; //enum

    public Person(String firstName, String secondName, int age, JobTitle title) { //automatically generated constructor
        this.firstName = firstName;
        this.secoundName = secondName;
        this.age = age;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secoundName;
    }

    public int getAge() {
        return age;
    }

    public JobTitle getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!secoundName.equals(person.secoundName)) return false;
        return title == person.title;

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + secoundName.hashCode();
        result = 31 * result + age;
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secoundName='" + secoundName + '\'' +
                ", age=" + age +
                ", title=" + title +
                '}';
    }
}
