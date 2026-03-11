package BinarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int [] arr = {3,4,5,6,7,8,9,10,23,45,47,49,52,54,56,78,89,};
        int target = 7;
        System.out.print(answer(arr,target));
    }
    static int answer(int[] arr, int target){
        //first we need to find the range
        //start with the window size 2
        int start = 0;
        int end = 1;


        // check if the target is in the range basically check if the target is less than end
        // keep doubling the window size until the target is less than end :) cause the array is sorted(ASCENDING)
        while(target > arr[end]){
            int newStart = end +1;
            //double the window size
            end = end + (end - start + 1) * 2;
            //end = end + previous end + sizeofBox * 2
            start = newStart;
        }
        return BinarySearchMethod(arr , target, start,end);
    }
    static int BinarySearchMethod(int[] arr, int target ,int start , int end ){
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
        return -1;
    }
}
