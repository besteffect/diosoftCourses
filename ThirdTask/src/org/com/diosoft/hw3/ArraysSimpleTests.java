package org.com.diosoft.hw3;

import java.util.Arrays;

/**
 * Created by Smart on 10/4/2015.
 */
public class ArraysSimpleTests {

    public void leftUnionTestPositive() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};
        ArrayUtils arrayUtils = new ArrayUtils();
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
            System.out.println("LeftUnionTestLeftArrayIsEmpty test passed");
        }
    }

    public void mergeUnionTestPositive() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        int[] expectedArray = {1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45};
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] returnValue = arrayUtils.mergeWithoutDuplicates(leftArray, rightArray);
        System.out.println("ReturnValue mergeUnionTestPositive: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArray mergeUnionTestPositive: " + Arrays.toString(expectedArray));
    }

    public void mergeUnionTestLeftArrayIsEmpty() {
        int[] leftArray = {};
        int[] rightArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        int[] expectedArrays = {};
        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.mergeWithoutDuplicates(leftArray, rightArray);
        System.out.println("MergeUnionTestLeftArrayIsEmpty ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("MergeUnionTestLeftArrayIsEmpty ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    public void mergeUnionTestLeftArrayIsNull(){
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        int[] expectedArrays = {};
        System.out.println("Merge Union LeftArray leftUnionTestLeftArrayIsNull: " + Arrays.toString(leftArray));
        System.out.println("Merge Union RightArray leftUnionTestLeftArrayIsNull: " + Arrays.toString(rightArray));
        ArrayUtils main = new ArrayUtils();
        try {
            int[] returnValue = main.leftUnion(leftArray, rightArray);
            System.out.println("ReturnValue mergeUnionTestLeftArrayIsNull: " + Arrays.toString(returnValue));
            System.out.println("ExpectedArrays mergeUnionTestLeftArrayIsNull: " + Arrays.toString(expectedArrays));
            System.out.println("MergeUnionTestLeftArrayIsEmpty test failed");
        } catch (NullPointerException e) {
            System.out.println("MergeUnionTestLeftArrayIsEmpty test passed");
        }

    }

}
