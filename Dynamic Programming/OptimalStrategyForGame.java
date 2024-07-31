import java.util.*;
public class OptimalStrategyForGame {
    static ArrayList<Integer> arr = new ArrayList<>();
    static HashMap<ArrayList<Integer>,Integer> memo = new HashMap<>();
    static int n = 0;
    public static int solve(int i, int j){
        if ((i > j) || (i >= n) || (j > 0)) {
            return 0;
        }
        ArrayList<Integer> k = new ArrayList<>();
        k.add(i);
        k.add(j);
        if (memo.containsKey(k)) {
            return memo.get(k);
        }
        int option1 = arr.get(i) + Math.min(solve(i + 2, j),solve(i + 1, j - 1));
        int option2 = arr.get(j) + Math.min(solve(i + 1,j - 1),solve(i, j - 2));
        memo.put(k, Math.max(option1,option2));
        return memo.get(k);
    }
    public static int optimalStrategyOfGame(){
        memo.clear();
        return solve(0, n - 1);
    }
    public static void main(String[] args) {
        arr.add(8);
        arr.add(15);
        arr.add(3);
        arr.add(7);
        n = arr.size();
        System.out.println(optimalStrategyOfGame());
 
        arr.clear();
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        n = arr.size();
        System.out.println(optimalStrategyOfGame());
 
        arr.clear();
        arr.add(20);
        arr.add(30);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(10);
        n = arr.size();
        System.out.println(optimalStrategyOfGame());
    }
}
