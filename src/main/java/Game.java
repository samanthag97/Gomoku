import java.util.Scanner;
import java.util.InputMismatchException;

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
        scanner.useDelimiter("[\\p{Punct}\\p{javaWhitespace}]+"); //any punctuation characters or whitespaces allowed
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        board.displayBoard();
        while (!board.getHasWon()) { //until someone wins, it repeats
            board.printWhoIsNext();
            System.out.println("Enter your move (row and column): \t[or digit 0 to exit the game.]");
            try {
                row = scanner.nextInt();
                if (row == 0)
                    break;
                column = scanner.nextInt();
                board.putAStone(row, column);
            } catch (InputMismatchException error) {
                System.out.println("An error happened: " + "No characters allowed.");
                scanner.next();
            }

        }
        scanner.close();
    }

}
