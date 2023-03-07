public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]), n = Integer.parseInt(args[1]),
                k = Integer.parseInt(args[2]);

        int[][] mines = new int[m][n];

        // assign k mines randomly
        for (int mine = 0; mine < k; mine++) {

            // pick a number between 0 and m*n, k times
            int random_raw = (int) (Math.random() * m * n);

            // TODO: Fix random assignment
            int i = random_raw / n;
            int j = random_raw % n;

            // System.out.printf("random: %d, i: %d, j: %d\n", random_raw, i, j);

            // two mines cannot be in same location
            if (mines[i][j] == -1) k++;
            else mines[i][j] = -1;
        }

        // iterate over all positions and count mine_neighbors
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j] != -1) {
                    try {
                        int count = 0;

                        if (j > 0 && mines[i][j - 1] == -1) count++;
                        if (j < n - 1 && mines[i][j + 1] == -1) count++;
                        if (i > 0 && mines[i - 1][j] == -1) count++;
                        if (i < m - 1 && mines[i + 1][j] == -1) count++;
                        // 4 diagonals
                        if (j > 0 && i > 0 && mines[i - 1][j - 1] == -1) count++;
                        if (j < n - 1 && i > 0 && mines[i - 1][j + 1] == -1) count++;
                        if (i < m - 1 && j > 0 && mines[i + 1][j - 1] == -1) count++;
                        if (i < m - 1 && j < n - 1 && mines[i + 1][j + 1] == -1) count++;

                        mines[i][j] = count;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.printf("OOB error at mines[%d][%d]\n", i, j);
                    }
                }
            }
        }

        // print output
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j] == -1) {
                    System.out.print("*  ");
                } else {
                    System.out.print(mines[i][j] + "  ");
                }
            }
            System.out.print("\n");
        }
    }

}
