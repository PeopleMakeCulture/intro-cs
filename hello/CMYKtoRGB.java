public class CMYKtoRGB {
    public static void main(String[] args) {

        // converts from CMYK format to RGB format
        // takes four double arguments: cyan, magenta, yellow, and black

        double cyan = Double.parseDouble(args[0]), magenta = Double.parseDouble(args[1]),
                yellow = Double.parseDouble(args[2]), black = Double.parseDouble(args[3]);

        double white;
        int red, green, blue;

        white = 1.0 - black;
        red = Math.toIntExact(Math.round(255 * white * (1 - cyan)));
        green = Math.toIntExact(Math.round(255 * white * (1 - magenta)));
        blue = Math.toIntExact(Math.round(255 * white * (1 - yellow)));

        System.out.printf("red   = %d\n" +
                "green = %d\n" +
                "blue  = %d\n", red, green, blue);

    }
}
