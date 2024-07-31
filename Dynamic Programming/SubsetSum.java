import java.util.*;
import java.io.*;

public class SubsetSum { // creates a class called SubsetSum
    public static boolean isSubsetSum(int set[], int n, int sum) { // creates a method called isSubsetSum which takes
                                                                   // parameter a set array an integer n and an integer
                                                                   // sum
        if (sum == 0) { // if sum is equal to 0
            return true; // returns true
        }
        if (n == 0) { // if n is equal to 0
            return false; // returns false
        }
        if (set[n - 1] > sum) { // if set with index n-1 i greater than sum
            return isSubsetSum(set, n - 1, sum); // returns the value of the method isSubsetSum where n is equal to n-1
        }
        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]); // returns the logical or
                                                                                          // value between the value of
                                                                                          // isSubsetSum where n is
                                                                                          // equal to n-1 and
                                                                                          // isSubsetSum where n is
                                                                                          // equal to n-1 and sum is
                                                                                          // equal to sum - set[n-1]
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // creates a scanner object to take input
        System.out.print("Enter the size of array : "); // takes the input for the size of the array
        int n = sc.nextInt();
        int set[] = new int[n]; // initialises the set array with size n
        for (int i = 0; i < n; i++) { // for all i from 0 to n
            System.out.print("Enter the element " + i + " : "); // takes the input of array element
            set[i] = sc.nextInt();
        }
        System.out.print("Enter the sum to be checked : "); // takes the input for the sum to be checked
        int sum = sc.nextInt();
        if (isSubsetSum(set, n, sum) == true) { // if the value of isSubsetSum is true
            System.out.println("Found the subset with the given sum"); // prints this output
        } else {
            System.out.println("No such subset exists"); // else prints this output
        }
    }
}
