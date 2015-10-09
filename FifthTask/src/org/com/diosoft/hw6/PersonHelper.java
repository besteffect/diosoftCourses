package org.com.diosoft.hw6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonHelper {

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

    public Set<Person> mergeWithoutDuplicates(Set<Person> group1, Set<Person> group2) throws MyException {
        if (group1==null || group2 == null){
            throw new MyException("Wrong values");
        }
        Set set1 = new HashSet(group1);
       // for (int i = 0 ; i < group1.size() ; i++)
         //   set1.add(i);
       // Set set2 = new HashSet(group2);
        //for (int i = 0 ; i < group2.size() ; i++)
          //  set2.add(i);
        set1.addAll(group2);
        return set1;
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
        return removeNullName(resultArray);
    }

    public Person[] outerUnion(Person[] group1, Person[] group2) throws MyException {
        if (group1==null || group2==null) return null;
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
        return removeNullName(resultArray);
    }

//добавить проверку для каждого Person на не пустой и не null name
    public Person[] removeNullName (Person[] array){
        Person[] buffArray = new Person[array.length];
        int counter = 0;
        for (Person s : array) {
            if (s != null) {
                buffArray[counter++] = s;
            }
        }
        Person[] result = new Person[counter];
        System.arraycopy(buffArray, 0, result, 0, counter);
        return result;

    }

}
