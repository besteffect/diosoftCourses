import java.util.Arrays;

/**
 * Created by vsv on 9/25/2015.
 */
public class Main {
    public static void main(String[]args){

        int[] leftArray={1,5,4,23,65,32,78};
        System.out.println("Left array is" +Arrays.toString(leftArray));
        int[] rightArray={3,5,24,4,1,2,34,45,32,5};
        int[]result=leftUnion(leftArray, rightArray);
//        for(int element:result){ //simple print
//            System.out.println("LeftUnion result is: " + element); //как распечатать одной строкой?
//        }
        System.out.println("LeftUnion printed with toString "+Arrays.toString(result));
        testPositive();
        testLeftArrayIsEmpty();
        testLeftArrayIsNull();
    }


    private static  void testPositive(){
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

    private static void testLeftArrayIsEmpty() {
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

    private static void testLeftArrayIsNull() {
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

}
