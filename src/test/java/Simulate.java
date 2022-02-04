import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

public class Simulate {

    @ParameterizedTest
    @ValueSource(strings = {"1\n b\n 3\n c\n 1\n d\n 4\n e \n1 \nc\n 5\n e\n 1\n e\n 6\n f\n 1\n f\n 7\n g\n",  //row
            "1\n b\n 3\n c \n1 \nd\n 4\n c\n 1\n c\n 2\n c\n 1\n h\n 5\n c\n 6\n f\n 6\n c\n",  //column
            "1 \nB\n 4\n F\n 2\n c\n 6\n H\n 5\n f\n 9\n J\n 4\n e\n 13\n f\n 7\n h\n 1\n o\n 3\n d\n",   //diagonal
            "2 \na \n4 \nf \n3 \nB \n6 \nh \n6 \ne \n9 \nj\n 5\n d\n 13\n f \n4 \nc\n",    //diagonal
            "4\n f\n 2 \nL\n 6\n g\n 4\n J \n9\n j\n 3\n k\n 13\n f\n 5\n i\n 1\n a\n 6\n h\n", //diagonal
            "4\n f\n 5\n L\n 6\n h\n 7\n j\n 9 \nj\n 6\n k\n 13\n f\n 8\n i\n 1 \na\n9\n h\n"   //diagonal
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
        for (char column = 'A'; column <= 'O'; column++) {
            for (int row = 1; row <= 15; row = row + 2) {
                sb.append(row + "\n" + column + "\n");
            }
            for (int row = 2; row <= 15; row = row + 2) {
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
    @ValueSource(strings = {"1\n b\n 3\n c \n1 \nc\n 4\n d \n1\n d\n 5\n e\n 1\n f \n6\n f\n 1\n g\n 7\n h\n 1\n e\n",  //row
            "1\n b\n 3\n c\n 2\n b \n4\n d \n3 \nb \n5\n e\n 6\n b\n 6\n f\n 5\n b\n 7\n h\n 4\n b\n",  //column
            "1\n a\n 6\n h\n 2\n b \n5\n h\n 4\n d\n 5\n f \n5 \ne \n9 \ni\n 6\n f\n 7\n i\n 3\n c\n",  //diagonal
            "15\n a\n 6\n h\n 14 \nb \n5\n h\n 12\n d\n 5\n f\n 11\n e\n 9\n i\n 10\n f\n 7\n i\n 13\n c\n" //diagonal
    })  //4 games
    public void notWinningOverlines(String gameMoves){
        Exception exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            ByteArrayInputStream fakeInput = new ByteArrayInputStream(gameMoves.getBytes());
            System.setIn(fakeInput);
            Game game = new Game();
            game.start();
        });
        Assertions.assertEquals(null, exception.getMessage());
    }

}
