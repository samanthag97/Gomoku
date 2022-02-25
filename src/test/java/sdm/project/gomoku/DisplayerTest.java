package sdm.project.gomoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DisplayerTest {

    @Test
    public void stoneAtRow10ColumnH() {
        GameBoard board = new GameBoard();
        PrintStream old = System.out;
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        System.setOut(new PrintStream(b));

        board.putAStone(5, 7);

        System.setOut((old));
        String output = new String(b.toByteArray());
        
        String expected = System.lineSeparator() + "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  " + System.lineSeparator() +
                " 15  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  15" + System.lineSeparator() +
                " 14  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  14" + System.lineSeparator() +
                " 13  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  13" + System.lineSeparator() +
                " 12  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  12" + System.lineSeparator() +
                " 11  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  11" + System.lineSeparator() +
                " 10  +  +  +  +  +  +  +  B  +  +  +  +  +  +  +  10" + System.lineSeparator() +
                "  9  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  9" + System.lineSeparator() +
                "  8  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  8" + System.lineSeparator() +
                "  7  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  7" + System.lineSeparator() +
                "  6  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  6" + System.lineSeparator() +
                "  5  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  5" + System.lineSeparator() +
                "  4  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  4" + System.lineSeparator() +
                "  3  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  3" + System.lineSeparator() +
                "  2  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  2" + System.lineSeparator() +
                "  1  +  +  +  +  +  +  +  +  +  +  +  +  +  +  +  1" + System.lineSeparator() +
                "     A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  " + System.lineSeparator() + System.lineSeparator();

        Assertions.assertEquals(expected, output);
    }
}
