import java.util.*;

public class ShortestCommonSupersequence {
    public static int shortestCommonSupersequence(String X, String Y, int n, int m, int[][] lookup) {
        if (m == 0 || n == 0) {
            lookup[n][m] = n + m;
        }
        if (lookup[n][m] == 0) {
            if (X.charAt(n - 1) == Y.charAt(m - 1)) {
                lookup[n][m] = shortestCommonSupersequence(X, Y, n - 1, m - 1, lookup) + 1;
            } else {
                lookup[n][m] = Math.min(shortestCommonSupersequence(X, Y, n - 1, m, lookup) + 1,
                        shortestCommonSupersequence(X, Y, n, m - 1, lookup) + 1);
            }
        }
        return lookup[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string : ");
        String X = sc.nextLine();
        System.out.print("Enter the second string : ");
        String Y = sc.nextLine();
        int n = X.length();
        int m = Y.length();
        int[][] lookup = new int[n + 1][m + 1];
        System.out.println("Shortest common supersequence : " + shortestCommonSupersequence(X, Y, n, m, lookup));
    }
}
