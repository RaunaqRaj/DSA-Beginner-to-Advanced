import java.util.*;
import java.io.*;

public class LCS { // Creates a class called Longest common subsequence
    public static int lcs(String X, String Y, int m, int n, int[][] dp) { // creates a method called LCS with parameter
                                                                          // of 2 strings two integers and an array
        if (m == 0 || n == 0) { // if m and n is equal to 0
            return 0; // returns 0
        }
        if (dp[m][n] != -1) { // if value of the array over indices m and n is not equal to -1
            return dp[m][n]; // return the array value over indices m and n
        }
        if (X.charAt(m - 1) == Y.charAt(n - 1)) { // if String 1 character at index m - 1 is equal to String 2 character
                                                  // at index n - 1
            dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp); // initialise array on indices m and n to 1 + value of lcs
                                                        // method where value of m = m-1 and n = n-1
            return dp[m][n]; // return the array on indices m and n
        }
        dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp), lcs(X, Y, m - 1, n, dp)); // initialise dp on indices m and n to
                                                                               // maximum value from value of lcs where
                                                                               // n = n-1 and value of lcs where m = m-1
        return dp[m][n]; // returns the value of the array over m and n indices
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creates a scanner object to take input
        System.out.print("Enter the first string : "); // takes the input of 1st string
        String X = sc.nextLine();
        System.out.print("Enter the second string : ");// takes the input of 2nd string
        String Y = sc.nextLine();
        int m = X.length(); // initialise m = the length of the 1st string
        int n = Y.length(); // initialise n = the length of the 2nd string
        int dp[][] = new int[m + 1][n + 1]; // initialise the array with size of m+1 and n+1
        for (int i = 0; i < m + 1; i++) { // for all i from 0 to m+1
            for (int j = 0; j < n + 1; j++) { // for all j from 0 to n+1
                dp[i][j] = -1; // initialise the array on indices i and j as -1
            }
        }
        System.out.println("Longest Common Subsequence : " + lcs(X, Y, m, n, dp)); // prints the answer
    }
}