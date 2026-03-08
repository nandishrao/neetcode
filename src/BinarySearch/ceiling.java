package BinarySearch;

public class ceiling {
    public static void main(String[] args) {
        int[] arr = {1,4,5,7,9,10,14,15,17,19};
        int target = 13; // returns index 6 => 14 cause smallest greatest number if target not found

        int ans = CeilingMethod(arr, target);
        System.out.println(ans);
    }
    // The smallest element greater than the target
    static int CeilingMethod(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        //if target is the largest in the array, in that case no ceiling
        if (target > arr[arr.length-1]){
            return -1;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return start;
        //When the while loop ends and violates the condition, we for sure know that the target element does
        //not exist, now we need to find the smallest element greater than the target here start > end we return start
        //which satisfies the condition - finding the smallest element greater than the target
    }
}