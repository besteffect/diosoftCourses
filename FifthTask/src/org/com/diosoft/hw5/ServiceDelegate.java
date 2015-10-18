package org.com.diosoft.hw5;

import java.util.Arrays;
// ВОПРОСЫ
// 1. Как можно в HW5 И HW6 сократить код?
//local code review (vtegza): use code duplicats in Idea, in general introduce separated methods with common logic @ 18.10.15
// 2. Мне не нравится что пришлось "throws MyException"  и try/catch дотянуть аж сюда. Как можно это обойти?
//local code review (vtegza): it is ok, noramaly you will want bring such exception handling in Service like this. @ 18.10.15
// 3. Как сделать логирование результатов в xml файл?
//local code review (vtegza): logging is better with Log4J framework - it has some kind of formatter that can write to xml file but normally only text file are used or logging into the db @ 18.10.15
// 4. ...

public class ServiceDelegate {
    private final PersonHelper resourceForDelegation;
    public ServiceDelegate(PersonHelper resourceForDelegation){
        this.resourceForDelegation=resourceForDelegation;
    }
    // Создаем делегат метод который добавляет вывод в консоль входных данных и результатов
    public Person[] mergeWithoutDuplicatesDelegated(Person[] group1, Person[] group2) throws MyException {
        System.out.println("MergeWithoutDuplicatesDelegated group1 " + Arrays.toString(group1));
        System.out.println("MergeWithoutDuplicatesDelegated group2 " + Arrays.toString(group2));
        Person[] result = resourceForDelegation.mergeWithoutDuplicates(group1,group2);
        System.out.println("mergeWithoutDuplicatesDelegated result" + Arrays.toString(result));
        return result;
    }
    public Person[] innerUnionDelegated (Person[] group1, Person[] group2) throws MyException {
        System.out.println("InnerUnionDelegated group1 " + Arrays.toString(group1));
        System.out.println("InnerUnionDelegated group2 " + Arrays.toString(group2));
        Person[] result = resourceForDelegation.innerUnion(group1,group2);
        System.out.println("InnerUnionDelegated result" + Arrays.toString(result));
        return result;
    }

    public Person[] outerUnionDelegated (Person[] group1, Person[] group2) throws MyException {
        System.out.println("OuterUnionDelegated group1 " + Arrays.toString(group1));
        System.out.println("OuterUnionDelegated group2 " + Arrays.toString(group2));
        Person[] result = resourceForDelegation.innerUnion(group1,group2);
        System.out.println("OuterUnionDelegated result" + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        Person person1 = new Person.Builder()
                .firstName("Petro")
                .secondName("Sodrugailo")
                .age(40)
                .id(1)
                .build();
        Person person2 = new Person.Builder()
                .firstName("Pelageya")
                .secondName("Chepurnenka")
                .age(31)
                .id(2)
                .build();
        Person person3 = new Person.Builder()
                .firstName("Antoniy")
                .secondName("Cheburashka")
                .age(31)
                .id(3)
                .build();
        Person person4 = new Person.Builder()
                .firstName("Petro")
                .secondName("Sodrugailo")
                .age(40)
                .id(1)
                .build();
        PersonHelper personHelper = new PersonHelper();
        ServiceDelegate serviceDelegate = new ServiceDelegate(personHelper);
        Person[] group1 = {person2, person1};
        Person[] group2 = {person2, person1, person4, person3};

        try {
            serviceDelegate.mergeWithoutDuplicatesDelegated(group1,group2);
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            serviceDelegate.innerUnionDelegated(group1,group2);
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            serviceDelegate.outerUnionDelegated(group1,group2);
        } catch (MyException e) {
            e.printStackTrace();
        }

    }
}
