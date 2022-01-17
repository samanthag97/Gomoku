//main

public class Gomoku {

    public static void main(String[] args) {
        Board board = new Board();
        board.displayBoard(); //should be starting board
        board.putAStone(5, 7); //changing output test
        board.displayBoard(); //now it's changed
        board.putAStone(5, 8); //second move
        board.displayBoard(); //should have B and W
        // !!! should be using tests and not prints to check the board !!!
    }
	



	
	
	/* FORMATTING MATRIX TEST 
	public static void displayTest(char[][] b){		
		int [][] test = new int [5][5];
		for(int i=0; i<15; i++){
			for(int j=0; j<15; j++){
				test[i][j] = i*j;
				System.out.printf("%4d", test[i][j]); //%4d serve per formattare meglio la tabella
			}
			System.out.println();
		}		
	}
	*/


}


//controllare che gli accessi siano giusti (public/private/static...)


