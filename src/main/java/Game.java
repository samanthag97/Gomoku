import java.util.Scanner;

class Game {

    private static final String exitCommand = "x";

    public void start() { ///////TODO dividere in pezzi
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\\p{Punct}\\p{javaWhitespace}]+"); //any punctuation characters or whitespaces allowed
        GameBoard gameBoard = new GameBoard();
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        gameBoard.printBoard();
        int row;
        int column;
        while (!gameBoard.isGameOver) {
            System.out.println("It's " + gameBoard.getCurrentPlayer().name() + " turn.");
            System.out.println("Enter your move (row and column): \t[or digit \"" + exitCommand + "\" to exit the game.]");
            String rowInput = scanner.next();
            if (rowInput.equalsIgnoreCase(exitCommand)) {
                System.out.println("Closing the game, bye!");
                break;
            }
            String columnInput = scanner.next().toUpperCase();
            while (!rowInput.matches("\\d+")) {
                System.out.println("Please enter a valid row number (you entered \"" + rowInput + "\"):");
                rowInput = scanner.next();
            }
            row = 15 - Integer.valueOf(rowInput);
            while (!columnInput.matches("[a-zA-Z]")) {
                System.out.println("Please enter a valid column letter(you entered \"" + columnInput + "\"):");
                columnInput = scanner.next().toUpperCase();
            }
            column = columnInput.charAt(0) - 'A';
            System.out.println("Position: " + rowInput + ", " + columnInput);
            gameBoard.putAStone(row, column);
        }
        scanner.close();
    }

}
