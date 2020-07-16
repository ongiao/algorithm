/**
 * Created by chenjunxing ON 2020-05-03 16:20.
 */
public class _136_Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    public static void main (String[] args) {

    }
}
