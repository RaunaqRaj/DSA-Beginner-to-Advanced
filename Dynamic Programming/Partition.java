import java.util.*;
public class Partition {
    public static int isSubsetSum(int arr[], int n, int sum, int[][] dp){
        if (sum == 0) {
            return 1;
        }
        if (n == 0 && sum != 0) {
            return 0;
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        if (arr[n - 1] > sum) {
            return isSubsetSum(arr, n-1, sum, dp);
        }
        if (isSubsetSum(arr, n-1, sum, dp) !=0 || isSubsetSum(arr, n-1, sum-arr[n-1], dp) != 0) {
            return dp[n][sum] = 1;
        }
        return dp[n][sum] = 0;
    }

    public static int findPartition(int arr[], int n){
        int sum = 0;
        for (int index = 0; index < n; index++) {
            sum += arr[index];
        }
        if (sum % 2 != 0) {
            return 0;
        }
        int dp[][] = new int[n+1][sum+1];
        for (int row[] : dp) {
            Arrays.fill(row,-1);
        }
        return isSubsetSum(arr, n, sum / 2, dp);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 5, 9, 12 };
        int n = arr.length;
 
        // Function call
        if (findPartition(arr, n) == 1)
            System.out.println(
                "Can be divided into two subsets of equal sum");
        else
            System.out.println(
                "Can not be divided into two subsets of equal sum");
 
        int arr2[] = { 3, 1, 5, 9, 14 };
        int n2 = arr2.length;
 
        if (findPartition(arr2, n2) == 1)
            System.out.println(
                "Can be divided into two subsets of equal sum");
        else
            System.out.println(
                "Can not be divided into two subsets of equal sum");
    }
}
