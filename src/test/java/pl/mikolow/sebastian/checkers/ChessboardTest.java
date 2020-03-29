package pl.mikolow.sebastian.checkers;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

import pl.mikolow.sebastian.checkers.*;

import java.util.Map;

/**
 * Created by Sebastian on 25.03.2020
 */
public class ChessboardTest {
    Chessboard chessboard;
    @BeforeEach
    void initial() {
        chessboard = new Chessboard();
        chessboard.initialBoard();
    }

    @Test
    @DisplayName("Should return true if you win")
    void shouldReturnTrueIfWin() {
        assertTrue(chessboard.checkWin(PawnEnum.BLACK_QUEEN));
        assertTrue(chessboard.checkWin(PawnEnum.WHITE_QUEEN));
    }

    @Test
    @DisplayName("Should return false if You don't win")
    void shouldReturnFalseIfYouDoNotWin() {
        assertFalse(chessboard.checkWin(PawnEnum.BLACK_PAWN));
        assertFalse(chessboard.checkWin(PawnEnum.BLACK_PAWN, PawnEnum.BLACK_QUEEN));
        assertFalse(chessboard.checkWin(PawnEnum.WHITE_PAWN));
        assertFalse(chessboard.checkWin(PawnEnum.WHITE_PAWN, PawnEnum.WHITE_QUEEN));
    }

    @Test
    @DisplayName("Should show correct first view of the chessboard")
    void shouldReturnTrueIfCorrectFirstViewChessboard() {
        assertEquals(new StringBuilder("\n1 \u25AD\u265F\u25AD\u265F\u25AD\u265F\u25AD\u265F\n" +
                "2 \u265F\u25AD\u265F\u25AD\u265F\u25AD\u265F\u25AD\n" +
                "3 \u25AD\u265F\u25AD\u265F\u25AD\u265F\u25AD\u265F\n" +
                "4 \u26CB\u25AD\u26CB\u25AD\u26CB\u25AD\u26CB\u25AD\n" +
                "5 \u25AD\u26CB\u25AD\u26CB\u25AD\u26CB\u25AD\u26CB\n" +
                "6 \u2659\u25AD\u2659\u25AD\u2659\u25AD\u2659\u25AD\n" +
                "7 \u25AD\u2659\u25AD\u2659\u25AD\u2659\u25AD\u2659\n" +
                "8 \u2659\u25AD\u2659\u25AD\u2659\u25AD\u2659\u25AD\n" +
                " \u25ABA\u25ABB\u25ABC\u25ABD\u25ABE\u25ABF\u25ABG\u25ABH"),
                chessboard.printCheckersBoard());
    }

    @Test
    void shouldReturnTrueIfFieldIsEmpty() {
        assertTrue(chessboard.getChessBoardMap().get(BoardEnum.valueOf("A4")).equals(PawnEnum.BLACK_CHESSBOARD_FIELD));
    }

    @Test
    @DisplayName("Should return true if range of the pawn's move is allowed")
    void shouldReturnTrueIfMoveRangedIsAllowed() {
        assertTrue(chessboard.checkAllowedMove("B3 A4"));
        assertTrue(chessboard.checkAllowedMove("B3 A4 B5"));
    }

    @Test
    @DisplayName("Should return true if range of the queen's move is allowed")
    void shouldReturnTrueIfQueensMoveRangedIsAllowed() {
        chessboard.getChessBoardMap().put(BoardEnum.B3, PawnEnum.WHITE_QUEEN);
        assertTrue(chessboard.checkAllowedMove("B3 A4"));
        assertTrue(chessboard.checkAllowedMove("B3 D5"));
    }

    @Test
    @DisplayName("Should return false if range of the pawn's move is not allowed")
    void shouldReturnFalseIfMoveRangedINotAllowed() {
        assertFalse(chessboard.checkAllowedMove("B3 A2"));
        assertFalse(chessboard.checkAllowedMove("B3 A4 B3"));
    }

