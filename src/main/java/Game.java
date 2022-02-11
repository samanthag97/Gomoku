import java.util.Scanner;
import java.lang.NumberFormatException;

class Game {

    private final GameBoard gameBoard;
    private final int boardSize;
    private final char firstLetter;
    private final char lastLetter;
    private static final String EXIT_COMMAND = "exit";

    public Game(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        boardSize = gameBoard.getBoardSize();
        firstLetter = gameBoard.getFirstLetter();
        lastLetter = (char) (firstLetter + boardSize);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here's the board:");
        gameBoard.printBoard();
        int row;
        int column;
        while (!gameBoard.getIsGameOver()) {
            System.out.println("It's " + gameBoard.getCurrentPlayer().name() + " turn.");
            System.out.println("Enter your move (or \"" + EXIT_COMMAND + "\" to exit the game):");
            System.out.print("Insert Row: ");
            String rowInput = getInput(scanner);
            if (isExit(rowInput)) {
                System.out.println("Closing the game, bye!");
                System.exit(0);
            }
            while (!isValidRow(rowInput)) {
                System.out.print("Invalid input. Please digit a valid Integer: ");
                rowInput = getInput(scanner);
            }
            System.out.print("Insert Column: ");
            String columnInput = getInput(scanner);
            while (!isValidColumn(columnInput)) {
                System.out.print("Invalid input. Please digit a valid Character: ");
                columnInput = getInput(scanner);
            }
            row = boardSize - Integer.parseInt(rowInput);
            char columnChar = columnInput.charAt(0);
            column = Math.abs(columnInput.charAt(0) - 'A');
            System.out.println("Your move: " + rowInput + ", " + columnChar);
            gameBoard.putAStone(row, column);
        }
        scanner.close();
    }

    private String getInput(Scanner scanner) {
        return scanner.nextLine().trim().toUpperCase();
    }

    private boolean isExit(String input) {
        return input.equalsIgnoreCase(EXIT_COMMAND);
    }

    private boolean isValidRow(String rowInput) {
        try {
            int r = Integer.parseInt(rowInput);
            return r > 0 && r <= boardSize;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    private boolean isValidColumn(String columnInput) {
        return columnInput.matches("[" + firstLetter + "-" + lastLetter + "]");
    }
}