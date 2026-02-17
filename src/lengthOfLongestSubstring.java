import java.util.HashSet;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s= "abcabcbb";
        int left = 0, right = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        System.out.print(maxLen);
    }
}
