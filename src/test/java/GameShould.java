
import com.asos.katas.Board;
import com.asos.katas.Game;
import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameShould {

    @Test
    @Description("When player x turn, place an 'X' on the specified board location")
    public void whenPlayerXTurn_ThenPlaceXAtLocation() {
        Game game = new Game();
        game.play(1,1);
        String selectedCell = game.getCellValue(1,1);
        assertEquals("X", selectedCell);
    }

    @Test
    @Description("Not allow a player to place a counter on a square that is already taken")
    public void

    @Test
    public void letPlayerXGoFirst() {
        Game game = new Game();
        game.play(1, 1);
        String actualPlayerTurn = game.getNextPlayer();

        assertEquals("X", actualPlayerTurn);
    }

    @Test
    public void letPlayerYGoSecond() {
        Game game = new Game();

        game.play(1, 1);
        game.play(1, 1);
        String actualPlayerTurn = game.getNextPlayer();
        assertEquals("Y", actualPlayerTurn);
    }

    @Test
    @Description("should be player x turn after 5 turns")
    public void bePlayerXTurnAfter5Turns() {
        Game game = new Game();

        game.play(1, 1);
        game.play(1, 1);
        game.play(1, 1);
        game.play(1, 1);
        game.play(1, 1);
        String actualPlayerTurn = game.getNextPlayer();
        assertEquals("X", actualPlayerTurn);
    }

    @Test
    @Description("given I have a 3 x 3 board, when I have played 3 moves, then there should be 6 moves left")
    public void have_SixTurnsLeft_AfterThreeMoves_WhenBoardIs3x3() {
        //at this point we needed to add a board to the game.
        Game game = new Game(new Board(3));
        game.play(1, 1);
        game.play(1, 1);
        game.play(1, 1);
        int remainingMoves = game.countRemainingMoves();
        assertEquals(6, remainingMoves);
    }

    @Test
    @Description("given I have a 3 x 3 board, when I have played 5 moves, then there should be 4 moves left")
    public void have_FourTurnsLeft_AfterFiveMoves_WhenBoardIs3x3() {
        //at this point we needed to add a board to the game.
        Game game = new Game(new Board(3));
        for (int i = 0; i < 5; i++) {
            game.play(1, 1);
        }
        int remainingMoves = game.countRemainingMoves();
        assertEquals(4, remainingMoves);
    }

    @Test
    @Description("Game should be over when all remaining moves played")
    public void beOver_WhenZero_RemainingMoves() {
        Game game = new Game(new Board(3));
        for (int i = 0; i < 9; i++) {
            game.play(1, 1);
        }
        assertEquals(0,game.countRemainingMoves());
        assertTrue(game.isOver());
    }

    @Test
    @Description("Game should NOT be over when there are still remaining moves to be played")
    public void notBeOver_WhenThereAreRemainingMoves() {
        Game game = new Game(new Board(3));
        for (int i = 0; i < 8; i++) {
            game.play(1, 1);
        }
        assertFalse(game.isOver());
    }
}
