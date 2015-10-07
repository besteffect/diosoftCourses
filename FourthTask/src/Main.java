import org.com.diosoft.hw4.JobTitleEnum;
import org.com.diosoft.hw4.MyException;
import org.com.diosoft.hw4.Person;
import org.com.diosoft.hw4.PersonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MyException {
        PersonUtils personUtils = new PersonUtils();


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
