package org.com.diosoft.hw5;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PersonTests {

    public void verifyIsPersonEqual(Person a, Person b, boolean equalPerson) {
        boolean actualResult = PersonUtils.isEqual(a, b);
        boolean expectedResult = equalPerson;
        if (actualResult == expectedResult) {
            System.out.println("Positive person test passed");
        } else {
            System.out.println("Positive person test failed");
        }
    }

    public void verifyIsPersonNotEqual(Person person1, Person person2, boolean notEqualPerson) {
        boolean actualResult = PersonUtils.isEqual(person1, person2);
        boolean expectedResult = notEqualPerson;
        if (actualResult == expectedResult) {
            System.out.println("Negative person test passed");
        } else {
            System.out.println("Negative person test failed");
        }
    }

    public void verifyGroupsAreEquals() { //comparing not sorted groups using Comparator
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
        boolean actualResult = PersonUtils.isEqual(group1, group2);
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
        PersonUtils main = new PersonUtils();
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
        PersonUtils main = new PersonUtils();
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
        PersonUtils main = new PersonUtils();
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
        PersonUtils main = new PersonUtils();
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
        PersonUtils main = new PersonUtils();
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
        PersonUtils main = new PersonUtils();
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
        PersonUtils main = new PersonUtils();
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
        PersonUtils main = new PersonUtils();
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
        PersonUtils main = new PersonUtils();
        try {
            main.innerUnion(group1, group2);
            fail("Exception Should be thrown");
        } catch (MyException exception) {
            assertEquals(expectedValue, exception.getErrorCode());
        }
        // assert return value
    }
}
