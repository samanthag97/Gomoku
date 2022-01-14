//main

public class Gomoku{
	
	public static void main(String[] args){
		char[][] board = initialBoard();
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
									
		for(int i=0; i<15; i++){
			for(int j=0; j<15; j++)
				System.out.print(board[i][j] + "  ");
			System.out.println();			
		}
	}
	
}


//controllare che gli accessi siano giusti (public/private/static...)