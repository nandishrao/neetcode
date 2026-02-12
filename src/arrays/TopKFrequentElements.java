package arrays;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3,4};
        int k = 2;
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int num : nums) {
            h.put(num, h.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> h.get(a) - h.get(b));
        for (int key : h.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll(); // remove least frequent
            }
        }
        int[] largest = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            largest[i++] = pq.poll();
        }
        System.out.println(Arrays.toString(largest));
    }
}
