public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] sequence = new int[n];
        String[][] weave = new String[n][n];

        // produce sequence
        sequence[0] = 0;

        int sequence_pointer = 1;
        int sub_length = 1;

        while (sub_length < n && sequence_pointer < n) {

            int sub_pointer = 0;

            while (sub_pointer < sub_length && sequence_pointer < n) {

                if (sequence[sub_pointer] == 0) {
                    sequence[sequence_pointer] = 1;
                } else {
                    sequence[sequence_pointer] = 0;
                }
                sequence_pointer++;
                sub_pointer++;
            }
            sub_length *= 2;
        }

        // draw weave
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    weave[i][j] = "+  ";
                } else (weave[i][j]) = "-  ";
                System.out.print(weave[i][j]);
            }
            System.out.print("\n");
        }

    }

}
