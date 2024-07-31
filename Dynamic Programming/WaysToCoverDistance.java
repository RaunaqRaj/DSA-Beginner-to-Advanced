import java.util.*;

public class WaysToCoverDistance { // creates a class named WaysToCoverDistance
    public static int countWays(int dist) { // creates a method called countWays which takes parameter distance
        int[] memo = new int[dist + 1]; // initialises an array called memo of size distance + 1
        Arrays.fill(memo, -1); // fills the array memo with value -1
        return printCountRecMemo(dist, memo); // returns the value of method printCountRecMemo which takes parameter
                                              // distance and memo
    }

    public static int printCountRecMemo(int dist, int[] memo) { // creates a method called printCountRecMemo which takes
                                                                // parameter distance and an array memo
        if (dist < 0) { // if distance is less than 0
            return 0; // returns 0
        }
        if (dist == 0) { // if distance is equal to 0
            return 1; // returns 1
        }
        if (memo[dist] != -1) { // if memo array with index distance is not equal to -1
            return memo[dist]; // return memo array with index as distance
        }
        int ways = printCountRecMemo(dist - 1, memo) + printCountRecMemo(dist - 2, memo)
                + printCountRecMemo(dist - 3, memo); // initialises ways variable as sumation of printCountRecMemo with
                                                     // parameter distance as distance - 1 , distance - 2 and distance -
                                                     // 3
        memo[dist] = ways; // initialises memo array with index distance as ways
        return ways; // returns ways
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creates a scanner object to take input
        System.out.print("Enter the distance to cover : "); // takes he distance value from user's input
        int dist = sc.nextInt();
        System.out.println("The ways to cover distance : " + countWays(dist)); // prints the output
    }
}
