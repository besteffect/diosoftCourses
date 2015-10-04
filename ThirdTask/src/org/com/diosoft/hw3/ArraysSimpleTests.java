package org.com.diosoft.hw3;

import java.util.Arrays;

//local code review (vtegza): creat junit tests @ 04.10.15
public class ArraysSimpleTests {

    public void leftUnionTestPositive() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};
        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.leftUnion(leftArray, rightArray);
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
        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.mergeWithoutDuplicates(leftArray, rightArray);
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

   public void innerUnionTestPositive(){
       int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
       int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
       int[] expectedArray = {5, 4, 32, 1};
       ArrayUtils main = new ArrayUtils();
       int[] returnValue = main.innerUnion(leftArray, rightArray);
       System.out.println("InnerUnionTestPositive ReturnValue: " + Arrays.toString(returnValue));
       System.out.println("InnerUnionTestPositive ExpectedArrays: " + Arrays.toString(expectedArray));
   }

    public void innerUnionTestLeftArrayIsEmpty() {
        int[] leftArray = {};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArray = {};
        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.innerUnion(leftArray, rightArray);
        System.out.println("InnerUnionTestLeftArrayIsEmpty ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("InnerUnionTestLeftArrayIsEmpty ExpectedArrays: " + Arrays.toString(expectedArray));
    }

    public void innerUnionTestLeftArrayIsNull() {
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArray = {};
        ArrayUtils main = new ArrayUtils();
        try {
            int[] returnValue = main.innerUnion(leftArray, rightArray);
            System.out.println("ReturnValue innerUnionTestLeftArrayIsNull: " + Arrays.toString(returnValue));
            System.out.println("ExpectedArrays innerUnionTestLeftArrayIsNull: " + Arrays.toString(expectedArray));
            System.out.println("InnerUnionTestLeftArrayIsEmpty test failed");
        } catch (NullPointerException e) {
            System.out.println("MergeUnionTestLeftArrayIsEmpty test passed");
        }
    }

    public  void outerUnionTestPositive(){
        int[] leftArray={1, 5, 4, 23, 65, 32, 78};
        int[] rightArray={3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArray = {23, 65, 78, 3, 24, 2, 34, 45};
        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.outerUnion(leftArray, rightArray);
        System.out.println("OuterUnionTestPositive ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("OuterUnionTestPositive ExpectedArrays: " + Arrays.toString(expectedArray));
    }

    public void outerUnionTestLeftArrayIsEmpty(){
        int[] leftArray={};
        int[] rightArray={3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        ArrayUtils main = new ArrayUtils();
        int[] returnValue = main.outerUnion(leftArray, rightArray);
        System.out.println("OuterUnionTestLeftArrayIsEmpty ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("OuterUnionTestLeftArrayIsEmpty ExpectedArrays: " + Arrays.toString(expectedArray));

    }
    public void outerUnionTestLeftArrayIsNull(){
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArray = {};
        ArrayUtils main = new ArrayUtils();
        try {
            int[] returnValue = main.outerUnion(leftArray, rightArray);
            System.out.println("ReturnValue OuterUnionTestLeftArrayIsNull: " + Arrays.toString(returnValue));
            System.out.println("ExpectedArrays OuterUnionTestLeftArrayIsNull: " + Arrays.toString(expectedArray));
            System.out.println("OuterUnionTestLeftArrayIsEmpty test failed");
        } catch (NullPointerException e) {
            System.out.println("OuterUnionTestLeftArrayIsEmpty test passed");
        }
    }
}
