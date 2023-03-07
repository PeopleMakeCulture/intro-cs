public class GreatCircle {
    public static void main(String[] args) {
        // takes four double command-line arguments x1, y1, x2, and y2
        // prints the great-circle distance (in kilometers) between them
        // use the Haversine formula


        double x1 = Double.parseDouble(args[0]), y1 = Double.parseDouble(args[1]),
                x2 = Double.parseDouble(args[2]), y2 = Double.parseDouble(args[3]);

        double r = 6371.0;


        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);

        double x_d = (x2 - x1) / 2;
        double y_d = (y2 - y1) / 2;

        double left = Math.pow(Math.sin(x_d), 2);
        double right = Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin(y_d), 2);

        double distance = 2 * r * Math.asin(Math.sqrt(left + right));

        System.out.println(distance + " kilometers");
    }
}
