import java.util.ArrayList;
import java.util.List;

public class _131_Solution {
//    Given a string s, partition s such that every substring of the partition is a palindrome.
//
//    Return all possible palindrome partitioning of s.
//
//            Example:
//
//    Input: "aab"
//    Output:
//            [
//            ["aa","b"],
//            ["a","a","b"]
//            ]

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        if (s.length() == 0) return res;

        helper(res, new ArrayList<String>(), s, 0);

        return res;
    }

    public void helper(List<List<String>> res, ArrayList<String> cur, String s, int low) {
        if (low == s.length()) {
            res.add(new ArrayList<String>(cur));
            return;
        }

        for (int high = low; high < s.length(); high++) {
            if (isPal(s, low, high)) {
                cur.add(s.substring(low, high + 1));
                helper(res, cur, s, high + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPal(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
}
