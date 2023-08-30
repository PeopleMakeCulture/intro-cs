// What is this `implements` Comparable interface?
// https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
// To sort an array of objects, use Java’s Arrays.sort()

public class Bar implements Comparable<Bar> {

    // Creates a new bar.
    public Bar(String name, int value, String category)
    // Throw an IllegalArgumentException in the constructor if name is null, value is negative, or category is null. 

    // Returns the name of this bar.
    public String getName()

    // Returns the value of this bar.
    public int getValue()

    // Returns the category of this bar.
    public String getCategory()

    // Compare two bars by value.
    // Include a method compareTo() to specify how to compare two Bar objects. 
    // In this case, return a { negative integer, zero, positive integer } if value of the 
    // invoking object is { less than, equal to, greater than } the value of the argument object. 
    public int compareTo(Bar that)
    //Throw a NullPointerException if the argument to compareTo() is null. 
    // Sample client (see below).

    public static void main(String[] args)

}