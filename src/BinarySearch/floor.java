package BinarySearch;

public class floor {
    public static void main(String[] args) {
        int[] arr = {1,4,5,7,9,10,14,15,17,19};
        int target = 13; // returns index 5 => 10 cause greatest number, smaller than the target

        int ans = floorMethod(arr, target);
        System.out.println(ans);
    }
    // greatest element smaller than the target
    static int floorMethod(int[] arr, int target){
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
        return end ;
        // same logic as ceiling but return end
    }
}
