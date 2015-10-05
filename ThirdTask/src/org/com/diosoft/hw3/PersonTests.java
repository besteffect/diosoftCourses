package org.com.diosoft.hw3;

import java.util.Arrays;

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

    public void mergeUnionTestPositive() {
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31, 2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31, 3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person[] group1 = {person1, person2, person3};
        Person[] group2 = {person2, person1, person4};

        Person[] expectedGroup = {person1,person2}; // expected result is here
        Arrays.sort(expectedGroup, new PersonComparator());
        System.out.println("Merge union positive person test expected group is " + Arrays.toString(expectedGroup));
        PersonUtils main = new PersonUtils();
        Person[] returnGroup = main.innerUnion(group1, group2);
        System.out.println("Merge union positive person test returned group is " + Arrays.toString(returnGroup));
    }

}
