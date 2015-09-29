package hw3.org.com.diosoft;

import java.util.Arrays;

/**
 * Created by Smart on 9/27/2015.
 */
public class ArrayUtils {
    public void leftUnionTestPositive() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};
        ArrayUtils arrayUtils = new ArrayUtils();
        //local code review (vtegza): actually you are calling static method @ 27.09.15 Vitalii: fixed
        int[] returnValue = arrayUtils.leftUnion(leftArray, rightArray);

        System.out.println("ReturnValue leftUnionTestPositive: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArray leftUnionTestPositive: " + Arrays.toString(expectedArrays));
    }

    public void leftUnionTestLeftArrayIsEmpty() {
        int[] leftArray = {};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("Start value for LeftArray at leftUnionTestLeftArrayIsEmpty: " + Arrays.toString(leftArray));
        System.out.println("Start value for RightArray at leftUnionTestLeftArrayIsEmpty: " + Arrays.toString(rightArray));

        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.leftUnion(leftArray, rightArray);

        System.out.println("LeftUnionTestLeftArrayIsEmpty ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("LeftUnionTestLeftArrayIsEmpty ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    public void leftUnionTestLeftArrayIsNull() {
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("Left Union LeftArray leftUnionTestLeftArrayIsNull: " + Arrays.toString(leftArray));
        System.out.println("Left Union RightArray leftUnionTestLeftArrayIsNull: " + Arrays.toString(rightArray));

        ArrayUtils main = new ArrayUtils();
        try {
            int[] returnValue = main.leftUnion(leftArray, rightArray);
            System.out.println("ReturnValue leftUnionTestLeftArrayIsNull: " + Arrays.toString(returnValue));
            System.out.println("ExpectedArrays leftUnionTestLeftArrayIsNull: " + Arrays.toString(expectedArrays));

            System.out.println("LeftUnionTestLeftArrayIsEmpty test failed");
        } catch (NullPointerException e) {
            System.out.println("leftUnionTestLeftArrayIsEmpty test passed");
        }

    }

    //local code review (vtegza): should be not static @ 27.09.15
    public int[] leftUnion(int[] leftArray, int[] rightArray) {
        int[] buffArray = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);
        int countOfFoundElementsInRightArray = 0;

        for (int rightArrayElement : rightArray) {
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement == leftArrayElement) {
                    buffArray[leftArray.length + countOfFoundElementsInRightArray] = rightArrayElement;
                    countOfFoundElementsInRightArray++;
                }
            }
        }
        System.out.println("Count of found elements is: " + countOfFoundElementsInRightArray);
        int[] resultArray = Arrays.copyOf(buffArray, leftArray.length + countOfFoundElementsInRightArray);
        return resultArray;
    }

    public int[] mergeWithoutDuplicates(int[] leftArray, int[] rightArray) {
        int[] buffArray = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);


        int[] resultArray = new int[0];
        return resultArray;
    }



    public int[] innerUnion(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[0];
        return resultArray;
    }

    public int[] outerUnion(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[0];
        return resultArray;
    }
}
