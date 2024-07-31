import java.util.*;
import java.io.*;

public class MinimumPartition { // creates a class Minimum Partition
    public static int findSum(int arr[], int n) { // Creates a method called find sum which takes parametrs an array and
                                                  // an integer n
        int sum = 0; // initilise the variable sum as 0
        for (int index = 0; index < n; index++) { // for all index from 0 to n
            sum += arr[index]; // initialise sum as sum + arr[index]
        }
        boolean dp[][] = new boolean[n + 1][sum + 1]; // initialise a dynamic array of boolean datatype with size n + 1
                                                      // and sum + 1
        for (int i = 0; i <= n; i++) { // for all i from 0 to n
            dp[i][0] = true; // initialise the dynamic array over indices i and 0 as true
        }
        for (int i = 1; i <= sum; i++) { // for all i from 0 to sum
            dp[0][i] = false; // initialise the dynamic array over indices 0 and i as false
        }
        for (int i = 1; i <= n; i++) { // for all i to n
            for (int j = 1; j <= sum; j++) { // for all j to sum
                dp[i][j] = dp[i - 1][j]; // initialise dynamic array over indices i and j as dynamic array of indices
                                         // i-1 and j
                if (arr[i - 1] <= j) { // if array of index i-1 is less than or equal to j
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]]; // initialise dynamic array over indices i and j as dynamic
                                                           // array of indices i - 1 an j - arr[i-1]
                }
            }
        }
        int difference = Integer.MAX_VALUE; // initialise difference variable as integers's max value
        for (int j = sum / 2; j >= 0; j--) { // for all j from sum / 2 to 0
            if (dp[n][j] == true) { // if dynamic array over indices n and j is equal to true
                difference = sum - 2 * j; // initialise difference as sum - 2 * j
                break; // break the loop
            }
        }
        return difference; // return the value of difference
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creates a scannerr object for input
        System.out.print("Enter the size of array : "); // takes input for the size of the array
        int n = sc.nextInt();
        int arr[] = new int[n]; // initialises the array of size n
        for (int i = 0; i < n; i++) { // for all i from 0 to n
            System.out.print("Enter the element " + i + " : "); // take input for the element
            arr[i] = sc.nextInt();
        }
        System.out.println("The difference between two sets is : " + findSum(arr, n)); // print the output
    }
}
