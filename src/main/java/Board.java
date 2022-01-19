public class Board {

    static char[][] board;
    static boolean colorFlag; //true B, false W
    static boolean hasWon;
    static final int winning = 5;

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

    public void putAStone(int i, int j) {
        if (i > 15 || j > 15 || i < 0 || j < 0) //out of board
            System.out.println("Invalid input. Please digit a valid one.");

        else if (board[i - 1][j - 1] == '+') { //position not taken yet
            //OR SHOULD WE USE EXCEPTION??
            board[i - 1][j - 1] = getCurrentPlayer(); //we have coordinates from 1, but in the array it's from 0, so we do -1

            displayBoard(); //after adding a stone i display the board...

            if (sameColorInRow(i - 1) == true || sameColorInColumn(j - 1) == true) { //...and then check if that palyer won
                hasWon = true;
                System.out.println("\tWIN!!");
                System.out.println("\t" + getCurrentPlayer() + " wins!");
            } else colorFlag = !colorFlag; //otherwise keep playing: changes color --> next player's turn

        } else System.out.println("Error, this position is already taken, choose another one.");
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
                String board2 = "  " + board[i][j];
                System.out.print(board2);
            }
            System.out.println("\t" + (i + 1));
        }
        System.out.println();
    }

    public static char[] getRow(int rowNumber) {
        return board[rowNumber];
    } //for the test

    public boolean sameColorInRow(int row) {
        char currentPlayer = getCurrentPlayer();
        int sameColor = 0;
        for (int column = 0; column < 15; column++) {
            if (board[row][column] == currentPlayer)
                sameColor++;
            else sameColor = 0;
            if (sameColor == winning)
                return true;
        }
        return false;
    }

    public boolean sameColorInColumn(int column) { //oppure trasposta e uso row?
        char currentPlayer = getCurrentPlayer();
        int sameColor = 0;
        for (int row = 0; row < 15; row++) {
            if (board[row][column] == currentPlayer)
                sameColor++;
            else sameColor = 0;
            if (sameColor == winning)
                return true;
        }
        return false;
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

    public static boolean getHasWon() {
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
