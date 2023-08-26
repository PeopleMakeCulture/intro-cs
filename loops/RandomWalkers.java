public class RandomWalkers {

    public static void main(String[] args) {

        /*
         * takes two integer command-line arguments r and trials.
         * In each of trials independent experiments, simulate a random walk until the random walker is at Manhattan distance r from the starting point.
         * Print the average number of steps.
         * */

        int r = Integer.parseInt(args[0]), trials = Integer.parseInt(args[1]);

        int total_steps = 0;

        // for each trial
        for (int i = 0; i < trials; i++) {

            int manhattanDistance = 0;
            int x = 0, y = 0;
            int steps = 0;

            while (manhattanDistance < r) {

                int rand = (int) ((Math.random() * 4) + 1);

                if (rand == 1) {
                    x++;
                } else if (rand == 2) {
                    x--;
                } else if (rand == 3) {
                    y++;
                } else if (rand == 4) {
                    y--;
                }

                steps += 1;

                manhattanDistance = Math.abs(x) + Math.abs(y);
            }
            total_steps += steps;
        }

        System.out.println("average number of steps = " + (double) total_steps / trials);
    }
}
