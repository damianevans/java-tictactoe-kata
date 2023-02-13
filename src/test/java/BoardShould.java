import com.asos.katas.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardShould {
    @Test
    public void tellUsHowManyTurnsAreAvailableBasedOnSize(){
        Board board = new Board(3);
        int actualNumberOfTurns = board.getMaxTurns();
        assertEquals(9, actualNumberOfTurns);
    }

    @Test
    public void render3x3Board(){
        Board board = new Board(3);
        board.renderBoard();
    }
}
