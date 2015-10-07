package org.com.diosoft.hw4;
//Создать Pojo объект
//Для определения дубликата: pojo1.equals(pojo2) = true
//Используйте автоматическую генерацию equals метода
//Вы можете использовать экземпляры этого класса как элементы массива или же используйте int значения как упрощенный вариант.
//Для каждого из методов необходимо написать хотя бы один тест
//В тестах должно быть учтено что ожидаемые значения могут быть предоставлены в не определенном порядке.
//Как показало предыдущее занятые предпочтительным вариантом являться предварительная сортировка.
//Как один из вариантов - можно использовать Arrays.sort(arr, Comparator)
//Comparator это интерфейс который содержит  метод
//int compare(T o1, T o2);
//его вам будет необходимо реализовать.
public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private int id;
    private JobTitleEnum jobTitle;

    public Person(String firstName, String secondName, int age, int id, JobTitleEnum jobTitle) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.id=id;
        this.jobTitle=jobTitle;
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
