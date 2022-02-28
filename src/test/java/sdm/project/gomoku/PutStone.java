package sdm.project.gomoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class PutStone {

    private static final String row10columnH = "\n" +
                                               "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  \n" +
                                               " 15  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15\n" +
                                               " 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14\n" +
                                               " 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13\n" +
                                               " 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12\n" +
                                               " 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11\n" +
                                               " 10  +  +  +  +  +  +  +  B  +  +  +  +  +  +  +  10\n" +
                                               "  9  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  9\n" +
                                               "  8  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  8\n" +
                                               "  7  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  7\n" +
                                               "  6  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  6\n" +
                                               "  5  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  5\n" +
                                               "  4  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  4\n" +
                                               "  3  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  3\n" +
                                               "  2  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  2\n" +
                                               "  1  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  1\n" +
                                               "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  \n" +
                                               "\n";
    private static final String row15columnA = "\n" +
                                               "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  \n" +
                                               " 15  B  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15\n" +
                                               " 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14\n" +
                                               " 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13\n" +
                                               " 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12\n" +
                                               " 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11\n" +
                                               " 10  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  10\n" +
                                               "  9  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  9\n" +
                                               "  8  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  8\n" +
                                               "  7  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  7\n" +
                                               "  6  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  6\n" +
                                               "  5  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  5\n" +
                                               "  4  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  4\n" +
                                               "  3  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  3\n" +
                                               "  2  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  2\n" +
                                               "  1  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  1\n" +
                                               "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  \n" +
                                               "\n";

    private static final String row1ColumnO = "\n" +
                                              "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  \n" +
                                              " 15  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15\n" +
                                              " 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14\n" +
                                              " 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13\n" +
                                              " 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12\n" +
                                              " 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11\n" +
                                              " 10  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  10\n" +
                                              "  9  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  9\n" +
                                              "  8  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  8\n" +
                                              "  7  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  7\n" +
                                              "  6  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  6\n" +
                                              "  5  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  5\n" +
                                              "  4  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  4\n" +
                                              "  3  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  3\n" +
                                              "  2  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  2\n" +
                                              "  1  +  +  +  +  +  +  +  +  +  +  +  +  +  +  B  1\n" +
                                              "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  \n" +
                                              "\n";


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
