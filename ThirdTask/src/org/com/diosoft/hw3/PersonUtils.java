package org.com.diosoft.hw3;

import java.util.Arrays;

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
}
