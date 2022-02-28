package sdm.project.gomoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PutStone {

    @Test
    public void atRow10ColumnH() {
        GameBoard gameBoard = new GameBoard();
        PrintStream oldOutput = System.out;
        ByteArrayOutputStream fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));

        gameBoard.putAStone(5, 7);

        System.setOut((oldOutput));
        String outputString = fakeOutput.toString();

        String expected = """

                     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O \s
                 15  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15
                 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14
                 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13
                 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12
                 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11
                 10  +  +  +  +  +  +  +  B  +  +  +  +  +  +  +  10
                  9  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  9
                  8  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  8
                  7  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  7
                  6  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  6
                  5  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  5
                  4  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  4
                  3  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  3
                  2  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  2
                  1  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  1
                     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O \s

                """;

        Assertions.assertEquals(expected, outputString);

    }

    @Test
    public void atRow15ColumnA() {
        GameBoard gameBoard = new GameBoard();
        PrintStream oldOutput = System.out;
        ByteArrayOutputStream fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));

        gameBoard.putAStone(0, 0);

        System.setOut((oldOutput));
        String outputString = fakeOutput.toString();

        String expected = """

                     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O \s
                 15  B  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15
                 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14
                 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13
                 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12
                 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11
                 10  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  10
                  9  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  9
                  8  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  8
                  7  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  7
                  6  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  6
                  5  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  5
                  4  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  4
                  3  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  3
                  2  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  2
                  1  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  1
                     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O \s

                """;

        Assertions.assertEquals(expected, outputString);

    }

    @Test
    public void atRow1ColumnO() {
        GameBoard gameBoard = new GameBoard();
        PrintStream oldOutput = System.out;
        ByteArrayOutputStream fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));

        gameBoard.putAStone(14, 14);

        System.setOut((oldOutput));
        String outputString = fakeOutput.toString();

        String expected = """

                     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O \s
                 15  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15
                 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14
                 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13
                 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12
                 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11
                 10  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  10
                  9  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  9
                  8  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  8
                  7  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  7
                  6  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  6
                  5  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  5
                  4  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  4
                  3  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  3
                  2  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  2
                  1  +  +  +  +  +  +  +  +  +  +  +  +  +  +  B  1
                     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O \s

                """;

        Assertions.assertEquals(expected, outputString);

    }
}
