package org.com.diosoft.hw3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayUtils method = new ArrayUtils();
        ArraysSimpleTests tests = new ArraysSimpleTests();
        PersonTests personTests = new PersonTests();
        PersonUtils personUtils = new PersonUtils();

//Left Union array and tests calls
        int[] leftUnionLeftArray = {1, 5, 4, 23, 65, 32, 78};
        System.out.println("Condition. Left union Left Array is " + Arrays.toString(leftUnionLeftArray));
        int[] LeftUnionRightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        System.out.println("Condition. Left union Right Array is " + Arrays.toString(LeftUnionRightArray));
        int[] LeftUnionExpectedArray = {1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};
        System.out.println("Condition. Left union Expected array " + Arrays.toString(LeftUnionExpectedArray));
        int[] leftUnionResult = method.leftUnion(leftUnionLeftArray, LeftUnionRightArray);
        System.out.println("LeftUnionResult " + Arrays.toString(leftUnionResult));
        tests.leftUnionTestPositive();
        tests.leftUnionTestLeftArrayIsEmpty();
        tests.leftUnionTestLeftArrayIsNull();



//Merge union array and tests calls
        int[] mergeUnionLeftArray = {1, 5, 4, 23, 65, 32, 78};
        System.out.println("Condition. Merge union Left Array is " + Arrays.toString(mergeUnionLeftArray));
        int[] mergeUnionRightArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        System.out.println("Condition. Merge union Right Array is " + Arrays.toString(mergeUnionRightArray));
        int[] mergeUnionExpectedArray = {1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45};
        System.out.println("Condition. Merge union Expected Array is " + Arrays.toString(mergeUnionExpectedArray));
        int[] mergeUnionResult = method.mergeWithoutDuplicates(mergeUnionLeftArray, mergeUnionRightArray);
        System.out.println("MergeUnionResult: " + Arrays.toString(mergeUnionResult));
        tests.mergeUnionTestPositive();
        tests.mergeUnionTestLeftArrayIsEmpty();
        tests.mergeUnionTestLeftArrayIsNull();

//Inner union array and tests calls
        int[] innerUnionResult = method.innerUnion(leftUnionLeftArray, LeftUnionRightArray);
        System.out.println("InnerUnionResult: " + Arrays.toString(innerUnionResult));
        tests.innerUnionTestPositive();
        tests.innerUnionTestLeftArrayIsEmpty();
        tests.innerUnionTestLeftArrayIsNull();

//Outer union array and tests calls
        int[] outerUnionResult = method.outerUnion(leftUnionLeftArray, LeftUnionRightArray);
        System.out.println("OuterUnionResult: " + Arrays.toString(outerUnionResult));
        tests.outerUnionTestPositive();
        tests.outerUnionTestLeftArrayIsEmpty();
        tests.outerUnionTestLeftArrayIsNull();

//Persons
        //creating persons and groups of persons
        Person person1 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        Person person2 = new Person("Pelageya", "Chepurnenka", 31,2, JobTitleEnum.DEVELOPER);
        Person person3 = new Person("Antoniy", "Cheburashka", 31,3, JobTitleEnum.QA);
        Person person4 = new Person("Petro", "Sodrugailo", 40, 1, JobTitleEnum.DIRECTOR);
        PersonUtils.isEqual(person1,person2);
        PersonUtils.isEqual(person1,person1);
        Person[] group1 = {person1,person2,person3};
        Person[] group2 = {person2,person1,person3};
        Person[] group3={person4, person3,person2};

        PersonUtils.isEqual(group1, group2);

//Person equals tests
        personTests.verifyIsPersonEqual(person1, person4, true);
        personTests.verifyIsPersonNotEqual(person1, person2, false);

        //calling PersonUtils basic methods
        personUtils.mergeWithoutDuplicates(group1, group2);
        Person [] mergeWithoutDuplicatesResult=personUtils.mergeWithoutDuplicates(group1,group2);
        System.out.println("MergeWithoutDuplicates Method result" + Arrays.toString(mergeWithoutDuplicatesResult));

        personUtils.innerUnion(group1, group2);
        Person [] innerUnionPersonResult=personUtils.innerUnion(group1,group2);
        System.out.println("Inner Union Method result" + Arrays.toString(innerUnionPersonResult));

        personUtils.outerUnion(group1, group2);
        Person [] outerUnionPersonResult=personUtils.innerUnion(group1,group2);
        System.out.println("Outer Union Method result" + Arrays.toString(outerUnionPersonResult));
    }

}
