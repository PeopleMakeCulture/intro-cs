public class ColorHSB {

    private final int h;
    private final int s;
    private final int b;

    // Creates a color with hue h, saturation s, and brightness b.
    // NOTE: in Java, the constructor is a public function of same name as class
    // The constructor's signature is different from other methods in the class
    public ColorHSB(int hue, int saturation, int brightness){

        // Throw an IllegalArgumentException if any component is outside its prescribed range 
        if(hue < 0 || hue > 359) throw new IllegalArgumentException("Hue must be between 0 to 359.");
        if(saturation < 0 || saturation > 100) throw new IllegalArgumentException("Saturation must be between 0 to 100.");
        if(brightness < 0 || brightness > 100) throw new IllegalArgumentException("Brightness must be between 0 to 100.");        

        h = hue;
        s = saturation;
        b = brightness;
    }

    // Returns a string representation of this color, eg: "(26, 85, 96)" 
    public String toString(){
        return String.format("(%d, %d, %d)", h, s, b);
    }

    // Is this color a shade of gray?
    public boolean isGrayscale(){
        return s == 0 || b == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {

        // Throw an IllegalArgumentException if its argument is null. 
        if (that == null) throw new IllegalArgumentException("DistanceSquaredTo() argument cannot be null.");

        int distanceSquared = (int) Math.round(Math.min(Math.pow(this.h - that.h, 2), Math.pow(360 - Math.abs(this.h - that.h), 2)) + 
        Math.pow(this.s - that.s, 2) + Math.pow(this.b - that.b, 2));

        return distanceSquared;



    // Takes three integer command-line arguments h, s, and b; 
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        
        ColorHSB thisColor = new ColorHSB(h, s, b);

        int currentMinDistance = Integer.MAX_VALUE;
        String returnString = ""; 

        // Reads a list of pre-defined colors from standard input; 
        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            
            int thatH = StdIn.readInt();
            int thatS = StdIn.readInt();
            int thatB = StdIn.readInt();

            ColorHSB thatColor = new ColorHSB(thatH, thatS, thatB);

            int distanceTo = thatColor.distanceSquaredTo(thisColor);
            if (distanceTo < currentMinDistance){
                returnString = colorName + " " + thatColor.toString();
                currentMinDistance = distanceTo;
            } 
        }

        // Prints to standard output the pre-defined color that is closest to (h,s,b). 
        StdOut.println(returnString);
    }

}
