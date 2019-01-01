package Algo;

import java.util.Arrays;
import java.util.Collection;

public class MinAbsDifference {
    public static void main(String[] args){
        System.out.println("Test BS1 " + binarySearch(9, new int[]{1,2,10,19,233}));
        System.out.println("Test BS2 " + binarySearch(9, new int[]{1}));
        System.out.println("Test BS3 " + binarySearch(9, new int[]{10,19,233}));
        System.out.println("Test BS4 " + binarySearch(9, new int[]{1,2}));
        System.out.println("Test BS5 " + binarySearch(9, new int[]{1,10}));
        System.out.println("Test MAD1 " + MinAbsDifference(new int[]{1,2,3,4,5,6}, new int[]{1,10}));
        System.out.println("Test MAD2 " + MinAbsDifference(new int[]{1}, new int[]{100,10000000}));
        System.out.println("Test MAD3 " + MinAbsDifference(new int[]{1,2,3,4,5,6}, new int[]{1,10}));
        System.out.println("Test MAD4 " + MinAbsDifference(new int[]{1,2,3,4,5,6}, new int[]{0,100000000}));
        System.out.println("Test MAD5 " + MinAbsDifference(new int[]{1,2,5,6}, new int[]{3,4}));
    }


    public static int MinAbsDifference(int[] array1, int[] array2){
        if(array1 == null || array2 == null || array1.length == 0 || array2.length == 0) return Integer.MAX_VALUE;
        int[] sortArray = null;
        int[] iterateArray = null;
        if(array1.length > array2.length){
            sortArray = array2;
            iterateArray = array1;
        }else{
            sortArray = array1;
            iterateArray = array2;
        }
        Arrays.sort(sortArray);
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < iterateArray.length; i++){
            int number1 = iterateArray[i];
            int number2 = binarySearch(number1, sortArray);
            ret = Math.min(ret, Math.abs(number1 - number2));
        }
        return ret;
    }

    public static int binarySearch(int number, int[] array){
        if(array == null || array.length == 0) return Integer.MAX_VALUE;
        int start = 0;
        int end = array.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(array[mid] == number) return number;
            else if(array[mid] < number){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(start == 0) return array[0];
        if(start == array.length) return array[array.length - 1];
        int diff1 = Math.abs(array[start] - number);
        int diff2 = Math.abs(array[start - 1] - number); // be careful, this is start - 1. start index points to the locatio where number should be insert.
        if(diff1 < diff2){
            return array[start];
        }else{
            return array[start - 1];
        }
    }
}

// Solution2
// O(nlogn)
public int smallestDifference(int[] array1, int[] array2){
    Arrays.sort(array1);
    Arrays.sort(array2);
    int min = Integer.MAX_VALUE;
    int index1 = 0;
    int index2 = 0;
    while(index1 < array1.length && index2 < array2.length){
        int diff = array1[index1] - array2[index2];
        min = Math.min(min, diff);
        if(array1[index1] < array2[index2]){
            index1++;
        }else{
            index2++;
        }
    }
    return min;
}






