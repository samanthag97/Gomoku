public class Gomoku {

    public static void main(String[] args) {
        //Game game = new Game();
		System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("This is the board:");		
        GameBoard game = new GameBoard();
        game.start();
    }
}

