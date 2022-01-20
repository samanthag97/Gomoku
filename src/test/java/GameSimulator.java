import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameSimulator {

    //can do a single test that takes all the games one after the other

    @Test
    public void gameWithBlackRowWinner() {
        String gameMoves = "1 2 3 3 1 4 4 4 1 3 5 5 1 5 6 6 1 6 7 7";
        String expectedFinalBoard = "";

        //PrintStream outputBackup = System.out;
        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        //ByteArrayOutputStream fakeOutput = new ByteArrayOutputStream();
        System.setIn(fakeInput);
        //System.setOut(new PrintStream(fakeOutput));

        Game game = new Game();
        game.start();

        //System.setOut(outputBackup);
        //System.out.println("THIS IS IT: \n" + fakeOutput.toString().substring(fakeOutput.toString().lastIndexOf("  +  B  B  B  B  B")));

        //assertEquals(expectedFinalBoard, fakeOutput.toString()); //to try and test the result
    }

    @Test
    public void gameWithWhiteColumnWinner() {
        String gameMoves = "1 2 3 3 1 4 4 3 1 3 2 3 1 8 5 3 6 6 6 3";

        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }

    @Test
    public void gameWithBlackDiagonalWinnerUp() {
        String gameMoves = "1 2 4 6 2 3 6 8 5 6 9 10 4 5 13 6 3 4";

        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }

    @Test
    public void gameWithBlackDiagonalWinnerDown() {
        String gameMoves = "2 1 4 6 3 2 6 8 6 5 9 10 5 4 13 6 4 3";

        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }

    @Test
    public void gameWithWhiteDiagonalWinnerUp() {
        String gameMoves = "4 6 2 12 6 7 4 10 9 10 3 11 13 6 5 9 1 1 6 8";

        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }

    @Test
    public void gameWithWhiteDiagonalWinnerDown() {
        String gameMoves = "4 6 5 12 6 8 7 10 9 10 6 11 13 6 8 9 1 1 9 8";

        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }


    /*TESTS THAT SHOULD FAIL*/
    @Test
    public void gameWith6BlackInARow() { //should fail
        String gameMoves = "1 2 3 3 1 3 4 4 1 4 5 5 1 6 6 6 1 7 7 8 1 5";

        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }

    @Test
    public void gameWith6BlackInColumn() { //should fail
        String gameMoves = "1 2 3 3 2 2 4 4 3 2 5 5 6 2 6 6 5 2 7 8 4 2";

        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }

    @Test
    public void gameWith6BlackInDiagonal() { //should fail
        String gameMoves = "1 1 6 8 2 2 5 8 4 4 5 6 5 5 9 9 6 6 7 9 3 3";
        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }

    @Test
    public void gameWith6BlackInOtherDiagonal() { //should fail
        String gameMoves = "15 1 6 8 14 2 5 8 12 4 5 6 11 5 9 9 10 6 7 9 13 3";
        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }
}
