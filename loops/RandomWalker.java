public class RandomWalker {
    public static void main(String[] args) {

        // takes an integer command-line argument r 
        // simulates the motion of a random walk
        // until walker is at Manhattan distance r from the starting point

        int r = Integer.parseInt(args[0]);
        int manhattanDistance = 0;
        int x = 0, y = 0;
        int steps = 0;

        System.out.printf("(%d, %d)\n", x, y);
        
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

            System.out.printf("(%d, %d)\n", x, y);

            manhattanDistance = Math.abs(x) + Math.abs(y);

        }
        System.out.println("steps = " + steps);

    }
}
