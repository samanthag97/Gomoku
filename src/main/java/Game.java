import java.util.Scanner;
import java.lang.NumberFormatException;

class Game {

    private static final String exitGame = "x";

    public void start() { ///////TODO dividere in pazzi
        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard();
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        gameBoard.displayBoard();
        int row;
        int column;
        while (!gameBoard.gameOver) {
            System.out.println("It's " + gameBoard.getCurrentPlayer().name() + " turn.");
            System.out.println("Enter your move: \t[or digit x to exit the game.]");
            System.out.print("Row: ");
            String r = scanner.nextLine().trim();
            if (r.equalsIgnoreCase(exitGame)) {
                System.out.println("Closing the game, bye!");
                break;
            }
            System.out.print("Column: ");
            String c = scanner.nextLine().trim();
            if (c.equalsIgnoreCase(exitGame)) {
                System.out.println("Closing the game, bye!");
                break;
            }
            System.out.println(r + ", " + c);
            try {
                row = Math.abs(Integer.valueOf(r) - 15);
                column = Integer.valueOf(c) - 1;
                gameBoard.putAStone(row, column);
            } catch (NumberFormatException error) {
                System.out.println("Sorry, only integer numbers are allowed.");
            }
        }
        scanner.close();
    }



}
