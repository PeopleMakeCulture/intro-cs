public class Birthday {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]),
                trials = Integer.parseInt(args[1]);

        int[] counts = new int[n]; // n = num choices n = 5 (0, 1, 2, 3, 4)

        // counts = [0,0,0,0,0]
        // room = [f,f,f,f,f]
        // count = 0

        // for each trial
        for (int t = 0; t < trials; t++) {

            // run experiment
		// TODO: Fix random distribution
            boolean[] room = new boolean[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                int birthday = (int) (Math.random() * n);
                if (room[birthday] == true) {
                    count = i;
                    break;
                } else {
                    room[birthday] = true;
                }
            }

            counts[count]++;
        }

        // print out result
        int i = 0;
        int i_count;
        int sum_count = 0;
        double fraction = 0.0;

        while (fraction < 0.5) {
            i_count = counts[i];
            sum_count += counts[i];
            fraction = (double) sum_count / trials;

            System.out.printf("%d\t%d\t%f\n", i + 1, i_count, fraction);

            i++;
        }

    }
}
