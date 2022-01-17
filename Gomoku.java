//main

public class Gomoku{
	
	public static void main(String[] args){
		char[][] board = initialBoard();
		//board[5][7] = '/'; //changing output test
		displayBoard(board);
	}
	
	public static char[][] initialBoard(){
		char[][] board = new char[15][15];
		for(int i=0; i<15; i++){
			for(int j=0; j<15; j++)
				board[i][j] = '+';
		}
		return board;
	}
	
	public static void displayBoard(char[][] board){
		System.out.println();
		int[] colonne = new int[15];
		for(int i=0; i<15; i++){
			colonne[i]= i+1;
			System.out.printf("%3d", colonne[i]);
		}

		System.out.println();
		System.out.println();
		for(int i=0; i<15; i++){
			for(int j=0; j<15; j++){
				String board2 = "  " + String.valueOf(board[i][j]);
				System.out.print(board2);
			}
			System.out.println("\t" + (i+1));
		}
		System.out.println();
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


