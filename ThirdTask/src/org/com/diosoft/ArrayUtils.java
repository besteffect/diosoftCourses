package org.com.diosoft;

import java.util.Arrays;

/**
 * Created by Smart on 9/27/2015.
 */
public class ArrayUtils {
    public void leftUnionTestPositive() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};
        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        ArrayUtils arrayUtils = new ArrayUtils();
        //local code review (vtegza): actually you are calling static method @ 27.09.15 Vitalii: fixed
        int[] returnValue = arrayUtils.leftUnion(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    public void leftUnionTestLeftArrayIsEmpty() {
        int[] leftArray = {};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.leftUnion(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    public void leftUnionTestLeftArrayIsNull() {
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.leftUnion(leftArray, rightArray);
        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    //local code review (vtegza): should be not static @ 27.09.15
    public int[] leftUnion(int[] leftArray, int[] rightArray) {
        int[] buffArray = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);
        int countOfFoundElementsinRightArray = 0;

        for (int rightArrayElement : rightArray) {
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement == leftArrayElement) {
                    buffArray[leftArray.length + countOfFoundElementsinRightArray] = rightArrayElement;
                    countOfFoundElementsinRightArray++;
                }
            }
        }
        System.out.println("Count of found elements is: " + countOfFoundElementsinRightArray);
        System.out.println("BuffArray after search is: " + Arrays.toString(buffArray));
        int[] resultArray = Arrays.copyOf(buffArray, leftArray.length + countOfFoundElementsinRightArray);
        return resultArray;
    }

    public static int[] mergeWithoutDuplicates(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[0];
        return resultArray;
    }

    public static int[] innerUnion(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[0];
        return resultArray;
    }

    public static int[] outerUnion(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[0];
        return resultArray;
    }
}
