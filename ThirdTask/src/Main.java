import java.util.Arrays;

/**
 * Created by vsv on 9/25/2015.
 */
public class Main {
    public static void main(String[]args){

        int[] leftArray={1,5,4,23,65,32,78};
        System.out.println("Left array is" +Arrays.toString(leftArray));
        int[] rightArray={3,5,24,4,1,2,34,45,32,5};
        int[] expectedArray={1,5,4,23,65,32,78,5,4,1,32,5};

        int[]result=leftUnion(leftArray, rightArray);
//        for(int element:result){ //simple print
//            System.out.println("LeftUnion result is: " + element); //как распечатать одной строкой?
//        }
        System.out.println("LeftUnion printed with toString "+Arrays.toString(result));
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
