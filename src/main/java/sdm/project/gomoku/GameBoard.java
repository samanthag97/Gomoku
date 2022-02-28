package sdm.project.gomoku;

class GameBoard {

    private Position[][] board;
    private boolean isBlackTurn;
    protected boolean isGameOver;
    private int positionsTaken;
    private static final int WINNING = 5;
    private static final int BOARD_SIZE = 15;
    private static final char FIRST_LETTER = 'A';

    public GameBoard() {
        this.initializeBoard();
        isBlackTurn = true;
        isGameOver = false;
        positionsTaken = 0;
    }

    private void initializeBoard() {
        board = new Position[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = new Position();
        }
    }

    protected void putAStoneAndPrint(int row, int column) {
        if (board[row][column].isTaken())
            System.out.println("This position is already taken! Please digit a valid input.");
        else {
            board[row][column].changeContent(getCurrentPlayer());
            positionsTaken++;
            printBoard();
            if (itsAWin(row, column)) {
                isGameOver = true;
                System.out.println("\t" + getCurrentPlayer().name() + " wins!\n");
            } else if (positionsTaken == BOARD_SIZE * BOARD_SIZE) {
                isGameOver = true;
                System.out.println("\tThe board is full, it's a draw!\n");
            } else isBlackTurn = !isBlackTurn;
        }
    }

    protected void printBoard() {
        System.out.println();
        printLetters();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.printf("%3d", BOARD_SIZE - i);
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print("  ");
                board[i][j].print();
            }
            System.out.println("  " + (BOARD_SIZE - i));
        }
        printLetters();
        System.out.println();
    }

    private void printLetters() {
        char[] letters = new char[BOARD_SIZE];
        System.out.print("     ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            letters[i] = (char) (FIRST_LETTER + i);
            System.out.print(letters[i] + "  ");
        }
        System.out.println();
    }


    private boolean itsAWin(int row, int column) {
        return thereAreFive(row, column, 0, 1, getCurrentPlayer()) || //in row
                thereAreFive(row, column, 1, 0, getCurrentPlayer()) || //in column
                thereAreFive(row, column, 1, 1, getCurrentPlayer()) || //in diagonal up-down
                thereAreFive(row, column, 1, -1, getCurrentPlayer()); //in diagonal down-up
    }

    private boolean thereAreFive(int r, int c, int rDirection, int cDirection, Player player) {
        int count = 1;
        int row = r + rDirection;
        int column = c + cDirection;
        while (isInside(row, column) && (board[row][column].getContent() == player)) {
            count += 1;
            row = row + rDirection;
            column = column + cDirection;
        }
        row = r - rDirection;
        column = c - cDirection;
        while (isInside(row, column) && (board[row][column].getContent() == player)) {
            count += 1;
            row = row - rDirection;
            column = column - cDirection;
        }
        return count == WINNING;
    }

    private boolean isInside(int row, int column) {
        return row < BOARD_SIZE && column < BOARD_SIZE && row >= 0 && column >= 0;
    }

    protected Player getCurrentPlayer() {
        return isBlackTurn ? Player.BLACK : Player.WHITE;
    }

    protected boolean getIsGameOver() {
        return isGameOver;
    }

    protected int getBoardSize() {
        return BOARD_SIZE;
    }

    protected char getFirstLetter() {
        return FIRST_LETTER;
    }
}
