import java.util.Scanner;
import java.lang.NumberFormatException;

class Game {

    private static GameBoard gameBoard;
    private final int boardSize;
    private final char firstLetter;
    private final char lastLetter;
    private static final String EXIT_COMMAND = "x";

    public Game(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        boardSize = gameBoard.getBoardSize();
        firstLetter = gameBoard.getFirstLetter();
        lastLetter = (char) (firstLetter + boardSize);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        gameBoard.printBoard();
        int row;
        int column;
        while (!gameBoard.getIsGameOver()) {
            System.out.println("It's " + gameBoard.getCurrentPlayer().name() + " turn.");
            System.out.println("Enter your move: \t[or digit \"" + EXIT_COMMAND + "\" to exit the game.]");
            System.out.print("Insert Row: ");
            String rowInput = getInput(scanner);
            if (isExit(rowInput)) System.exit(0);
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
            System.out.println("Position: " + rowInput + ", " + columnChar);
            gameBoard.putAStone(row, column);
        }
        scanner.close();
    }

    public String getInput(Scanner scanner) {
        return scanner.nextLine().trim().toUpperCase();
    }

    public boolean isExit(String input) {
        if (input.equalsIgnoreCase(EXIT_COMMAND)) {
            System.out.println("Closing the game, bye!");
            return true;
        } else
            return false;
    }

    public boolean isValidRow(String rowInput) {
        try {
            int r = Integer.parseInt(rowInput);
            if (r > 0 && r <= boardSize)
                return true;
            else
                return false;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    public boolean isValidColumn(String columnInput) {
        if (columnInput.matches("[" + firstLetter + "-" + lastLetter + "]")) { //esattamente una lettera compresa tra prima e ultima
            return true;
        } else
            return false;
    }
}