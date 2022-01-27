class Board {

    private char[][] board;
    private boolean colorFlag; //true B, false W
    public boolean gameOver;
    private int numberOfMoves;
    private static final int winning = 5;
    private static final int boardSize = 15;

    public Board() {
        this.initializeBoard();
        colorFlag = true; //black (B) starts
        gameOver = false;
        numberOfMoves = 0;
    }

    public void initializeBoard() {
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++)
                board[i][j] = '+';
        }
    }

    public char getCurrentPlayer() {
        if (colorFlag == true) return 'B';
        else return 'W';
    }

    public boolean checkPosition(int row, int column) {
        boolean error = false;
        if (row > boardSize || column > boardSize || row < 1 || column < 1) {
            error = true;
            System.out.print("This position is outside the board. ");
        } else if (board[row - 1][column - 1] != '+') {
            error = true;
            System.out.print("This position is already taken. ");
        }
        return error;
    }

    public void putAStone(int row, int column) {
        if (checkPosition(row, column))
            System.out.println("Please digit a valid input.");
        else {
            board[row - 1][column - 1] = getCurrentPlayer(); //we have coordinates from 1, but in the array it's from 0, so we do -1
            numberOfMoves++;
            displayBoard();
            if (itsAWin(row - 1, column - 1)) {
                gameOver = true;
                System.out.println("\t" + getCurrentPlayer() + " wins!\n");
            } else if (numberOfMoves == boardSize * boardSize) {
                gameOver = true;
                System.out.println("\tThe board is full, it's a draw!\n");
            } else colorFlag = !colorFlag; //next player's turn
        }
    }

    public void displayBoard() {
        System.out.println();
        int[] columns = new int[boardSize];
        for (int i = 0; i < boardSize; i++) {
            columns[i] = i + 1;
            System.out.printf("%3d", columns[i]);
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                String board2 = "  " + board[i][j];
                System.out.print(board2);
            }
            System.out.println("\t" + (i + 1));
        }
        System.out.println();
    }

    public char[] getRow(int rowNumber) {
        return board[rowNumber];
    } //for the test

    public boolean itsAWin(int row, int column) {
        return fiveCounted(row, column, 0, 1, getCurrentPlayer()) || //in row
                fiveCounted(row, column, 1, 0, getCurrentPlayer()) || //in column
                fiveCounted(row, column, 1, 1, getCurrentPlayer()) || //in diagonal up-down
                fiveCounted(row, column, 1, -1, getCurrentPlayer()); //in diagonal down-up
    }

    public boolean fiveCounted(int r, int c, int rDirection, int cDirection, char player) {
        int count = 1;
        int row = r + rDirection;
        int column = c + cDirection;
        while ((row >= 0) && (column >= 0) && (row < boardSize) && (column < boardSize) &&
                (board[row][column] == player)) {
            count += 1;
            row = row + rDirection;
            column = column + cDirection;
        }
        row = r - rDirection;
        column = c - cDirection;
        while ((row >= 0) && (column >= 0) && (row < boardSize) && (column < boardSize) &&
                (board[row][column] == player)) {
            count += 1;
            row = row - rDirection;
            column = column - cDirection;
        }
        return count == winning;
    }

    public void printWhoIsNext() {
        if (gameOver == false) {
            String nextPlayer;
            if (colorFlag == true) { //B
                nextPlayer = "black";
            } else nextPlayer = "white";
            System.out.print("It's " + nextPlayer + "'s turn. ");
        }
    }

}
