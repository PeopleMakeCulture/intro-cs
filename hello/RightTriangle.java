public class RightTriangle {
    // takes three int command-line arguments
    // determines whether they constitute the side lengths of some right triangle
    // each int must be positive

    public static void main(String[] args) {

        try {

            int a = Integer.parseInt(args[0]), b = Integer.parseInt(args[1]), c = Integer.parseInt(args[2]);

            System.out.println(
                    a > 0 && b > 0 && c > 0 && (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) ||
                            (a * a) + (c * c) == (b * b) ||
                            (c * c) + (b * b) == (a * a)
                    ));
            
        } catch (NumberFormatException e) {
            System.err.println("all inputs must be integers");
        }
    }
}
