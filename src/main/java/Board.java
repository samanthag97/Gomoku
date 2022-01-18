public class Board {

    static char[][] board;
    static boolean colorFlag; //true B, false W
    static boolean hasWon;
    static int counter = 0;
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

    public void putAStone(int i, int j) {
        if (i > 15 || j > 15 || i < 0 || j < 0) //out of board
            System.out.println("Invalid input. Please digit a valid one.");

        else if (board[i - 1][j - 1] == '+') { //position not taken yet
            //OR SHOULD WE USE EXCEPTION??
            if (colorFlag == true) {
                board[i - 1][j - 1] = 'B'; //we have coordinates from 1, but in the array it's from 0, so we do -1
            } else {
                board[i - 1][j - 1] = 'W';
            }
            displayBoard(); //after adding a stone i display the board...

            if (sameColorInRow(i, j) == true) { //...and then check if that palyer won
                hasWon = true;
                System.out.println("\tWIN!!");
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
    }

    public boolean sameColorInRow(int row) { //not working (???)
        char currentPlayer;
        if (colorFlag == true) currentPlayer = 'B';
        else currentPlayer = 'W';
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

    public boolean sameColorInRow(int row, int column) {
        row = row - 1; //player digita 5, ma array parte da 0, quindi 4
        column -= 1;
        boolean fiveInRow = false;
        counter = 1; //da questo punto devo trovare altre 4 pedine uguali adiacenti
        counter = inRow(row, column);
        //System.out.println(counter); //just a test

        if (counter == winning)
            fiveInRow = true;
        return fiveInRow;
    }

    public int inRow(int row, int column) {
        if (column >= 15 - 1 || column <= 0) //controllo che non vada fuori dai bordi
            return counter;
        int counter1 = inRowAfter(row, column);
        int counter2 = inRowBefore(row, column);
        if (counter1 > counter2) //NO ME GUSTA TANTO
            return counter1;
        else return counter2;
    }

    public int inRowAfter(int row, int column) { //a destra della pedina appena messa
        if (column + 1 > 15) return counter; //se esce dalla tabella
        else if (board[row][column] == board[row][column + 1]) {
            counter += 1;
            column += 1;
            inRowAfter(row, column);
        }
        return counter;
    }

    public int inRowBefore(int row, int column) { //a sinistra della pedina appena messa
        if (column - 1 < 1) return counter; //se esce dalla tabella
        else if (board[row][column] == board[row][column - 1]) {
            counter += 1;
            column -= 1;
            inRowBefore(row, column);
        }
        return counter;
    }

    public void printWhoIsNext() {
        if (hasWon == false) {
            String nextPlayer;
            if (colorFlag == true) { //B
                nextPlayer = "black";
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
