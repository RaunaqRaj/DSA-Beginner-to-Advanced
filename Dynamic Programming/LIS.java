import java.lang.*;
import java.util.*;

public class LIS { // creates a class called LIS
    public static int f(int idx, int prev_idx, int n, int a[], int dp[][]) { // creates a method called f which takes
                                                                             // the parameter idx , prev_idx, n, array,
                                                                             // dynamic array (2D)
        if (idx == n) { // if idx is equal to n
            return 0; // returns 0
        }
        if (dp[idx][prev_idx + 1] != -1) { // if dynamic array on indices idx and prev_idx + 1 is not equal to -1
            return dp[idx][prev_idx + 1]; // return dynamic array on indices id and prev_idx + 1
        }
        int notTake = 0 + f(idx + 1, prev_idx, n, a, dp); // initilaise not Take as 0 + value of f method where idx is
                                                          // now equal to idx+1
        int take = Integer.MIN_VALUE; // initialise take as Integer's maxvalue which is equal to 0
        if (prev_idx == -1 || a[idx] > a[prev_idx]) { // if prev_idx is equal to -1 or array[idx] is greater than
                                                      // array[prev_idx]
            take = 1 + f(idx + 1, idx, n, a, dp); // initilaise take as 1 + value of f where idx is equal to idx + 1 and
                                                  // prev_idx is equal to idx
        }
        return dp[idx][prev_idx + 1] = Math.max(take, notTake); // initialise and return dynamic array[idx][prev_idx +
                                                                // 1] as the maximum value between take and not take
    }

    public static int lis(int arr[], int n) { // creates the method called lis which takes the parameter an array and an
                                              // integer called n
        int dp[][] = new int[n + 1][n + 1]; // initialise dp as a new integer array
        for (int row[] : dp) { // for each row in dp array
            Arrays.fill(row, -1); // fill rows with value -1
        }
        return f(0, -1, n, arr, dp); // returns the value of f where idx = 0 and prev_idx = -1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creates and object of the scanner class to take input from user
        System.out.print("Enter the size of the array : "); // takes the input for the size of the array
        int n = sc.nextInt();
        int a[] = new int[n]; // initialise the array with size n
        for (int i = 0; i < n; i++) { // for all i from 0 to n
            System.out.print("Enter the element " + i + " : "); // take the input of each element of the array
            a[i] = sc.nextInt();
        }
        System.out.println("Longest incresing subsequence : " + lis(a, n)); // prints the answer
    }
}
