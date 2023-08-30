import java.util.Arrays;

// What is this `implements` Comparable interface?
// https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
// To sort an array of objects, use Java’s Arrays.sort()

public class Bar implements Comparable<Bar> {

    private final String name;
    private final int value;
    private final String category;

    // Creates a new bar.
    public Bar(String name, int value, String category){
    // Throw an IllegalArgumentException in the constructor if name is null, value is negative, or category is null. 
        if (name == null) throw new IllegalArgumentException("name is null");
        if (value < 0) throw new IllegalArgumentException("value is negative");
        if (category == null) throw new IllegalArgumentException("category is null");

        this.name = name;
        this.value = value;
        this.category = category;

    }
    public String toString(){
        return "name: " + this.name + " value: " + this.value + " category: " + this.category + "\n";
    }
    // Returns the name of this bar.
    public String getName(){
        return this.name;
    }

    // Returns the value of this bar.
    public int getValue(){
        return this.value;
    }

    // Returns the category of this bar.
    public String getCategory(){
        return this.category;
    }

    // Compare two bars by value.
    // Include a method compareTo() to specify how to compare two Bar objects. 
    // In this case, return a { negative integer, zero, positive integer } if value of the 
    // invoking object is { less than, equal to, greater than } the value of the argument object. 
    public int compareTo(Bar that){
    //Throw a NullPointerException if the argument to compareTo() is null. 
        if (that == null) {
            throw new NullPointerException("compareTo() takes a Bar object as an argument. None given.");
        }
        if (this.value < that.value) {
            return -1;
        } else if (this.value > that.value){   
            return 1;
        } else {
            return 0;
        }
    }
    // Sample client (see below).

    public static void main(String[] args){
        // create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing",     22674, "East Asia");
        bars[1] = new Bar("Cairo",       19850, "Middle East");
        bars[2] = new Bar("Delhi",       27890, "South Asia");
        bars[3] = new Bar("Dhaka",       19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai",      22120, "South Asia");
        bars[6] = new Bar("Osaka",       20409, "East Asia");
        bars[7] = new Bar("São Paulo",   21698, "Latin America");
        bars[8] = new Bar("Shanghai",    25779, "East Asia");
        bars[9] = new Bar("Tokyo",       38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
        
        for (int i=0; i<10; i++){
            StdOut.println(bars[i]);
        }

    }

}