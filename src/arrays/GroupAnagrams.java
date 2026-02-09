package arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        System.out.println(new ArrayList<>(map.values()));
    }
}
