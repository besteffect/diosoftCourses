package org.com.diosoft.hw3;

import java.util.Comparator;

public abstract class PersonComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        Integer p1Id = p1.getId();
        Integer p2Id = p2.getId();
        return p1Id.compareTo(p2Id);

//        if(p1Id > p2Id){
//            return 1;
//        }
//        else if (p1Id < p2Id){
//            return -1;
//        }else {
//            return 0;
//        }
    }
}
