import java.util.Scanner;
import java.lang.NumberFormatException;

class GameBoard {

    private Position[][] board;
    private boolean isBlackTurn;
    public boolean isGameOver;
    private int positionsTaken;
    private static final int WINNING = 5;
    private static final int BOARD_SIZE = 15;
    private static final char FIRST_LETTER = 'A';
    private static final char LAST_LETTER = (char) (FIRST_LETTER + BOARD_SIZE);
    private static final String exitCommand = "x";


    public GameBoard() {
        this.initializeBoard();
        isBlackTurn = true;
        isGameOver = false;
        positionsTaken = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard();
        gameBoard.printBoard();
        int row;
        int column;
        while (!isGameOver) {
            System.out.println("It's " + gameBoard.getCurrentPlayer().name() + " turn.");
            System.out.println("Enter your move: \t[or digit \"" + exitCommand + "\" to exit the game.]");
            System.out.print("Insert Row: ");
            String rowInput = getInput(scanner);
            if (isExit(rowInput)) System.exit(0);
            while (!isValidRow(rowInput)) {
                System.out.println("Invalid input. Please digit a valid Integer");
                rowInput = getInput(scanner);
            }
            System.out.print("Insert Column: ");
            String columnInput = getInput(scanner);
            while (!isValidColumn(columnInput)) {
                System.out.println("Invalid input. Please digit a valid Character");
                columnInput = getInput(scanner);
            }
            row = BOARD_SIZE - Integer.valueOf(rowInput);
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
        if (input.equalsIgnoreCase(exitCommand)) {
            System.out.println("Closing the game, bye!");
            return true;
        } else
            return false;
    }

    public boolean isValidRow(String rowInput) {
        try {
            int r = Integer.parseInt(rowInput);
            if (r > 0 && r <= BOARD_SIZE)
                return true;
            else
                return false;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    public boolean isValidColumn(String columnInput) {
        if (columnInput.matches("[" + FIRST_LETTER + "-" + LAST_LETTER + "]")) { //esattamente una lettera compresa tra prima e ultima
            return true;
        } else
            return false;
    }

    public void initializeBoard() {
        board = new Position[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = new Position();
        }
    }

    public Player getCurrentPlayer() {
        if (isBlackTurn) return Player.BLACK;
        else return Player.WHITE;
    }

    public boolean isOutside(int row, int column) {
        if (row >= BOARD_SIZE || column >= BOARD_SIZE || row < 0 || column < 0) {
            return true;
        }
        return false;
    }

    public void putAStone(int row, int column) {
        if (board[row][column].isTaken())
            System.out.println("This position is already taken! Please digit a valid input.");
        else {
            board[row][column].changeContent(getCurrentPlayer());
            positionsTaken++;
            printBoard();
            if (itsAWin(row, column)) {
                isGameOver = true;
                System.out.println("\t" + getCurrentPlayer().name() + " wins!\n");
            } else if (positionsTaken == BOARD_SIZE * BOARD_SIZE) {
                isGameOver = true;
                System.out.println("\tThe board is full, it's a draw!\n");
            } else isBlackTurn = !isBlackTurn;
        }
    }

    public void printBoard() {
        System.out.println();
        printLetters();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.printf("%3d", BOARD_SIZE - i);
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print("  ");
                board[i][j].print();
            }
            System.out.println("  " + (BOARD_SIZE - i));
        }
        printLetters();
        System.out.println();
    }

    public void printLetters() {
        char[] letters = new char[BOARD_SIZE];
        System.out.print("     ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            letters[i] = (char) (FIRST_LETTER + i);
            System.out.print(letters[i] + "  ");
        }
        System.out.println();
    }


    public boolean itsAWin(int row, int column) {
        return thereAreFive(row, column, 0, 1, getCurrentPlayer()) || //in row
                thereAreFive(row, column, 1, 0, getCurrentPlayer()) || //in column
                thereAreFive(row, column, 1, 1, getCurrentPlayer()) || //in diagonal up-down
                thereAreFive(row, column, 1, -1, getCurrentPlayer()); //in diagonal down-up
    }

    public boolean thereAreFive(int r, int c, int rDirection, int cDirection, Player player) {
        int count = 1;
        int row = r + rDirection;
        int column = c + cDirection;
        while (!isOutside(row, column) && (board[row][column].getContent() == player)) {
            count += 1;
            row = row + rDirection;
            column = column + cDirection;
        }
        row = r - rDirection;
        column = c - cDirection;
        while (!isOutside(row, column) && (board[row][column].getContent() == player)) {
            count += 1;
            row = row - rDirection;
            column = column - cDirection;
        }
        return count == WINNING;
    }
}
