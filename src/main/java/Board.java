public class Board {

    static char[][] board;
    static boolean colorFlag;

    public Board() {
        this.initializeBoard();
        colorFlag = true; //black (B) starts
    }

    public void initializeBoard() {
        board = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++)
                board[i][j] = '+';
        }
    }

    public static void putAStone(int i, int j) {
        // TODO needs to be an empty space, I shouldn't be able to put B over W
        if (colorFlag == true) {
            board[i - 1][j - 1] = 'B'; //we have coordinates from 1, but in the array it's from 0, so we do -1
        } else {
            board[i - 1][j - 1] = 'W';
        }
        colorFlag = !colorFlag; //changes color --> next player's turn
    }

    public static void displayBoard() {
        System.out.println();
        int[] colonne = new int[15];
        for (int i = 0; i < 15; i++) {
            colonne[i] = i + 1;
            System.out.printf("%3d", colonne[i]);
        }

        System.out.println();
        System.out.println();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                String board2 = "  " + String.valueOf(board[i][j]);
                System.out.print(board2);
            }
            System.out.println("\t" + (i + 1));
        }
        System.out.println();
    }

    public static char[] getRow(int rowNumber) {
        return board[rowNumber];
    }
}
