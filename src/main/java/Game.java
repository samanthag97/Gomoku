import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

class Game {

    private static final String exitGame = "x";
    private Board board;

    public Game(Board board) {
        this.board = board;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("[\\p{Punct}\\p{javaWhitespace}]+"); //any punctuation characters or whitespaces allowed		
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        board.displayBoard();
        int row;
        int column;
        while (!board.gameOver) { //until someone wins, it repeats
            board.printWhoIsNext();
            System.out.println("Enter your move: \t[or digit x to exit the game.]");
            System.out.print("Row: ");
            String r = scanner.nextLine().trim(); //elimino eventuali spazi all'inio e alla fine
            //r.trim();
            System.out.print("Column: ");
            String c = scanner.nextLine().trim();
            if (r.equalsIgnoreCase(exitGame) || c.equalsIgnoreCase(exitGame)) {
                System.out.println("Closing the game, bye!");
                break;
            }
            System.out.println(r + ", " + c);

            try {
                row = Integer.valueOf(r);
                column = Integer.valueOf(c);
                board.putAStone(row, column);
            } catch (NumberFormatException error) {
                System.out.println("Sorry, only integer numbers are allowed.");
                //scanner.next();
            }
        }
        scanner.close();
    }

}
