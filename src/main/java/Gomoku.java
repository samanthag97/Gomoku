//main

public class Gomoku {

    public static void main(String[] args) {
        Board board = new Board();
        board.displayBoard(); //should be starting board
        board.putAStone(5, 7); //changing output test (B)
        //board.displayBoard(); //now it's changed
        board.putAStone(6, 7); //second move W
		board.putAStone(5, 8); //B
		board.putAStone(2, 7); //w
		board.putAStone(5, 9); //b
		board.putAStone(3, 7); //w
		board.putAStone(5, 10); //b
		board.putAStone(9, 7); //w
		board.putAStone(5, 11); //b
        board.displayBoard(); //should have B and W
        // !!! should be using tests and not prints to check the board !!!
		
		if(board.sameColorInRow()==true)
			System.out.println("WIN!!");
		
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


