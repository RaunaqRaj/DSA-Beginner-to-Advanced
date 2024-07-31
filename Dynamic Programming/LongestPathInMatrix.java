
/**
 * LongestPathInMatrix
 */
import java.util.*;

public class LongestPathInMatrix {
    public static int n = 3;

    public static int findLongestPathFromACell(int i, int j, int matrix[][], int dp[][]) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, w = Integer.MIN_VALUE, z = Integer.MIN_VALUE;
        if (j < n - 1 && ((matrix[i][j] + 1) == matrix[i][j + 1])) {
            x = dp[i][j] = 1 + findLongestPathFromACell(i, j + 1, matrix, dp);
        }
        if (j > 0 && (matrix[i][j] + 1 == matrix[i][j - 1])) {
            y = dp[i][j] = 1 + findLongestPathFromACell(i, j - 1, matrix, dp);
        }
        if (i > 0 && (matrix[i][j] + 1 == matrix[i - 1][j])) {
            w = dp[i][j] = 1 + findLongestPathFromACell(i - 1, j, matrix, dp);
        }
        if (i < n - 1 && (matrix[i][j] + 1 == matrix[i + 1][j])) {
            z = dp[i][j] = 1 + findLongestPathFromACell(i + 1, j, matrix, dp);
        }
        return dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1))));
    }

    public static int findLongestOverAll(int matrix[][]){
        int result = 1;
        int [][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    findLongestPathFromACell(i, j, matrix, dp);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Length of the longest path : " + findLongestOverAll(matrix));
    }
}