    @Test
    @DisplayName("Should return true if player take his pawn and put on empty field")
    void shouldReturnTrueIfPlayerTakeHisPawnAndPutOnEmptyField() {
        assertTrue(chessboard.checkStartPointAndEndPoint("B3 A4", PawnEnum.WHITE_PAWN, PawnEnum.WHITE_QUEEN));
        assertTrue(chessboard.checkStartPointAndEndPoint("B3 A4 B5", PawnEnum.WHITE_PAWN, PawnEnum.WHITE_QUEEN));
        assertTrue(chessboard.checkStartPointAndEndPoint("B3 A4 B5 C4", PawnEnum.WHITE_PAWN, PawnEnum.WHITE_QUEEN));
    }

    @Test
    @DisplayName("Should return false if player take his pawn and put on not empty field")
    void shouldReturnFalseIfPlayerTakeHisPawnAndPutOnNotEmptyField() {
        assertFalse(chessboard.checkStartPointAndEndPoint("B3 A4 B5 D6", PawnEnum.WHITE_PAWN, PawnEnum.WHITE_QUEEN));
    }

    @Test
    @DisplayName("Should return false if player take not his pawn")
    void shouldReturnFalseIfPlayerTakeNotHisPawnAndPutOnEmptyField() {
        assertFalse(chessboard.checkStartPointAndEndPoint("A2 D1", PawnEnum.BLACK_PAWN, PawnEnum.BLACK_QUEEN));
    }

    @Test
    @DisplayName("Should return true if player attack opponent pawn with pawn")
    void shouldReturnTrueIfPlayerAttackOpponent() {
        chessboard.getChessBoardMap().put(BoardEnum.C4, PawnEnum.BLACK_PAWN);
        chessboard.getChessBoardMap().put(BoardEnum.E4, PawnEnum.BLACK_PAWN);
        assertTrue(chessboard.checkOpponentPawn("B3 D5 F3", PawnEnum.WHITE_PAWN, PawnEnum.WHITE_QUEEN));
    }

    @Test
    @DisplayName("Should return false if player wants attack empty field")
    void shouldReturnFalseIfPlayerAttacksEmptyField() {
        chessboard.getChessBoardMap().put(BoardEnum.C4, PawnEnum.BLACK_PAWN);
        assertFalse(chessboard.checkOpponentPawn("B3 D5 F3", PawnEnum.WHITE_PAWN, PawnEnum.WHITE_PAWN));
    }

    @Test
    @DisplayName("Should return true if queen attacks opponent pawn")
    void shouldReturnTrueIfQueenAttacksOpponentPawn() {
        chessboard.getChessBoardMap().put(BoardEnum.B3, PawnEnum.WHITE_QUEEN);
        chessboard.getChessBoardMap().put(BoardEnum.D5, PawnEnum.BLACK_PAWN);
        chessboard.getChessBoardMap().put(BoardEnum.E6, PawnEnum.BLACK_CHESSBOARD_FIELD);
        assertTrue(chessboard.checkOpponentPawn("B3 E6"));
    }

    @Test
    @DisplayName("Should return false if queen attacks opponent pawn")
    void shouldReturnFalseIfQueenNotAttacksOpponentPawn() {
        chessboard.getChessBoardMap().put(BoardEnum.B3, PawnEnum.WHITE_QUEEN);
        chessboard.getChessBoardMap().put(BoardEnum.D5, PawnEnum.BLACK_PAWN);
        chessboard.getChessBoardMap().put(BoardEnum.E6, PawnEnum.BLACK_CHESSBOARD_FIELD);
        assertFalse(chessboard.checkOpponentPawn("B3 E6 G4"));
    }

    @Test
    @DisplayName("Should return true if the chessboard is correct updated after player move")
    void shouldReturnTrueIfChessboardIsCorrectUpdated() {
        chessboard.updateChessboard("B3 C4", PawnEnum.WHITE_QUEEN);
        assertEquals(PawnEnum.BLACK_CHESSBOARD_FIELD, chessboard.getChessBoardMap().get(BoardEnum.B3));
        chessboard.getChessBoardMap().put(BoardEnum.A6, PawnEnum.WHITE_PAWN);
        chessboard.updateChessboard("A6 C8", PawnEnum.WHITE_QUEEN);
        assertEquals(PawnEnum.WHITE_QUEEN, chessboard.getChessBoardMap().get(BoardEnum.C8));
    }
}
