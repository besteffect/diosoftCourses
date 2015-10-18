package org.com.diosoft.hw4;

import java.util.Arrays;

//local code review (vtegza): same comments as for ThirdTask @ 18.10.15
public class PersonUtils {

    public static boolean isEqual(Person person1,Person person2) {
        if (person1.equals(person2)) {
            System.out.println("Method isEqual. Persons "+person1.getFirstName()+" and "+person2.getFirstName()+" are equal");
            return  true;
        }
        else
            System.out.println("Method isEqual. Persons "+person1.getFirstName()+" and "+person2.getFirstName()+" are not equal");
        return false;
    }

    public static boolean isEqual(Person[] group1, Person[] group2) { //overloaded method
        if (Arrays.equals(group1,group2)) {
            System.out.println("Group1 is equal to group2");
            return  true;
        }
        else
            System.out.println("Group1 is not equal to group2");
        return false;
    }

    public Person[] mergeWithoutDuplicates(Person[] group1, Person[] group2) throws  MyException{
        if (group1==null || group2 == null){
            throw new MyException("Wrong values");
        }
        Person[] buffArray = Arrays.copyOf(group1, group1.length + group2.length);
        int index = group1.length;
        for (Person rightArrayElement : group2) {
            boolean isUnique = true;
            for (Person leftArrayElement : group1) {
                if (rightArrayElement.equals(leftArrayElement)){
                    isUnique = false;
                }
            }
            if (isUnique) {
                buffArray[index] = rightArrayElement;
                index++;
            }
        }
        Person[] resultArray;
        resultArray = Arrays.copyOf(buffArray, index);
        return resultArray;
    }

    public Person[] innerUnion(Person[] group1, Person[] group2) throws MyException {
        if (group1==null || group2 == null){
            throw new MyException("Wrong values");
        }
        int index = 0;
        Person[] buffArray = new Person[group1.length];
        for (int i = 0; i < group1.length; i++) {
            for (int j = 0; j < group2.length; j++) {
                if (group1[i] == group2[j]) {
                    boolean isUnique = true;
                    for (int k = 0; k < index; k++) {
                        if (buffArray[k] == group1[i]) {
                            isUnique = false;
                        }
                    }
                    if (isUnique) {
                        buffArray[index] = group1[i];
                        index++;
                    }
                }
            }
        }
        Person[] resultArray = Arrays.copyOf(buffArray, index);
        return resultArray;
    }

    public Person[] outerUnion(Person[] group1, Person[] group2) throws MyException{
        Person[] buffArray = new Person[group1.length+group2.length];

        int index = 0;
        boolean isUnique=false;
        for (int i = 0; i < group1.length; i++) {
            isUnique = false;
            for (int j = 0; j < group2.length; j++) {
                if (group1[i] == group2[j]) {
                    isUnique = true;
                }
            }
            if (!isUnique) {
                buffArray[index] = group1[i];
                index++;
            }
        }
        for (int j = 0; j < group2.length; j++) {
            isUnique = false;
            for (int i = 0; i < group1.length; i++) {
                if (group2[j] == group1[i]) {
                    isUnique = true;
                }
            }
            if(!isUnique){
                buffArray[index] = group2[j];
                index++;
            }
        }
        Person[]resultArray=Arrays.copyOf(buffArray,index); //  (length = index)
        return resultArray;
    }




}
