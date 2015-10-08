import org.com.diosoft.hw5.Person;

public class Main {
    public static void main(String[] args){

        Person person=new Person.Builder()
                .firstName("Victor")
                .secondName("Chernenkiy")
                .age(40)
                .id(1)
                .build();
        System.out.println(person);

        Person person1=new Person.Builder(person)
                .firstName("Vanya")
                .build();
        System.out.println(person1);
    }
}