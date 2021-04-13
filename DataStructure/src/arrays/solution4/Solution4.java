package arrays.solution4;

/**
 * @author Ozzy Yang
 * Finished Time:2021-04-12
 */
public class Solution4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //判断边界值，保证行、列都有元素
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int maxIndexI = 0, maxIndexJ = 0, minIndexI = 0, minIndexJ = 0;
        //对第一行和第一列遍历，确定target所在的行数、列数的最大范围
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) return true;//找到则直接返回true
            if (matrix[i][0] > target) {
                maxIndexI = i - 1;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == target) return true;//找到则直接返回true
            if (matrix[0][j] > target) {
                maxIndexJ = j - 1;
                break;
            }
        }
        //如果只有一行或者一列，遍历完还没有找到则说明根本没有
        if (matrix.length < 2 || matrix[0].length < 2) return false;
        //如果列数、行数都在2以上，则在缩小的范围内进行暴力查找
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}
