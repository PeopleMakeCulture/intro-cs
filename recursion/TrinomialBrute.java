// recursive approach
public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // base case:
        if (n == 0 && k == 0) return 1;
        else if (k < -n || k > n) return 0;
        // recursive case
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }

    // TODO: Implement recursion w/ memoization
//    static long[][] memo = new long[n][2 * (n - k)];
//
//    public static long trinomialMemo(int n, int k) {
//
//        StdOut.printf("n: %d, k%d \n", n, k);
//
//        // init all to -1
//        for (int i = 0; i < memo.length; i++) {
//            for (int j = 0; j < memo[i].length; j++) {
//                memo[i][j] = -1; // init all to -1
//            }
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = -k; j <= k; j++) {
//
//                if (memo[i][j] == -1) {
//
//                    // base case:
//                    if (i == 0 && j == 0) memo[i][j + k] = 1;
//                    else if (-i > j) memo[i][j + k] = 0;
//                    else if (i < j) memo[i][j + k] = 0;
//                    else {
//
//                    }
//                    long left = 0;
//                    if (i > 0 && j > 0) {
//                        left = trinomialMemo(i - 1, j - 1);
//                    }
//
//                    long center = 0;
//                    if (i > 0) {
//                        center = trinomialMemo(i - 1, j);
//                    }
//
//                    long right = 0;
//                    if (i > 0) {
//                        right = trinomialMemo(i - 1, j + 1);
//                    }
//
//                    memo[i][j] = left + center + right;
//                }
//
//            }
//        }
//        // subtract one to account for zero-indexing
//        return memo[n - 1][k - 1];
//    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
