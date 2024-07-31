import java.util.*;

public class EditDistance { // creates class named EditDistance
    public static int minDist(String s1, String s2, int n, int m, int dp[][]) { // creates a method called minDist which
                                                                                // takes the parameters string 1 ,
                                                                                // string 2 , n , m , dynamic array
        if (m == 0) { // if m is equal to 0
            return n; // returns n
        }
        if (n == 0) { // if n is equal to 0
            return m; // returns m
        }
        if (dp[n][m] != -1) { // if dynamic array over indices n and m is not equal to -1
            return dp[n][m]; // returns dynamic array over indices n and m
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) { // if character at n-1 in string 1 is equal to character at m-1 in
                                                    // string 2
            return dp[n][m] = minDist(s1, s2, n - 1, m - 1, dp); // initialise and return dynamic array over indices as
                                                                 // the value of minDist where n = n-1 and m = m-1
        } else {
            int insert, replace, delete; // initialise insert, delete, replace variables
            insert = minDist(s1, s2, n, m - 1, dp); // initialise the value of insert as the value of minDist where m =
                                                    // m-1 and everything else unchanged
            delete = minDist(s1, s2, n - 1, m, dp); // initialise the value of delete as the value of minDist where n =
                                                    // n-1 and everything else unchanged
            replace = minDist(s1, s2, n - 1, m - 1, dp); // initialise the value of replace as the value of minDist
                                                         // where m = m-1 and n = n-1 and everything else unchanged
            return dp[n][m] = 1 + Math.min(insert, Math.min(delete, replace)); // initialise and return the 1+minimum
                                                                               // value between insert, delete and
                                                                               // replace
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creates a scanner object for taking input
        System.out.print("Enter the first string : "); // takes input for 1st string
        String str1 = sc.nextLine();
        System.out.print("Enter the second string : "); // takes input for 2nd string
        String str2 = sc.nextLine();
        int n = str1.length(); // initialise the value of n equal to length of string 1
        int m = str2.length(); // initialise the value of m equal to length of string 2
        int dp[][] = new int[n + 1][m + 1]; // initialise dynamic array to size n+1 and m+1
        for (int i = 0; i < n + 1; i++) { // for all i from 0 to n
            Arrays.fill(dp[i], -1); // fill dynamic array with value -1
        }
        System.out.println("Minimum distance : " + minDist(str1, str2, n, m, dp)); // Prints the output
    }
}
