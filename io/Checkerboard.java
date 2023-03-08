public class Checkerboard {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);

        // draw each of n**2 squares and
        // color squares blue and light grey
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // if i  j are both even or both odd, color=blue, else color=grey
                if (((i + j) % 2) == 0) StdDraw.setPenColor(StdDraw.BLUE);
                else StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
