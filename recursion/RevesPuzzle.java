public class RevesPuzzle {

    private static String hanoi(int k, int n, char start, char dest, char spare) {
        
        // base case
        if (k == n) return ("Move disc " + n + " from " + start + " to " + dest + "\n");
        
        // recursive
        return hanoi(k, n-1, start, spare, dest) + ("Move disc " + n + " from " + start + " to " + dest + "\n") + hanoi(k, n-1, spare, dest, start);        
    }

    private static String reves(int n, char start, char dest, char spare1, char spare2) {

        int k = (int) Math.round(n + 1 - (Math.sqrt(2 * n + 1)));
        
        // base case
        if (n == 1) return ("Move disc " + n + " from " + start + " to " + dest + "\n");

        // recursive
        return reves(k, start, spare1, spare2, dest) + hanoi(k+1, n, start, dest, spare2) + reves(k, spare1, dest, spare2, start);

    }


    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        StdOut.println(reves(n, 'A', 'D', 'B', 'C'));

    }

}


