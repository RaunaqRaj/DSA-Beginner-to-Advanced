/**
 * LongestPathInMatrix
 */
import java.util.*;

public class LongestPathInMatrix { // creates a class called LongestPathInMatrix
    public static int n = 3; // initialises the value of dimension of the matrix

    public static int findLongestPathFromACell(int i, int j, int matrix[][], int dp[][]) { // creates the method called
                                                                                           // findLongestPathFromACell
                                                                                           // which takes the parameter
                                                                                           // i , j , matrix , dynamic
                                                                                           // array
        if (i < 0 || i >= n || j < 0 || j >= n) { // i is less than 0 or i is greater than or equeal to n or j is less
                                                  // than 0 or j is greater than or equal to n
            return 0; // return 0
        }
        if (dp[i][j] != -1) { // if dynamic array over indices i and j is not equal to -1
            return dp[i][j]; // returns dynamic array of indices i and j
        }
        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, w = Integer.MIN_VALUE, z = Integer.MIN_VALUE; // initialises x
                                                                                                        // , y ,w ,z as
                                                                                                        // the minimum
                                                                                                        // value of
                                                                                                        // integer
        if (j < n - 1 && ((matrix[i][j] + 1) == matrix[i][j + 1])) { // if j is less than n - 1 and matrix over indices
                                                                     // (i and j ) + 1 is equal to matrix over indices i
                                                                     // and j+1
            x = dp[i][j] = 1 + findLongestPathFromACell(i, j + 1, matrix, dp); // initialises x as 1 + value of
                                                                               // findLongestPathFromACell where j is
                                                                               // equal to j + 1
        }
        if (j > 0 && (matrix[i][j] + 1 == matrix[i][j - 1])) { // if j is greater than 0 and matrix over indices (i and
                                                               // j ) + 1 is equal to matrix over indices i and j - 1
            y = dp[i][j] = 1 + findLongestPathFromACell(i, j - 1, matrix, dp); // initialises y as 1 + value of
                                                                               // findLongestPathFromACell where j is
                                                                               // equal to j - 1
        }
        if (i > 0 && (matrix[i][j] + 1 == matrix[i - 1][j])) { // if i is greater than 0 and matrix over indices (i and
                                                               // j ) + 1 is equal to matrix over indices i-1 and j
            w = dp[i][j] = 1 + findLongestPathFromACell(i - 1, j, matrix, dp); // initialises w as 1 + value of
                                                                               // findLongestPathFromACell where i is
                                                                               // equal to i - 1
        }
        if (i < n - 1 && (matrix[i][j] + 1 == matrix[i + 1][j])) { // if i is less than n-1 and matrix over indices (i
                                                                   // and j ) + 1 is equal to matrix over indices i+1
                                                                   // and j
            z = dp[i][j] = 1 + findLongestPathFromACell(i + 1, j, matrix, dp); // initialises z as 1 + value of
                                                                               // findLongestPathFromACell where i is
                                                                               // equal to i + 1
        }
        return dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1)))); // returns dp[i][j] as maximum between
                                                                                 // x and max value of y and max value
                                                                                 // of z and max value of w and 1
    }

    public static int findLongestOverAll(int matrix[][]) { // creates a method findLongestOverAll which takes a
                                                           // parameter matrix array
        int result = 1; // initialises result variable as 1
        int[][] dp = new int[n][n]; // initialises dynamic array of size n
        for (int i = 0; i < n; i++) { // for all i from 0 to n
            for (int j = 0; j < n; j++) { // for all j from 0 to n
                dp[i][j] = -1; // initialise dynamic array over indices i and j as -1
            }
        }
        for (int i = 0; i < n; i++) { // for all i from 0 to n
            for (int j = 0; j < n; j++) { // for all j from 0 to n
                if (dp[i][j] == -1) { // if dynamic array over indices i and j i equal to -1
                    findLongestPathFromACell(i, j, matrix, dp); // call method findLongestPathFromACell
                }
                result = Math.max(result, dp[i][j]); // initialise result as maximum value between result and dynamic
                                                     // array over indices i and j
            }
        }
        return result; // returns result
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creates a scanner object for taking input
        int matrix[][] = new int[n][n]; // initialises a matrix of size n
        for (int i = 0; i < n; i++) { // for all i from 0 to n
            for (int j = 0; j < n; j++) { // for all j from 0 to n
                matrix[i][j] = sc.nextInt(); // takes input of the array
            }
        }
        System.out.println("Length of the longest path : " + findLongestOverAll(matrix)); // prints the output
    }
}