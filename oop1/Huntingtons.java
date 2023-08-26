public class Huntingtons {

    // Returns the maximum number of **consecutive** repeats of CAG in the DNA string.
    // We recommend that you use the substring(), equals(), and length() methods
    public static int maxRepeats(String dna) {
        int max_count = 0;
        int current_count = 0;
        int i = 0;

        while (i <= dna.length() - 3) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                current_count += 1;
                i += 3;
            } else {
                current_count = 0;
                i += 1;
            }
            if (current_count > max_count) max_count = current_count;
        }
        return max_count;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    // We recommend that you use the replace() method from the String library
    public static String removeWhitespace(String s) {
        return s.replace(" ", "").replace("\t", "").replace("\n", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) return "not human";
        else if (maxRepeats <= 35) return "normal";
        else if (maxRepeats < 40) return "high risk";
        else if (maxRepeats <= 180) return "Huntington's";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // Take the name of a file as a command-line argument.
        String filename = args[0];

        // Read the genetic sequence from the file using the In class.
        In in = new In(filename);
        String raw_sequence = in.readAll();

        // Remove any whitespace (spaces, tabs, and newlines).
        String stripped_sequence = removeWhitespace(raw_sequence);

        // Count the number of CAG repeats.
        int max_repeats = maxRepeats(stripped_sequence);
        StdOut.println("max repeats = " + max_repeats);

        // Print a medical diagnosis in the format below.
        StdOut.println(diagnose(max_repeats));

        // close input stream
        in.close();
    }
}
