import java.util.Scanner;

public class Game {

    //maybe we put here the hasWon ecc.?
    int i;
    int j;

    public Game() {
        //maybe we put here the hasWon ecc.?
    }

    public void start() {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(",+|\\n+|\\p{javaWhitespace}+"); //one or more commas, enters, whitespaces
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        board.displayBoard();
        while(!board.getHasWon()){ //until someone wins, it repeats
            board.printWhoIsNext();
            System.out.println("Enter your move (row and column): ");
            i = scanner.nextInt();
            j = scanner.nextInt();
            board.putAStone(i,j);
        }
        scanner.close();
    }

}