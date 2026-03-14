package BinarySearch;

public class MountainArray {
    public static void main(String[] args) {
    int[] arr={1,2,3,4,5,6,7,8,9,10};
    int ans = FindingPeak(arr);
    System.out.print(ans);
    }
    static int FindingPeak(int [] arr){
        int start = 0;
        int end = arr.length-1;
        while (start <  end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                //you're in the decreasing part of the array
                //this might be the answer, but we must look in the left.
                //this is why end is not mid-1
                end = mid;
            }else{
                //you're at the ascending part of the array
                start = mid +1 ; //because we know that mid+1 element > mid-element

            }
        }
        //in the end start == end and pointing to the answer(largest answer) cause of the two conditions above
        //start and end are always trying to find the largest element in the array, hence when they point the same one element
        //that's the largest element
        return start;
    }

}
