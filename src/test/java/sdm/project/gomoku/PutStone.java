package sdm.project.gomoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class PutStone {

    private static final String row10columnH = """

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
    private static final String row15columnA = """

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

    private static final String row1ColumnO = """

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


    public static Stream<Arguments> generateParameters() {
        return Stream.of(
                Arguments.of(row10columnH, 5, 7),
                Arguments.of(row15columnA, 0, 0),
                Arguments.of(row1ColumnO, 14, 14));
    }

    @ParameterizedTest
    @MethodSource("generateParameters")
    public void atSpecifiedCoordinates(String expectedBoard, int row, int column) {
        GameBoard gameBoard = new GameBoard();
        PrintStream oldOutput = System.out;
        ByteArrayOutputStream fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));

        gameBoard.putAStone(row, column);

        System.setOut((oldOutput));
        String outputString = fakeOutput.toString();
        Assertions.assertEquals(expectedBoard, outputString);
    }

}
