// 169 : Majority Element

//link : https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
//

import java.util.Arrays;

public class MajorityElement{

//    approach 1 : sort the array then reutrn mid element :
//    concept : majority element is the element which come more than the size of the array so when we sort the arry so some part of the majority elemnt lye after the mid eleemnt .
//    O(nlogn)+O(1)=O(nlogn)
//    O(n) (due to the sorting algorithm)
public static int myMajorityElement(int arr[]){
    Arrays.sort(arr);
    int start = 0;
    int end = arr.length -1;
    return arr[start + (end - start)/2];
}

// approch 2 : Using count (refrence XOR ) oprator
// logic :(Boyer-Moore Voting Algorithm, ) :  count of majority element is always greater then others element
//    Overall Time Complexity O(n)
//    Overall Space Complexity O(1)
    public static int majorityELement(int[] arr){
        int candidate = 0;
        int count = 0;
        for(int i : arr){
            if(count == 0){
                candidate = i;
            }
            if(candidate == i){
                count++;
            }else{count--;}

        }
        return candidate;
    }

//    for edge case
//    time : o(n) space : O(1)
public static int majorityELementExist(int[] arr){
    int candidate = 0;
    int count = 0;
    for(int i : arr){
        if(count == 0){
            candidate = i;
        }
        if(candidate == i){
            count++;
        }else{count--;}

    }
    count =0;
    for(int i:arr){
        if(i == candidate){
            count++;
        }
    }

    if(count > arr.length /2){
        return candidate;
    }else{
        throw new IllegalArgumentException("No majority element found");
    }
}

public static void main(String[] args) {
    int arr[] = {2,3,2,3};
    System.out.println(myMajorityElement((arr)));
//    System.out.println(majorityELement((arr)));
//    System.out.println(majorityELementExist((arr)));
}
}
