package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,4,5,7,9,10,14,15,17,19};
        int target = 10;

        int ans = BinarySearchMethod(arr, target);
        System.out.println(ans);
    }

    static int BinarySearchMethod(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

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