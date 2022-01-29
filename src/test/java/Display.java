import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Display {

    @Test
    public void blackStoneAtRow5Column7() {
        Board board = new Board();
        board.putAStone(5, 7);
        char[] row = board.getRow(4); //row 5 has index 4 because we start from 0
        char[] expected = {'+', '+', '+', '+', '+', '+', 'B', '+', '+', '+', '+', '+', '+', '+', '+'}; //B is 7th
        assertArrayEquals(expected, row);
    }
}
