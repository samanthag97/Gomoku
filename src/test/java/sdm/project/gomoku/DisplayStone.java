package sdm.project.gomoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class DisplayStone {

    private static final String BOARD_10_H = "\n" +
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
    private static final String BOARD_15_A = "\n" +
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

    private static final String BOARD_1_O = "\n" +
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
                Arguments.of(BOARD_10_H, 5, 7),
                Arguments.of(BOARD_15_A, 0, 0),
                Arguments.of(BOARD_1_O, 14, 14));
    }

    @ParameterizedTest
    @MethodSource("generateParameters")
    public void inCorrectPosition(String expectedBoard, int row, int column) {
        GameBoard gameBoard = new GameBoard();
        PrintStream oldOutput = System.out;
        ByteArrayOutputStream fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));

        gameBoard.putAStoneAndPrint(row, column);

        System.setOut((oldOutput));
        String outputString = fakeOutput.toString();
        Assertions.assertEquals(expectedBoard, outputString);
    }

    @Test
    public void withAlternatingColors() {
        String expectedBoards = BOARD_10_H +
                               "\n" +
                               "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  \n" +
                               " 15  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15\n" +
                               " 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14\n" +
                               " 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13\n" +
                               " 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12\n" +
                               " 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11\n" +
                               " 10  +  +  +  +  +  +  +  B  W  +  +  +  +  +  +  10\n" +
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
                               "\n" +
                               "\n" +
                               "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  \n" +
                               " 15  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15\n" +
                               " 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14\n" +
                               " 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13\n" +
                               " 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12\n" +
                               " 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11\n" +
                               " 10  +  +  +  +  +  +  +  B  W  B  +  +  +  +  +  10\n" +
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
        GameBoard gameBoard = new GameBoard();
        PrintStream oldOutput = System.out;
        ByteArrayOutputStream fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));

        gameBoard.putAStoneAndPrint(5, 7);
        gameBoard.putAStoneAndPrint(5, 8);
        gameBoard.putAStoneAndPrint(5, 9);

        System.setOut((oldOutput));
        String outputString = fakeOutput.toString();
        Assertions.assertEquals(expectedBoards, outputString);
    }
}
