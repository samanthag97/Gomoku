class Board {

    private char[][] board;
    private boolean colorFlag; //true B, false W
    private boolean hasWon;
    private static final int winning = 5;

    public Board() {
        this.initializeBoard();
        colorFlag = true; //black (B) starts
        hasWon = false;
    }

    public void initializeBoard() {
        board = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++)
                board[i][j] = '+';
        }
    }

    public char getCurrentPlayer() {
        if (colorFlag == true) return 'B';
        else return 'W';
    }

    public boolean checkPosition(int row, int column) {
        boolean error = false;
        if (row > 15 || column > 15 || row < 1 || column < 1 || (board[row - 1][column - 1] != '+'))
            error = true;
        //if) //already taken
        //error = true;
        return error;
    }

    public void putAStone(int row, int column) {
        if (checkPosition(row, column))
            System.out.println("Invalid input. Please digit a valid one.");
        else {
            board[row - 1][column - 1] = getCurrentPlayer(); //we have coordinates from 1, but in the array it's from 0, so we do -1
            displayBoard();
            if (itsAWin(row - 1, column - 1)) {
                hasWon = true;
                System.out.println("\tWIN!!");
                System.out.println("\t" + getCurrentPlayer() + " wins!");
            } else colorFlag = !colorFlag; //next player's turn

        }
    }

    public void displayBoard() {
        System.out.println();
        int[] columns = new int[15];
        for (int i = 0; i < 15; i++) {
            columns[i] = i + 1;
            System.out.printf("%3d", columns[i]);
        }

        System.out.println();
        System.out.println();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
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
        return sameColorInRow(row, getCurrentPlayer()) || sameColorInColumn(column, getCurrentPlayer()) ||
                sameColorInGraveDiagonal(row, column, getCurrentPlayer()) ||
                sameColorInAcuteDiagonal(row, column, getCurrentPlayer());
    }

    public boolean sameColorInRow(int row, char currentPlayer) {
        int sameColor = 0;
        for (int column = 0; column < 15; column++) {
            if (board[row][column] == currentPlayer)
                sameColor++;
            else {
                if (sameColor == winning)
                    return true;
                sameColor = 0;
            }
        }
        return false;
    }

    public boolean sameColorInColumn(int column, char currentPlayer) { //oppure trasposta e uso row?
        int sameColor = 0;
        for (int row = 0; row < 15; row++) {
            if (board[row][column] == currentPlayer)
                sameColor++;
            else {
                if (sameColor == winning)
                    return true;
                sameColor = 0;
            }
        }
        return false;
    }

    public boolean sameColorInGraveDiagonal(int r, int c, char player) {
        //+1+1

        int count = 1;
        int row = r - 1;
        int col = c - 1;
        while ((row >= 0) && (col >= 0) &&
                (board[row][col] == player)) {
            count += 1;
            row--;
            col--;
        }
        row = r + 1;
        col = c + 1;
        while ((row < 15) && (col < 15) &&
                (board[row][col] == player)) {
            count += 1;
            row++;
            col++;
        }
        return count == winning;
    }

    public boolean sameColorInAcuteDiagonal(int r, int c, char player) {
        //+1-1

        int count = 1;
        int row = r - 1;
        int col = c + 1;
        while ((row >= 0) && (col < 15) &&
                (board[row][col] == player)) {
            count += 1;
            row--;
            col++;
        }
        row = r + 1;
        col = c - 1;
        while ((row < 15) && (col >= 0) &&
                (board[row][col] == player)) {
            count += 1;
            row++;
            col--;
        }
        return count == winning;
    }


    public void printWhoIsNext() {
        if (hasWon == false) {
            String nextPlayer;
            if (colorFlag == true) { //B
                nextPlayer = "black"; //maybe with a switch?
            } else nextPlayer = "white";
            System.out.print("It's " + nextPlayer + "'s turn. ");
        }
    }

    public boolean getHasWon() {
        return hasWon;
    }


    //colonne: basta fare la trasposta e usare i metodi per le righe
    //diagonale:
	/*
	cerco il primo elemento B/W	in tutte le righe (vedi sopra). Quando trovo il primo
	(vuol dire che nelle righe prima non c'era), controllo a dx (5inRow), sotto (5inColumn)
	e poi controllo sotto a dx (board[i+1][i+1])
	*/


}
