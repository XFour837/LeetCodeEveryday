/**
 * Create with LeetCode
 * User: XFour
 * Date: 2020/4/7
 * Time: 17:57
 * Description:
 */
class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2 - 1; j++) {
                swap(matrix, i, j, i, matrix[0].length - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int m, int k) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[m][k];
        matrix[m][k] = tmp;
    }

}
