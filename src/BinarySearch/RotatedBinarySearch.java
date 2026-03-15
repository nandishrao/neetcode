package BinarySearch;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 6, 7};
        int target = 5;
        int answer = search(arr,target);
        System.out.print(answer);
    }

    static int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        // if no pivot -> pivot = -1, then the array is not rotated hence run normal binary search
        if (pivot == -1) return BinarySearchMethod(arr, target, 0, arr.length - 1);
        // if the pivot is the target element then return the pivot
        if (arr[pivot] == target) {
            return pivot;
        }

        // if the pivot is found then we have 2 sorted ASC arrays
        if (target > arr[0]) {
            // if the target element is greater than start then find the target till pivot-1 cause the array is rotated
            // EG : [4,5,6,7,0,1,2] target = 6
            return BinarySearchMethod(arr, target, 0, pivot - 1);
        }
        return BinarySearchMethod(arr, target, pivot + 1, arr.length - 1);


    }

    static int BinarySearchMethod(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //4 case to find pivot
            if (mid < end && arr[mid] > arr[mid+1] ) {//mid should be less than end
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] <= arr[start]) {//this is to move the pointer if the pivot id not found from mid's left or right
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }
}
