import java.util.Scanner;

class GameBoard {

    private Position[][] board;
    private boolean isBlackTurn;
    public boolean isGameOver;
    private int positionsTaken;
    private static final int WINNING = 5;
    private static final int BOARD_SIZE = 15;
    private static final int FIRST_LETTER = 65; //unicode for 'A' is 65
    private static final char LAST_LETTER = 'O';
    private char[] axes;
    private static final String exitCommand = "x";

    public GameBoard() {
        this.initializeBoard();
        isBlackTurn = true;
        isGameOver = false;
        positionsTaken = 0;
        axes = new char[BOARD_SIZE];
    }

    public void start() { ///////TODO dividere in pezzi
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\\p{Punct}\\p{javaWhitespace}]+"); //any punctuation characters or whitespaces allowed
        GameBoard gameBoard = new GameBoard();
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        gameBoard.displayBoard();
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
            while (!rowInput.matches("[0-" + BOARD_SIZE + "]")) {
                System.out.println("Please enter a valid row number (you entered \"" + rowInput + "\"):");
                rowInput = scanner.next();
            }
            row = 15 - Integer.valueOf(rowInput);
            while (!columnInput.matches("[A-" + LAST_LETTER + "]")) {
                System.out.println("Please enter a valid column letter(you entered \"" + columnInput + "\"):");
                columnInput = scanner.next().toUpperCase();
            }
            column = columnInput.charAt(0) - 'A';
            System.out.println("Position: " + rowInput + ", " + columnInput);
            gameBoard.putAStone(row, column);
        }
        scanner.close();
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
        //if (isOutside(row, column))
        //System.out.println("This position is outside the board! Please digit a valid input.");
        //else
        if (board[row][column].isTaken())
            System.out.println("This position is already taken! Please digit a valid input.");
        else {
            board[row][column].changeContent(getCurrentPlayer());
            positionsTaken++;
            displayBoard();
            if (itsAWin(row, column)) {
                isGameOver = true;
                System.out.println("\t" + getCurrentPlayer().name() + " wins!\n");
            } else if (positionsTaken == BOARD_SIZE * BOARD_SIZE) {
                isGameOver = true;
                System.out.println("\tThe board is full, it's a draw!\n");
            } else isBlackTurn = !isBlackTurn;
        }
    }

    public void displayBoard() { ///////TODO lettere?
        System.out.println();
        displayAxes();
        /*int[] columns = new int[BOARD_SIZE];
        System.out.print("   ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            columns[i] = i + 1;
            System.out.printf("%3d", columns[i]);
        }*/
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.printf("%3d", BOARD_SIZE - i);
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print("  ");
                board[i][j].print();
            }
            System.out.println("  " + (BOARD_SIZE - i));
        }
        System.out.println();
        displayAxes();
        System.out.println();

        /*for (int i = 0; i < BOARD_SIZE; i++) {
            columns[i] = i + 1;
            System.out.printf("%3d", columns[i]);
        }*/
    }

    public void displayAxes() {

        System.out.print("     ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            axes[i] = (char) (FIRST_LETTER + i);
            System.out.print(axes[i] + "  ");
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
