package org.com.diosoft;

import java.util.Arrays;

/**
 * Created by Smart on 9/27/2015.
 */
public class Main {
    public static void main(String[] args) {
        int[] leftUnionLeftArray = {1, 5, 4, 23, 65, 32, 78};
        System.out.println("Left union array is" + Arrays.toString(leftUnionLeftArray));
        int[] LeftUnionRightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        ArrayUtils obj = new ArrayUtils();
        int[] result = obj.leftUnion(leftUnionLeftArray, LeftUnionRightArray);
        System.out.println("LeftUnion printed with toString " + Arrays.toString(result));
        obj.leftUnionTestPositive();
        obj.leftUnionTestLeftArrayIsEmpty();
        obj.leftUnionTestLeftArrayIsNull();

        //local code review (vtegza): not used @ 27.09.15 Vitalii: fixed
        int[] innerUnionLeftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] innerUnionRightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] innerUnionExpectedArray = {5, 4, 32, 1};

        int[] outerUnionLeftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] outerUnionRightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] outerUnionExpectedArray = {23, 65, 78, 3, 24, 2, 34, 45};

    }
}
