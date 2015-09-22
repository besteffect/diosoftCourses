/**
 * Created by vsv on 9/22/2015.
 * Создайте POJO класс
* Создайте POJO класс, поля которого являются final (Person)
* Создайте Enum который характеризует экзмпляр POJO класса (Должность:DIRECTOR, DEVELOPER, QA)
* Добавьте Enum как поле в POJO
* Cгенерируйте equals/hashcode методы
* Создайте Main класс, в main методе которого проведите сравнение экземпляров по ссылке и через метод equals и  по hashcode
 */
public class Person {

    private String firstName;
    public String getFirstName(){
       return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    private String secoundName;
    public String getSecoundName(){
        return  secoundName;
    }
    public void setSecoundName(String secoundName){
        this.secoundName=secoundName;
    }

    private int age;
    private int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    private JobTitle title; //enum
}
