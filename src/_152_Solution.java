/**
 * Created by chenjunxing ON 2020-07-15 01:34.
 */
public class _152_Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        for (int i = 1, temMax = result, temMin = result; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = temMax;
                temMax = temMin;
                temMin = temp;
            }

            temMax = Math.max(nums[i], nums[i] * temMax);
            temMin = Math.min(nums[i], nums[i] * temMin);

            result = Math.max(result, temMax);
        }

        return result;
    }
}
