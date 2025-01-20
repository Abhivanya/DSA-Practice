// merge Sorted Array 150
// Link : https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

// Description : You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.


import java.util.Arrays;
public class MergeSortedArray {

//    approach : compare the both array from end and store the smallest element in the end of first element and decrease the pointer untile one of the pointer of both array get less then 0 then check for second array agin if its pointer is not less then 0 then copy all element of it to the first array
//    time : O(m+n); space : O(1)
    public  static void mergeSortedArrayInFirst(int arr1[],int arr2[],int m,int n){
        int p1 = m-1;
        int p2 = n-1;
        int k = arr1.length -1;  // point the last of arr1
        while(p1>=0 && p2 >= 0){
            if(arr2[p2] >= arr1[p1]){
                arr1[k--] = arr2[p2--];

            }else{
                arr1[k--] = arr1[p1--];
            }
        }
        while (p2>=0){
            arr1[k--] = arr2[p2--];
        }
    }

//    approach 2 : using temp array
//    overall time : O(m+n) + O(m+n) = O(m+n)  space : O(m+n)
    public static void mergeArray(int arr1[],int arr2[], int m,int n){
        int tempArray[] = new int[m+n];
        int p1,p2,k;
        p1=p2=k=0;
        while(p1<m&& p2 <n){
            if(arr1[p1]<=arr2[p2]){
                tempArray[k++] = arr1[p1++];
            }else{
                tempArray[k++] = arr2[p2++];
            }
        }
        while (p1<m){
            tempArray[k++] = arr1[p1++];
        }
        while (p2<n){
            tempArray[k++] = arr2[p2++];
        }
        for(int i=0; i<arr1.length; i++){
            arr1[i] = tempArray[i];
        }

    }

    public static void main(String[] args) {
       int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

//        mergeSortedArrayInFirst(nums1,nums2,m,n);
        mergeArray(nums1,nums2,m,n);
        System.out.println(Arrays.toString(nums1));

    }
}


