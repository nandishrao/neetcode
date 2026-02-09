package arrays;

import java.util.HashMap;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int [] nums ={1,1,1,2,2,3};
        int[] largsest={};
        int k;
        HashMap <Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }

    }
}
