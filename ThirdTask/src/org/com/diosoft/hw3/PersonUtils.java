package org.com.diosoft.hw3;

import java.util.Arrays;

//local code review (vtegza): eliminate code duplicate @ 18.10.15
public class PersonUtils {

    public static boolean isEqual(Person person1,Person person2) {
        if (person1.equals(person2)) {
            System.out.println("Method isEqual. Persons "+ person1.getFirstName()+" and "+person2.getFirstName()+" are equal");
            return  true;
        }
        else
            System.out.println("Method isEqual. Persons "+ person1.getFirstName()+" and "+person2.getFirstName()+" are not equal");
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

    public Person[] mergeWithoutDuplicates(Person[] group1, Person[] group2) {
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
        return Arrays.copyOf(buffArray, index);
    }

    public Person[] innerUnion(Person[] group1, Person[] group2) {
        if (group1 == null || group2 == null) return null;
        int index = 0;
        Person[] buffArray = new Person[group1.length];
        for (Person leftArrayElement : group1) {
            for (Person rightArrayElement : group2) {
                if (leftArrayElement == rightArrayElement) {
                    boolean isUnique = true;
                    for (int k = 0; k < index; k++) {
                        if (buffArray[k] == leftArrayElement) {
                            isUnique = false;
                        }
                    }
                    if (isUnique) {
                        buffArray[index] = leftArrayElement;
                        index++;
                    }
                }
            }
        }
        return Arrays.copyOf(buffArray, index);
    }

    public Person[] outerUnion(Person[] group1, Person[] group2) {
        Person[] buffArray = new Person[group1.length+group2.length];
        int index = 0;
        boolean isUnique; //false by default
        for (Person leftArrayElement : group1) {
            isUnique = false;
            for (Person rightArrayElement : group2) {
                if (leftArrayElement == rightArrayElement) {
                    isUnique = true;
                }
            }
            if (!isUnique) {
                buffArray[index] = leftArrayElement;
                index++;
            }
        }
        //local code review (vtegza): fore each clould be used @ 18.10.15 Vitaliy: DONE
        for (Person rightArrayElement : group2) {
            isUnique = false;
            for (Person leftArrayElement : group1) {
                if (rightArrayElement == leftArrayElement) {
                    isUnique = true;
                }
            }
            if (!isUnique) {
                buffArray[index] = rightArrayElement;
                index++;
            }
        }
        return Arrays.copyOf(buffArray,index);
    }




}
