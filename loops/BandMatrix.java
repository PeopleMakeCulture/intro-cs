public class BandMatrix {
    public static void main(String[] args) {

        /* print an n-by-n pattern

        with a zero (0) for each element whose distance from the main diagonal is strictly more than width,
        an asterisk (*) for each entry that is not,
        and two spaces between each 0 or *

         */

        int n = Integer.parseInt(args[0]), width = Integer.parseInt(args[1]);

        // case 1: if width is 0

        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) > width) {
                    row += "0  ";
                } else {
                    row += "*  ";
                }
            }

            System.out.println(row);
        }


    }
}
