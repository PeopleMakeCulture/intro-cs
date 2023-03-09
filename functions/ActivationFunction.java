public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (x < 0) {
            return 0;
        } else if (x == 0) {
            return 0.5;
        } else {
            return 1;
        }
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        return 1 / 1 + Math.exp(-x);
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        return x;
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        return x;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        return x;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.printf("heaviside(%f) = %f\n", x, heaviside(x));

    }
}
