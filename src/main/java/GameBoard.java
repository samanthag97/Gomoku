import java.util.Scanner;
import java.lang.NumberFormatException;

class GameBoard {

    private Position[][] board;
    private boolean isBlackTurn;
    public boolean isGameOver;
    private int positionsTaken;
    private static final int WINNING = 5;
    private static final int BOARD_SIZE = 15;
    private static final int FIRST_LETTER = 65; //unicode for 'A' is 65
    private static final int LAST_LETTER = FIRST_LETTER + BOARD_SIZE; //if i change the size of the board this should change too
    private static final String exitCommand = "x";
	
	private int row;

    public GameBoard() {
        this.initializeBoard();
        isBlackTurn = true;
        isGameOver = false;
        positionsTaken = 0;
    }

    public void start() { ///////TODO dividere in pezzi
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("[\\p{Punct}\\p{javaWhitespace}]+"); //any punctuation characters or whitespaces allowed
        GameBoard gameBoard = new GameBoard();
        gameBoard.displayBoard();
        //int row;
        int column;
        while (!isGameOver) {
            System.out.println("It's " + gameBoard.getCurrentPlayer().name() + " turn.");
            System.out.println("Enter your move: \t[or digit \"" + exitCommand + "\" to exit the game.]");	            
			System.out.print("Insert Row: ");
			String rowInput = getInput(scanner);
			if (rowInput.equalsIgnoreCase(exitCommand)){
				System.out.println("Closing the game, bye!");
				break;
			}
			if(!validRow(rowInput))
				System.out.println("Invalid input. Please digit a valid Integer");
			else{ //meglio usare un altro modo, altrimenti se sbaglio colonna mi richiede anche la riga
				System.out.print("Insert Column: ");
				String columnInput = getInput(scanner);
				if(!validColumn(columnInput))
					System.out.println("Invalid input. Please digit a valid Character");
				else{
					row = BOARD_SIZE - Integer.valueOf(rowInput);				
					char c = columnInput.charAt(0);
					column = Math.abs(c-'A');
					System.out.println("Position: " + rowInput + ", " + c);
					gameBoard.putAStone(row, column);
				}
			}
        }
        scanner.close();
    }
	
	public String getInput(Scanner scanner){
		String tmp = scanner.nextLine().trim();
		String input = tmp.toUpperCase();		
		return input;
	}
	
	public boolean validRow(String rowInput){
		boolean b = true;
		if(rowInput.equalsIgnoreCase(exitCommand)) 
			b = true;
		else{
			try{
				int r = Integer.parseInt(rowInput);
				if(r > 0 && r <= BOARD_SIZE)
					b = true;
				else b = false;
			}
			catch(NumberFormatException error){
				b = false;
			}
		}
		return b;
	}
	
	public boolean validColumn(String columnInput){
		boolean b = true;
		if(columnInput.length()>1)
			b = false;
		else{
			char c = columnInput.charAt(0);
			if(c<FIRST_LETTER || c>=LAST_LETTER)
				b = false;
		}
		return b;
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
    }

    public void displayAxes() {
		char[] axes = new char[BOARD_SIZE];;
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
