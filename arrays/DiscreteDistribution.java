public class DiscreteDistribution {
    public static void main(String[] args) {

        // takes an integer command-line argument m,
        // followed by a sequence of positive integer command-line arguments a1,a2,…,an, and
        // prints m random indices (separated by whitespace),
        // choosing each index i with probability proportional to ai.

        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;

        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
        }

        // 1. Define the cumulative sums Si=a1+a2+…+ai, with S0=0
        int[] S = new int[n];
        int cumulativeSum = 0;
        for (int i = 0; i < S.length; i++) {
            cumulativeSum += a[i];
            S[i] = cumulativeSum;
        }

        for (int j = 0; j < m; j++) {

            // 2. Pick a random integer r uniformly between 0 and Sn−1
            int r = (int) (Math.random() * S[n - 1]);

            // 3. Find the unique index i between 1 and n such that Si−1≤r<Si
            int uniq_idx_i = 0;

            while (S[uniq_idx_i] <= r) {
                uniq_idx_i++;
            }

            System.out.print(uniq_idx_i + 1 + " ");

        }
        System.out.print("\n");
    }


}
