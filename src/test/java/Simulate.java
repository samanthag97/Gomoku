import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

public class Simulate {

    @ParameterizedTest
    @ValueSource(strings = {"1\n 2\n 3\n 3\n 1\n 4\n 4\n 4 \n1 \n3\n 5\n 5\n 1\n 5\n 6\n 6\n 1\n 6\n 7\n 7\n",  //row
            "1\n 2\n 3\n 3 \n1 \n4\n 4\n 3\n 1\n 3\n 2\n 3\n 1\n 8\n 5\n 3\n 6\n 6\n 6\n 3\n",  //column
            "1 \n2\n 4\n 6\n 2\n 3\n 6\n 8\n 5\n 6\n 9\n 10\n 4\n 5\n 13\n 6\n 7\n 8\n 1\n 15\n 3\n 4\n",   //diagonal
            "2 \n1 \n4 \n6 \n3 \n2 \n6 \n8 \n6 \n5 \n9 \n10\n 5\n 4\n 13\n 6 \n4 \n3\n",    //diagonal
            "4\n 6\n 2 \n12\n 6\n 7\n 4\n 10 \n9\n 10\n 3\n 11\n 13\n 6\n 5\n 9\n 1\n 1\n 6\n 8\n", //diagonal
            "4\n 6\n 5\n 12\n 6\n 8\n 7\n 10\n 9 \n10\n 6\n 11\n 13\n 6\n 8\n 9\n 1 \n1\n9\n 8\n"   //diagonal
    }) //6 games
    public void winningGames(String gameMoves){
        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);
        Game game = new Game();
        game.start();
    }

    @Test
    public void drawGame() {
        StringBuilder sb = new StringBuilder();
        for (int row = 1; row <= 15; row++) {
            for (int column = 1; column <= 15; column = column + 2) {
                sb.append(row + "\n" + column + "\n");
            }
            for (int column = 2; column <= 15; column = column + 2) {
                sb.append(row + "\n" + column + "\n");
            }
        }
        String gameMoves = sb.toString();

        ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
        System.setIn(fakeInput);

        Game game = new Game();
        game.start();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1\n 2\n 3\n 3 \n1 \n3\n 4\n 4 \n1\n 4\n 5\n 5\n 1\n 6 \n6\n 6\n 1\n 7\n 7\n 8\n 1\n 5\n",  //row
            "1\n 2\n 3\n 3\n 2\n 2 \n4\n 4 \n3 \n2 \n5\n 5\n 6\n 2\n 6\n 6\n 5\n 2\n 7\n 8\n 4\n 2\n",  //column
            "1\n 1\n 6\n 8\n 2\n 2 \n5\n 8\n 4\n 4\n 5\n 6 \n5 \n5 \n9 \n9\n 6\n 6\n 7\n 9\n 3\n 3\n",  //diagonal
            "15\n 1\n 6\n 8\n 14 \n2 \n5\n 8\n 12\n 4\n 5\n 6\n 11\n 5\n 9\n 9\n 10\n 6\n 7\n 9\n 13\n 3\n" //diagonal
    })  //4 games
    public void notWinningOverlines(String gameMoves){
        Exception exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
            System.setIn(fakeInput);
            Game game = new Game();
            game.start();
        });
        Assertions.assertEquals("No line found", exception.getMessage());
    }

}
