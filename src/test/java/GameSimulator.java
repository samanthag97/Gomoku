import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameSimulator {

    @Test
    public void gameWithBlackRowWinner() {
        String gameMoves = "1 2 3 3 1 3 4 4 1 4 5 5 1 5 6 6 1 6 7 7";
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

}
