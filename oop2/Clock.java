import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Clock {

    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_DAY = MINUTES_PER_HOUR * HOURS_PER_DAY;
    
    private int m;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int hours, int minutes){
        // Throw an IllegalArgumentException if either integer argument is outside its prescribed bounds 
        if (hours < 0 || hours >= HOURS_PER_DAY) throw new IllegalArgumentException("Hours must be between 0 to 23");
        if (minutes < 0 || minutes >= MINUTES_PER_HOUR) throw new IllegalArgumentException("Minutes must be between 0 to 59");
        
        // convert to minutes
        m = (hours * MINUTES_PER_HOUR) + minutes; 
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    // The string argument is composed of two digits, followed by a colon, followed by two digits (Eg 09:45) 
    // Throw an IllegalArgumentException if either the string argument is not in this format 
    // or if it does not correspond to a valid time between 00:00 and 23:59
    public Clock(String s){

        String regexPattern = "^(\\d{2}):(\\d{2})$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(s);
        
        int hours; 
        int minutes; 

        if (matcher.matches()) {
            hours = Integer.parseInt(matcher.group(1));
            minutes = Integer.parseInt(matcher.group(2));
            // this.Clock(hours, minutes);
        } else throw new IllegalArgumentException("Not a valid time between 00:00 and 23:59");


        if (hours < 0 || hours >= HOURS_PER_DAY) throw new IllegalArgumentException("Hours must be between 0 to 23");
        if (minutes < 0 || minutes >= MINUTES_PER_HOUR) throw new IllegalArgumentException("Minutes must be between 0 to 59");
        
        // convert to minutes
        m = (hours * MINUTES_PER_HOUR) + minutes; 
        // StdOut.printf("minutes in clock: %d\n", m);
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString(){

        int hours = m / MINUTES_PER_HOUR;
        String strFhours;

        if (hours < 10){
            strFhours = "0" + Integer.toString(hours);
        } else {
            strFhours = Integer.toString(hours);
        }

        int minutes = this.m % MINUTES_PER_HOUR;
        String stFminutes; 

        if (minutes < 10){
            stFminutes = "0" + Integer.toString(minutes);
        } else {
            stFminutes = Integer.toString(minutes);
        }
        
        return strFhours + ":" + stFminutes;

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that){
        return this.m < that.m;
    }

    // Adds 1 minute to the time on this clock.
    public void tic(){
        m = (m + 1) % (MINUTES_PER_DAY);
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta){
        if (delta < 0) throw new IllegalArgumentException("Δ is negative");  
        // increment minutes
        m = (m + delta) % MINUTES_PER_DAY;
    }

    // Call each instance method directly & verify that they work as prescribed
    public static void main(String[] args){

        // construct clock1 at 09:00 with hours and minutes (9, 0) 
        Clock clock1 = new Clock(9,0);
        StdOut.println(clock1.toString());

        // construct clock2 with string (23:11)
        Clock clock2 = new Clock("23:11");
        StdOut.println(clock2.toString());

        // compare clocks
        StdOut.println("clock 2 is earlier than clock 1? " + clock2.isEarlierThan(clock1));

        // tic clock 1
        clock1.tic();
        StdOut.println(clock1.toString());

        // tock clock 2 - go over midnight
        clock2.toc(60);
        StdOut.println(clock2.toString());
        
        // compare clocks
        StdOut.println("clock 2 is earlier than clock 1? " + clock2.isEarlierThan(clock1));
    }
}
