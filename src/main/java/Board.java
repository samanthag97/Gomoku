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
        return fiveCounted(row, column, 0, 1, getCurrentPlayer()) || //in row
                fiveCounted(row, column, 1, 0, getCurrentPlayer()) || //in column
                fiveCounted(row, column, 1, 1, getCurrentPlayer()) || //in diagonal up-down
                fiveCounted(row, column, 1, -1, getCurrentPlayer()); //in diagonal down-up
    }

    public boolean fiveCounted(int r, int c, int rDirection, int cDirection, char player) {
        int count = 1;
        int row = r + rDirection;
        int col = c + cDirection;
        while ((row >= 0) && (col >= 0) && (row < 15) && (col < 15) &&
                (board[row][col] == player)) {
            count += 1;
            row = row + rDirection;
            col = col + cDirection;
        }
        row = r - rDirection;
        col = c - cDirection;
        while ((row < 15) && (col < 15) && (row >= 0) && (col >= 0) &&
                (board[row][col] == player)) {
            count += 1;
            row = row - rDirection;
            col = col - cDirection;
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
