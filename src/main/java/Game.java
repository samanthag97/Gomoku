import java.util.Scanner;
import java.lang.NumberFormatException;

class Game {

    private static final String exitGame = "x";

    public void start() { ///////TODO dividere in pezzi
        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard();
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        gameBoard.displayBoard();
        int row = 1;
        int column;
        while (!gameBoard.gameOver) {
            System.out.println("It's " + gameBoard.getCurrentPlayer().name() + " turn.");
            System.out.println("Enter your move: \t[or digit x to exit the game.]");
            System.out.print("Enter row number: ");
            String r = scanner.nextLine().trim();
            if (r.equalsIgnoreCase(exitGame)) {
                System.out.println("Closing the game, bye!");
                break;
            }
            boolean validInt = false;
            do {
                try {
                    row = Math.abs(Integer.parseInt(r) - 15);
                    validInt=true;
                } catch (NumberFormatException error) {
                    System.out.println("Sorry, only integer numbers are allowed. Enter row number: ");
                    r = scanner.nextLine().trim();
                }
            } while (!validInt);
            System.out.print("Enter column letter: ");
            String c = scanner.nextLine().trim().toUpperCase();
            if (c.equalsIgnoreCase(exitGame)) {
                System.out.println("Closing the game, bye!");
                break;
            }
            while (!c.matches("[A-O]")) {
                System.out.print("Please enter a valid column letter: ");
                c = scanner.nextLine().trim().toUpperCase();
            }
            System.out.println(r + ", " + c);
            column = getValueOfColumn(c);
            gameBoard.putAStone(row, column);
        }
        scanner.close();
    }

    public int getValueOfColumn(String c) {
        char tmp = c.charAt(0);
        int column = Math.abs(65 - tmp);
        return column;
    }


}
