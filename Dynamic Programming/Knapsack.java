import java.util.*;

public class Knapsack {
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    public static int knapsackRec(int W, int wt[], int val[], int n, int dp[][]){
        if(n == 0 || W == 0){
            return 0;
        }
        if(dp[n][W] != 0){
            return dp[n][W];
        }
        if(wt[n - 1] > W){
            return dp[n][W] = knapsackRec(W, wt, val, n-1, dp);
        }
        else{
            return dp[n][W] = max((val[n - 1] + knapsackRec(W - wt[n - 1], wt, val, n - 1, dp)),knapsackRec(W, wt, val, n - 1, dp));
        }
    }
    public static int knapSack(int W, int wt[], int val[], int N){
        int dp[][] = new int[N+1][W+1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < W; j++){
                dp[i][j] = -1;
            }
        }
        return knapsackRec(W, wt, val, N, dp);
    }
    public static void main(String args[]){
        int profit[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        int N = profit.length;
        System.out.println(knapSack(W, weight, profit, N));
    }
}
