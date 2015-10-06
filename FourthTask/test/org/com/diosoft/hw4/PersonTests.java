package org.com.diosoft.hw4;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

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
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);

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
    public void mergeUnionTestPositive() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = {person1, person2, person3};
        Person[] group2 = {person2, person1, person4};

        Person[] expectedGroup = {person1, person2, person3}; // expected result is here
        PersonUtils main = new PersonUtils();
        Person[] returnGroup = main.mergeWithoutDuplicates(group1, group2);
        assertArrayEquals(expectedGroup,returnGroup);
    }

    @Test
    public void mergeUnionTestleftArrayIsEmpty() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = {};
        Person[] group2 = {person2, person1, person4, person3};
        Person[] expectedGroup = {person2, person1, person4, person3};
        PersonUtils main = new PersonUtils();
        Person[] returnGroup = main.mergeWithoutDuplicates(group1, group2);
        assertArrayEquals(expectedGroup,returnGroup);
    }

    @Test
    public void mergeUnionTestLeftArrayIsNull() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = null;
        Person[] group2 = {person2, person1, person4, person3};
        Person[] expectedGroup = null;
        System.out.println("Merge union left array is null test expected group is " + Arrays.toString(expectedGroup));
        PersonUtils main = new PersonUtils();
        try {
            Person[] returnGroup = main.mergeWithoutDuplicates(group1, group2);
            System.out.println("Merge union left array is null test returned group is " + Arrays.toString(returnGroup));
        } catch (NullPointerException e) {
            System.out.println("MergeUnionTestLeftArrayIsNull person test passed");
        }
    }

    @Test
    public void innerUnionTestPositive() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = {person1, person2};
        Person[] group2 = {person3, person1, person4};
        Person[] expectedGroup = {person1};
        PersonUtils main = new PersonUtils();
        Person[] returnGroup = main.innerUnion(group1, group2);
        assertArrayEquals(expectedGroup, returnGroup);
    }

    @Test
    public void innerUnionTestLeftArrayIsEmpty() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = {};
        Person[] group2 = {person3, person1, person4};
        Person[] expectedGroup = {};
        PersonUtils main = new PersonUtils();
        Person[] returnGroup = main.innerUnion(group1, group2);
        assertArrayEquals(expectedGroup,returnGroup);
    }

    @Test
    public void innerUnionTestLeftArrayIsNull() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = null;
        Person[] group2 = {person3, person1, person4, person2};
        Person[] expectedGroup = null;
        System.out.println("Inner union left array is null person test expected group is " + Arrays.toString(expectedGroup));
        PersonUtils main = new PersonUtils();
        try {
            Person[] returnGroup = main.innerUnion(group1, group2);
            System.out.println("Inner union left array is null person test returned group is " + Arrays.toString(returnGroup));
        } catch (NullPointerException e) {
            System.out.println("InnerUnionTestLeftArrayIsNull person test passed");
        }
    }

    @Test
    public void outerUnionTestPositive() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = {person1, person2};
        Person[] group2 = {person3, person1};
        Person[] expectedGroup = {person2,person3};
        PersonUtils main = new PersonUtils();
        Person[] returnGroup = main.outerUnion(group1, group2);
        assertArrayEquals(expectedGroup,returnGroup);
    }

    @Test
    public void outerUnionTestLeftArrayIsEmpty() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = {};
        Person[] group2 = {person3, person1, person4};
        Person[] expectedGroup = {person3, person1, person4};
        PersonUtils main = new PersonUtils();
        Person[] returnGroup = main.outerUnion(group1, group2);
        assertArrayEquals(expectedGroup,returnGroup);
    }

    @Test
    public void outerUnionTestLeftArrayIsNull() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = null;
        Person[] group2 = {person3, person1, person4, person2};
        Person[] expectedGroup = null;
        System.out.println("Outer union left array is null person test expected group is " + Arrays.toString(expectedGroup));
        PersonUtils main = new PersonUtils();
        try {
            Person[] returnGroup = main.outerUnion(group1, group2);
            System.out.println("Outer union left array is null person test returned group is " + Arrays.toString(returnGroup));
        } catch (NullPointerException e) {
            System.out.println("Outer Union Test Left Array IsNull person test passed");
        }
    }


}
