public class Gomoku {

    public static void main(String[] args) {
        System.out.println("Hi! This is a Gomoku game.");
        System.out.println("The first player to put five stones in a row wins!");
        System.out.println("Let's start!");
        GameBoard gameBoard = new GameBoard();
        Game game = new Game(gameBoard);
        game.start();
    }
}

