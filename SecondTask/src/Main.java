/**
 * Created by vsv on 9/22/2015.
 */
public class Main {
    public static void main(String[] args){
        Person person1= new Person("Petro","Sodrugailo",40,JobTitle.DIRECTOR);
        Person person2=new Person("Pelageya","Chepurnenka",31,JobTitle.DEVELOPER);
        Person person3 =new Person("Antoniy","Cheburashka", 31,JobTitle.QA);
    isEqual(person1,person2);
    }

    private static void isEqual(Person person1,Person person2){
        System.out.println("Are objects equal? "+ person1.equals(person2));
        System.out.println(person1);
        System.out.println(person2);
    }
}
