class CountingSort{

    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
    
    // to find largest element in the array
        for(int i=0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }
    // 2 create a new count array of largest + 1 size to count elemnt in array
    int count[] = new int[largest+1];
    
    // counting the element accurence(frequency of Array)
    for(int i=0; i<arr.length; i++){
        count[arr[i]]++;
    }

// performing sorting
    int j=0;
    for(int i=0; i<count.length; i++){
        while(count[i]>0){
            arr[j] = i;
            j++;
            count[i]--;
        }
    }
    }


    public static void main(String args[]){
        int arr[] = {12,5,63,34,6,9};
        int size =arr.length;
        countingSort(arr);
        for(int i=0; i<size; i++){
            System.out.print(arr[i] + " ");
        }
    }
}