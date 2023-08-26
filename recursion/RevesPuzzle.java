public class RevesPuzzle {

    public static int getK(int n) {
        return n + 1 - (int)(Math.sqrt(2 * n + 1));
    }

        // if (n == 0) return "/n";
        // String move;
        // if (left) move = n + "L";
        // else move = n + "R";
        // return hanoi(n - 1, !left) + move + hanoi(n - 1, !left);

    public static String hanoi(int n, char start, char dest, char spare) {
        String move = "";
        if (n == 1) {
            move = "Move disc " + n + " from " + start + " to " + dest;
        }
        return move;
        
    }

    public static String reves(int n) {

        char[] poles = new char[]{'A', 'B', 'C', 'D'};
        // base case:
        // if (n == 0) return "\n";

        // recursive case
        char start = poles[0];
        char dest = poles[3];
        char spare = poles[2];

        // int k = (int) Math.round(n + 1 - (Math.sqrt(2 * n + 1)));

        // recursively transfer k smallest discs to single pole other than start or dest poles

        // recursively transfer remaining n-k disks to destination pole, without using the pole used above, using hanoi
        String move = hanoi(n, start, dest, spare);
        
        // recursively transfer k smallest discs to destination pole


        return move;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // StdOut.println(getK(n));
        StdOut.println(reves(n));
    }

}


