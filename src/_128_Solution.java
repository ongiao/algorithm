import java.util.HashSet;
import java.util.Set;

public class _128_Solution {
//    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//    Your algorithm should run in O(n) complexity.
//
//    Example:
//
//    Input: [100, 4, 200, 1, 3, 2]
//    Output: 4
//    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            set.add(n);
        }
        int max = 1;
        for (int i = 0; i < num.length; i++) {
            if (set.remove(num[i])) {
                int sum = 1;
                int val = num[i];
                int val_small = val - 1;
                int val_big = val + 1;
                while (set.remove(val_big)) {
                    sum++;
                    val_big++;
                }
                while (set.remove(val_small)) {
                    sum++;
                    val_small--;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
