import java.util.Scanner;

class Game {

    //maybe we put here the hasWon ecc.?
    private int row;
    private int column;

    public Game() {
        //maybe we put here the hasWon ecc.?
    }

    public void start() {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[,.; \\n]+"); //one or more commas, dots, semicolons, whitespaces and or enters
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");
        board.displayBoard();
        while(!board.getHasWon()){ //until someone wins, it repeats
            board.printWhoIsNext();
            System.out.println("Enter your move (row and column): ");
            row = scanner.nextInt();
            column = scanner.nextInt();
            board.putAStone(row,column);
        }
        scanner.close();
    }

}
