import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

class Game {

    //maybe we put here the hasWon ecc.?
    private int row;
    private int column;
    private static final char exitGame = 'x';

    public Game() {
        //maybe we put here the hasWon ecc.?
    }

    public void start() {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("[\\p{Punct}\\p{javaWhitespace}]+"); //any punctuation characters or whitespaces allowed
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        board.displayBoard();
        while (!board.getHasWon()){ //until someone wins, it repeats
			if(board.isFull()){
				System.out.println("\tboard is full, game over!\n");
				break;
			}
			else{
				board.printWhoIsNext();
				System.out.println("Enter your move (row and column): \t[or digit x to exit the game.]");
				
				try {
					String r = scanner.next();
					if (r.equalsIgnoreCase("x"))
						break;
					String c = scanner.next();		
			
					row = Integer.valueOf(r);
					column = Integer.valueOf(c);					
					board.putAStone(row, column);
				} catch (NumberFormatException error) {
					System.out.println("Sorry, only integer numbers are allowed.");
					//scanner.next();
				}
			}
        }
        scanner.close();
		
    }

}
