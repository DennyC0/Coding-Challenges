import java.lang.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(medianOfTwoSortedArrays(nums1, nums2));
        // outcome = 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(medianOfTwoSortedArrays(nums3, nums4));
        // outcome = 2.5

        int[][] lists1 = { {1,4,5}, {1, 3, 4}, {2, 6} };
        System.out.println(mergedSortedList(lists1));
        // outcome = [1, 1, 2, 3, 4, 4, 5, 6]

        int[][] lists2 = {};
        System.out.println(mergedSortedList(lists2));
        // outcome = []

        int[][] lists3 = {{}};
        System.out.println(mergedSortedList(lists3));
        // outcome = []

    }
    public static double medianOfTwoSortedArrays(int[] nums1, int[] nums2){

        double median = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArr = new int[m + n];
        int index = 0;

        // adding values from both arrays
        for(int i = 0; i < mergedArr.length; i++){
            if(i <= m - 1){
                mergedArr[i] = nums1[i];
            }
            if(i > m - 1){
                mergedArr[i] = nums2[index];
                index++;
                if(index > n - 1){
                    break;
                }
            }
        }

        // sorting new merged array
        Arrays.sort(mergedArr);

        // finding the median of new array
        if(mergedArr.length%2 != 0){
            median = mergedArr[(m + n)/2];
        }
        if(mergedArr.length%2 == 0){
            double sum = mergedArr[(m + n - 1)/2] + mergedArr[(m + n)/2];
            median = sum/2;
        }

        return median;
    }

    public static LinkedList<Integer> mergedSortedList(int[][] arrayLinkedLists){
        int k = arrayLinkedLists.length;
        LinkedList<Integer> mergedSortedList = new LinkedList<Integer>();
        int j = 0;

        // iteration to add individual value of each linked-list to one list
        for(int i = 0; i < k; i++){
            // set j to zero after each iteration for the length of lists k
            if(j != 0){
                j = 0;
            }
            while(j < arrayLinkedLists[i].length){
                mergedSortedList.add(arrayLinkedLists[i][j]);
                j++;
            }
        }
        // sorting new linked list
        Collections.sort(mergedSortedList);

        return mergedSortedList;
    }
}
