public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k) with dynamic programming
    public static long trinomial(int n, int k) {
        // Account for cases where k > n
        if (k > n) return 0;

        // 1. init a 2d array
        long[][] memo = new long[n + 1][2 * n + 1];
        memo[0][n] = 1; // T(0, 0) = 1

        // 2. for each array index, calculate the value based on the previous row values
        for (int i = 1; i <= n; i++) {
            for (int j = -n; j <= n; j++) {

                long left = 0;
                if (j - 1 + n >= 0) left = memo[i - 1][j - 1 + n];

                long center = 0;
                if (j + n >= 0) center = memo[i - 1][j + n];

                long right = 0;
                if (j + 1 + n < memo[0].length) right = memo[i - 1][j + 1 + n];

                memo[i][j + n] = left + center + right;
            }
        }
        return memo[n][k + n];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
