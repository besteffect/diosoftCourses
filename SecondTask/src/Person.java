/**
 * Created by vsv on 9/22/2015.
 * �������� POJO �����
* �������� POJO �����, ���� �������� �������� final (Person)
* �������� Enum ������� ������������� �������� POJO ������ (���������:DIRECTOR, DEVELOPER, QA)
* �������� Enum ��� ���� � POJO
* C����������� equals/hashcode ������
* �������� Main �����, � main ������ �������� ��������� ��������� ����������� �� ������ � ����� ����� equals �  �� hashcode
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
