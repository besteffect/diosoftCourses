package org.com.diosoft.hw3;

import java.util.Arrays;

public class ArrayUtils {


    //local code review (vtegza): should be not static @ 27.09.15 Vitaliy: DONE
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
       // System.out.println("Count of found elements for left union is: " + countOfFoundElementsInRightArray);
        return Arrays.copyOf(buffArray, leftArray.length + countOfFoundElementsInRightArray);
    }

    public int[] mergeWithoutDuplicates(int[] leftArray, int[] rightArray) {
        int[] buffArray = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);
        int index = leftArray.length;
        for (int rightArrayElement : rightArray) {
            boolean isUnique = true;
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement == leftArrayElement) {
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

    public int[] innerUnion(int[] leftArray, int[] rightArray) {
        int index = 0;
        int[] buffArray = new int[leftArray.length];
        for (int leftArrayElement : leftArray) {
            for (int rightArrayElement : rightArray) {
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
                        // System.out.println("Common Number: " + leftArray[i]);
                    }
                }
            }
        }
        return Arrays.copyOf(buffArray, index);
    }

    public int[] outerUnion(int[] leftArray, int[] rightArray) {
        int[] buffArray = new int[leftArray.length+rightArray.length]; //here I am saving numbers to the final array
        int index = 0; // creating index for counting the number of elements in final array
        boolean isUnique=false;

        for (int leftArrayElement : leftArray) {
            isUnique = false;
            for (int rightArrayElement : rightArray) {
                if (leftArrayElement == rightArrayElement) {
                    isUnique = true;
                }
            }
            if (!isUnique) {
                buffArray[index] = leftArrayElement;//  adding elements to the first part of buffArray
                index++; //number of elements in first part of array
                //System.out.println("Outer union. Result from left array is: " + leftArray[i]);
            }
        }
        for (int rightArrayElement : rightArray) {
            isUnique = false;
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement == leftArrayElement) {
                    isUnique = true;
                }
            }
            if (!isUnique) {
                //System.out.println("Outer union. Result from right array is: " + rightArray[j]);
                buffArray[index] = rightArrayElement;//adding elements to the second part of buffArray
                index++; //number of elements in second part of array
            }
        }
        return Arrays.copyOf(buffArray,index);
    }
}
