/*An integer n is a Ramanujan number if can be expressed 
* as the sum of two positive cubes in two different ways. 
* That is, there are four distinct positive integers a, b, c, and d 
* such that n=a3+b3=c3+d3 
* Your program should take time proportional to n1/3 in the worst case
*/

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n){
        return true;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args){
        long n = Integer.parseLong(args[0]); 
        StdOut.println(isRamanujan(n));
    }
}