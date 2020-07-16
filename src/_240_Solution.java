/**
 * Created by chenjunxing ON 2020-03-16 00:01.
 */
public class _240_Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        boolean res = false;
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;

//        for (int row = 0; row < rowLen; row++) {
//            for (int column = columnLen - 1; column >= 0; column--) {
//                if (target > matrix[row][column]) {
//                    break;
//                }
//                else if (target < matrix[row][column]) {
//                    continue;
//                }
//                else {
//                    res = true;
//                }
//            }
//        }

        int row = 0;
        int col = columnLen - 1;
        while (row < rowLen && col >= 0) {
            if (target == matrix[row][col]) {
                res = true;
            }
            else if (target > matrix[row][col]) {
                row++;
            }
            else {
                col--;
            }
        }
        return res;
    }

    public static void main (String[] args) {

    }
}
