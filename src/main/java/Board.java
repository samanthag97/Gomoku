public class Board {

    static char[][] board;
    static boolean colorFlag;
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

    public static void putAStone(int i, int j) {
		if(board[i-1][j-1] == '+'){ //position not taken yet
		//OR SHOULD WE USE EXCEPTION??
			if (colorFlag == true) {
				board[i - 1][j - 1] = 'B'; //we have coordinates from 1, but in the array it's from 0, so we do -1
			} else {
				board[i - 1][j - 1] = 'W';
			}
			colorFlag = !colorFlag; //changes color --> next player's turn
		}
		else System.out.println("Error, this position is already taken, choose another one.");
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
	
	/*public boolean checkWinForB(){
		if(fiveBlackInRow == true)
			hasWon = true;		
		return hasWon;
	}*/
	
	public boolean sameColorInRow(){
		//find first element == B/W in the row and check if next 4 are same
		//facciamolo intanto per la riga 5: board[4]
		int riga = 4;
		int indexOfFirstElement = 0;
		boolean fiveInRow = false;
		while(board[riga][indexOfFirstElement] == '+'){
			indexOfFirstElement += 1;
			counter = 1;
			if(indexOfFirstElement >=15) //sono andato fuori dalla riga
				break;
		}
		counter = inRow(indexOfFirstElement, riga);
		
		if(counter == winning)
			fiveInRow = true;
		
		return fiveInRow;		
	}
	
	public int inRow(int indexOfFirstElement, int riga){
		if(indexOfFirstElement>=15)
			return counter;
		if(board[riga][indexOfFirstElement] == board[riga][indexOfFirstElement+1]){ 
			counter += 1;
			indexOfFirstElement += 1;
			inRow(indexOfFirstElement, riga);
		}
		return counter;
	}
		
}
