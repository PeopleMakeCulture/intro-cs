import java.util.Arrays;

public class ShannonEntropy {
    public static void main(String[] args) {
        //reads a sequence of integers between 1 and m from standard input
        // prints the Shannon entropy to standard output, with 4 digits after the decimal point

        int m = Integer.parseInt(args[0]);
        int[] occurance_counts = new int[m];
        int total_count = 0;

        // count occurances
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            occurance_counts[i - 1]++;
            total_count++;
        }
//        StdOut.println(Arrays.toString(occurance_counts));
//        StdOut.println("total count: " + total_count);


        // sum up factors

        double x_i;
        double p_i;
        double plogp_i;
        double H = 0;

        for (int i = 0; i < m; i++) {
            x_i = occurance_counts[i];
            p_i = x_i / total_count;
            if (p_i == 0) plogp_i = 0;
            else plogp_i = (p_i * Math.log(p_i) / Math.log(2));
            H -= plogp_i;

//            StdOut.printf("for i=%d, xi: %f, pi: %f, plogp: %f\n", i, x_i, p_i, plogp_i);
        }

        // print result sum
        System.out.println((String.format("%.4f", H)));
    }
}
