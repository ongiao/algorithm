import com.sun.tools.javadoc.Start;

/**
 * Created by chenjunxing ON 2020-05-03 16:18.
 */
public class _134_Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];

            if (sum < 0) {
                total += sum;
                sum = 0;
                startIndex = i + 1;
            }
        }

        total += sum;

        return total < 0 ? - 1: startIndex;
    }

    public static void main (String[] args) {

    }
}
