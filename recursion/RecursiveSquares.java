public class RecursiveSquares {


    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double halfLen){
    	
    	StdDraw.setPenColor(StdDraw.BLACK);  // black 
    	StdDraw.square(x, y, halfLen);  // border
    	
    	StdDraw.setPenColor(StdDraw.LIGHT_GRAY);  // light gray 
    	StdDraw.filledSquare(x, y, halfLen);  // background
    }


    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double len){

    	double halfLen = 0.5 * len;
    	drawSquare (x, y, halfLen);

    	// base case
    	if (n == 1) return;	

    	// recursively draw 4 more squares
    	draw(n - 1, x + halfLen, y + halfLen, halfLen);
    	draw(n - 1, x + halfLen, y - halfLen, halfLen);
    	draw(n - 1, x - halfLen, y + halfLen, halfLen);
    	draw(n - 1, x - halfLen, y - halfLen, halfLen);
    }

    // Takes an integer command-line argument n and draws a recursive square 
    // pattern of order n, centered on (0.5, 0.5), with side length 0.5.
    public static void main(String[] args){

    	int n = Integer.parseInt(args[0]);
    	draw(n, 0.5, 0.5, 0.5);

    }
}