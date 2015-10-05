package org.com.diosoft.hw3;

public class PersonTests {

    public void verifyIsPersonEqual(Person a, Person b,boolean equalPerson) {
        boolean actualResult=PersonUtils.isEqual(a,b);
        boolean expectedResult=equalPerson;
        if(actualResult==expectedResult){
            System.out.println("Positive person test passed");
        }
        else {
            System.out.println("Positive person test failed");
        }
    }

    public void verifyIsPersonNotEqual(Person person1, Person person2,boolean notEqualPerson) {
        boolean actualResult=PersonUtils.isEqual(person1,person2);
        boolean expectedResult=notEqualPerson;
        if(actualResult==expectedResult){
            System.out.println("Negative person test passed");
        }
        else {
            System.out.println("Negative person test failed");
        }
    }


    public void mergeUnionTestPositive() {


    }

}
