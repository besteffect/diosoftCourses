package org.com.diosoft;
import java.util.Arrays;

/**
 * Created by vsv on 9/25/2015.
 */
public class Main {
    public static void main(String[]args){

        int[] leftUnionLeftArray={1,5,4,23,65,32,78};
        System.out.println("Left union array is" +Arrays.toString(leftUnionLeftArray));
        int[] LeftUnionRightArray={3,5,24,4,1,2,34,45,32,5};
        int[]result=leftUnion(leftUnionLeftArray, LeftUnionRightArray);
        System.out.println("LeftUnion printed with toString "+Arrays.toString(result));
        leftUnionTestPositive();
        leftUnionTestLeftArrayIsEmpty();
        leftUnionTestLeftArrayIsNull();

        int[] innerUnionLeftArray={1,5,4,23,65,32,78};
        int[] innerUnionRightArray={3,5,24,4,1,2,34,45,32,5};
        int[] innerUnionExpectedArray={5,4,32,1};

        int[] outerUnionLeftArray={1,5,4,23,65,32,78};
        int[] outerUnionRightArray={3,5,24,4,1,2,34,45,32,5};
        int[] outerUnionExpectedArray={23,65,78,3,24,2,34,45};

    }

    private static  void leftUnionTestPositive(){
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};
        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        Main main =new Main();
        int[] returnValue=main.leftUnion(leftArray,rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    private static void leftUnionTestLeftArrayIsEmpty() {
        int[] leftArray = {};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        Main main = new Main();
        int[] returnValue = main.leftUnion(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    private static void leftUnionTestLeftArrayIsNull() {
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        Main main = new Main();
        int[] returnValue = main.leftUnion(leftArray, rightArray);
        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));
    }

    public static int[] leftUnion(int[] leftArray, int[] rightArray)
    {
        int[] buffArray=Arrays.copyOf(leftArray, leftArray.length+rightArray.length);
        int countOfFoundElementsinRightArray=0;

        for(int rightArrayElement: rightArray){
            for(int leftArrayElement: leftArray){
                if(rightArrayElement==leftArrayElement){
                    buffArray[leftArray.length+countOfFoundElementsinRightArray]=rightArrayElement;
                    countOfFoundElementsinRightArray++;
                }
            }
        }
        System.out.println("Count of found elements is: " +countOfFoundElementsinRightArray);
        System.out.println("BuffArray after search is: " + Arrays.toString(buffArray));
        int[] resultArray=Arrays.copyOf(buffArray,leftArray.length+ countOfFoundElementsinRightArray);
        return resultArray;
    }

    public static  int[] mergeWithoutDuplicates(int[] leftArray, int[] rightArray){
        int[] resultArray = new int[0];
        return resultArray;
    }

    public static int[] innerUnion(int[] leftArray, int[] rightArray){
        int[] resultArray = new int[0];
        return resultArray;
    }

    public static int[] outerUnion(int[] leftArray, int[] rightArray){
        int[]resultArray=new int[0];
        return resultArray;
    }


}
