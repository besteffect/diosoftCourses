// Homework
// Merge для нашей домашней работы
// Переписываем POJO в соответствии с Builder паттерном
// Переписываем статические методы на инстанс методы
// Создаем делегат метод который добавляет вывод в консоль входных данных и результатов
// - Переписать свой Pojo в соответствии Builder паттерну
// - Написать метод  Type[] merge(Type[] leftArray, Type[] rightArray) в отдельном классе (ArrayHelper)
// - Создать ServiceDelegate для ArrayHelper
// - написать позитивные тесты
// - добавить проверку для каждого Person на не пустой и не null name

package org.com.diosoft.hw5;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PersonTests {

    public void verifyIsPersonEqual(Person a, Person b, boolean equalPerson) {
        boolean actualResult = PersonHelper.isEqual(a, b);
        boolean expectedResult = equalPerson;
        if (actualResult == expectedResult) {
            System.out.println("Positive person test passed");
        } else {
            System.out.println("Positive person test failed");
        }
    }

    public void verifyIsPersonNotEqual(Person person1, Person person2, boolean notEqualPerson) {
        boolean actualResult = PersonHelper.isEqual(person1, person2);
        boolean expectedResult = notEqualPerson;
        if (actualResult == expectedResult) {
            System.out.println("Negative person test passed");
        } else {
            System.out.println("Negative person test failed");
        }
    }

    public void verifyGroupsAreEqual() { //comparing not sorted groups using Comparator
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
        Person[] group1 = {person1, person2, person3};
        Person[] group2 = {person3, person1, person2};
        Arrays.sort(group2, new PersonComparator()); // previously group sorting is required here for method isEqual to work properly
        Arrays.sort(group1, new PersonComparator());
        boolean actualResult = PersonHelper.isEqual(group1, group2);
        if (actualResult == true) {
            System.out.println("Group compare test passed");
        } else {
            System.out.println("Group compare test failed");
        }
    }
    @Test
    public void mergeUnionTestPositive() throws Exception {
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
        Person[] group1 = {person1, person2, person3};
        Person[] group2 = {person2, person1, person4};
        Person[] expectedGroup = {person1, person2, person3}; // expected result is here
        PersonHelper main = new PersonHelper();
        Person[] returnGroup = main.mergeWithoutDuplicates(group1, group2);
        assertArrayEquals(expectedGroup, returnGroup);
    }
    @Test
    public void mergeUnionTestleftArrayIsEmpty() throws Exception {
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
        Person[] group1 = {};
        Person[] group2 = {person2, person1, person4, person3};
        Person[] expectedGroup = {person2, person1, person4, person3};
        PersonHelper main = new PersonHelper();
        Person[] returnGroup = main.mergeWithoutDuplicates(group1, group2);
        assertArrayEquals(expectedGroup, returnGroup);
    }
    @Test
    public void mergeUnionTestLeftArrayIsNull() throws Exception {
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
        String expectedValue = "Wrong values";
        Person[] group1 = null;
        Person[] group2 = {person2, person1, person4, person3};
        Person[] expectedGroup = null;
        PersonHelper main = new PersonHelper();
        try {
            main.mergeWithoutDuplicates(group1, group2);
            fail("Exception Should be thrown");
        } catch (MyException exception) {
            assertEquals(expectedValue, exception.getErrorCode());
        }
        // assert return value
    }
    @Test
    public void innerUnionTestPositive() throws Exception {
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
        Person[] group1 = {person1, person2};
        Person[] group2 = {person3, person1, person4};
        Person[] expectedGroup = {person1};
        PersonHelper main = new PersonHelper();
        Person[] returnGroup = main.innerUnion(group1, group2);
        assertArrayEquals(expectedGroup, returnGroup);
    }
    @Test
    public void innerUnionTestLeftArrayIsEmpty() throws Exception {
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
        Person[] group1 = {};
        Person[] group2 = {person3, person1, person4};
        Person[] expectedGroup = {};
        PersonHelper main = new PersonHelper();
        Person[] returnGroup = main.innerUnion(group1, group2);
        assertArrayEquals(expectedGroup, returnGroup);
    }
    @Test
    public void innerUnionTestLeftArrayIsNull() throws Exception {
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

        String expectedValue = "Wrong values";
        Person[] group1 = null;
        Person[] group2 = {person3, person1, person4, person2};
        Person[] expectedGroup = null;
        System.out.println("Inner union left array is null person test expected group is " + Arrays.toString(expectedGroup));
        // initialize class to test
        PersonHelper main = new PersonHelper();
        // invoke method on class to test
        try {
            main.innerUnion(group1, group2);
            fail("Exception Should be thrown");
        } catch (MyException exception) {
            assertEquals(expectedValue, exception.getErrorCode());
        }
        // assert return value
    }
    @Test
    public void outerUnionTestPositive() throws Exception {
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
        Person[] group1 = {person1, person2};
        Person[] group2 = {person3, person1};
        Person[] expectedGroup = {person2, person3};
        PersonHelper main = new PersonHelper();
        Person[] returnGroup = main.outerUnion(group1, group2);
        assertArrayEquals(expectedGroup, returnGroup);
    }
    @Test
    public void outerUnionTestLeftArrayIsEmpty() throws Exception {
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
        Person[] group1 = {};
        Person[] group2 = {person3, person1, person4};
        Person[] expectedGroup = {person3, person1, person4};
        PersonHelper main = new PersonHelper();
        Person[] returnGroup = main.outerUnion(group1, group2);
        assertArrayEquals(expectedGroup, returnGroup);
    }
    @Test
    public void outerUnionTestLeftArrayIsNull() throws Exception {
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
        String expectedValue = "Wrong values";
        Person[] group1 = null;
        Person[] group2 = {person3, person1, person4, person2};
        Person[] expectedGroup = null;
        System.out.println("Outer union left array is null person test expected group is " + Arrays.toString(expectedGroup));
        PersonHelper main = new PersonHelper();
        try {
            main.innerUnion(group1, group2);
            fail("Exception Should be thrown");
        } catch (MyException exception) {
            assertEquals(expectedValue, exception.getErrorCode());
        }
        // assert return value
    }
}
