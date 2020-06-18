public class _137_Solution {
//    Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//
//    Note:
//
//    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//    Example 1:
//
//    Input: [2,2,3,2]
//    Output: 3
//    Example 2:
//
//    Input: [0,1,0,1,0,1,99]
//    Output: 99

    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }

            if (sum != 0) {
                ans |= sum << i;
            }
        }

        return ans;
    }
}
