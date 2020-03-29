package pl.mikolow.sebastian.checkers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by Sebastian on 24.03.2020
 * The class used to initial first view of chessboard with pawns and chessboard fields and
 * to draw the chessboard on the console.
 */
public class Chessboard {

    private StringBuilder boardBuilder;
    private Map<BoardEnum, PawnEnum> chessBoardMap;

    /**
     * The method initials the chessboard with all fields and shows first view of chessboard.
     */
    public void initialBoard() {
        chessBoardMap = new EnumMap<>(BoardEnum.class);

        chessBoardMap.put(BoardEnum.A1, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.B1, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.C1, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.D1, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.E1, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.F1, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.G1, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.H1, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.A2, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.B2, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.C2, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.D2, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.E2, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.F2, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.G2, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.H2, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.A3, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.B3, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.C3, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.D3, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.E3, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.F3, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.G3, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.H3, PawnEnum.WHITE_PAWN);
        chessBoardMap.put(BoardEnum.A4, PawnEnum.BLACK_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.B4, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.C4, PawnEnum.BLACK_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.D4, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.E4, PawnEnum.BLACK_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.F4, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.G4, PawnEnum.BLACK_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.H4, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.A5, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.B5, PawnEnum.BLACK_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.C5, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.D5, PawnEnum.BLACK_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.E5, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.F5, PawnEnum.BLACK_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.G5, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.H5, PawnEnum.BLACK_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.A6, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.B6, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.C6, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.D6, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.E6, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.F6, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.G6, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.H6, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.A7, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.B7, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.C7, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.D7, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.E7, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.F7, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.G7, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.H7, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.A8, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.B8, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.C8, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.D8, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.E8, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.F8, PawnEnum.WHITE_CHESSBOARD_FIELD);
        chessBoardMap.put(BoardEnum.G8, PawnEnum.BLACK_PAWN);
        chessBoardMap.put(BoardEnum.H8, PawnEnum.WHITE_CHESSBOARD_FIELD);
    }

    /**
     * The method used the print pawns position on chessboard
     *
     * @return string with pawns and chessboard fields
     */
    public StringBuilder printCheckersBoard() {
        boardBuilder = new StringBuilder();
        chessBoardMap.forEach((key, value) -> {
            if ((key.ordinal() % 8) == 0) {
                boardBuilder.append("\n");
                boardBuilder.append(key.ordinal() / 8 + 1).append(" ");
            }
            boardBuilder.append(value.getPawnAndBoardSymbol());
        });
        boardBuilder.append("\n \u25ABA\u25ABB\u25ABC\u25ABD\u25ABE\u25ABF\u25ABG\u25ABH");
        return boardBuilder;
    }

    /**
     * The method used to check if the player won.
     * When opponent doesn't have any pawns, the player win the game.
     *
     * @param opponentPawns array of the opponent's pawns, in this game is pawn and queen
     * @return <code>true</code> if opponent has not any elements on the board.
     */
    public boolean checkWin(PawnEnum... opponentPawns) {
        for (PawnEnum opponent : opponentPawns) {
            if (chessBoardMap.containsValue(opponent))
                return false;
        }
        return true;
    }

    /**
     * The method checks that the player takes his pawn.
     *
     * @param playerMove string with fields where player wants to go
     * @param pawn       collection of pawns that player can take
     * @return <code>true</code> if player moves his pawn
     */
    public boolean checkStartPointAndEndPoint(String playerMove, PawnEnum... pawn) {
        StringBuilder trueOrFalse = new StringBuilder();
        String[] startAndEndPoint = playerMove.split(" ");
        for (PawnEnum pawnEnum : pawn) {
            if (chessBoardMap.get(BoardEnum.valueOf(startAndEndPoint[0])).equals(pawnEnum)) {
                for (int i = 1; i < startAndEndPoint.length; i++) {
                    if (chessBoardMap.get(BoardEnum.valueOf(startAndEndPoint[i])).equals(PawnEnum.BLACK_CHESSBOARD_FIELD)) {
                        trueOrFalse.append("true");
                    } else {
                        trueOrFalse.append("false");
                    }
                }
            }
        }
        return !trueOrFalse.toString().contains("false") && trueOrFalse.toString().contains("true");
    }

    /**
     * The method checks that player's move is allowed
     *
     * @param playerMove string with start and end fields
     * @return <code>true</code> if move is allowed
     */

    public boolean checkAllowedMove(String playerMove) {
        StringBuilder allowedMove = new StringBuilder();
        List<Integer> rangedMove = new ArrayList<>();
        String[] movePoint = playerMove.split(" ");
        for (int i = 0; i < movePoint.length - 1; i++) {
            rangedMove.add(BoardEnum.valueOf(movePoint[i + 1]).getFieldPosition() - BoardEnum.valueOf(movePoint[i]).getFieldPosition());
        }
        for (Integer ranged : rangedMove) {
            if (IntStream.of(chessBoardMap.get(BoardEnum.valueOf(movePoint[0])).getAllowedMove()).noneMatch(x -> x == ranged)) {
                allowedMove.append("false");
            } else
                allowedMove.append("true");
        }
        return !allowedMove.toString().contains("false");
    }

    /**
     * The method checks if player can attack opponent.
     *
     * @param playerMove string with player moves
     * @param pawns      all player pawns
     * @return <code>true</code> if player can attack the opponent
     */

    public boolean checkOpponentPawn(String playerMove, PawnEnum... pawns) {
        /*
        Make pattern checks the player move.
         */
        StringBuilder playerPawns = new StringBuilder("[^");
        for (PawnEnum pawn : pawns) {
            playerPawns.append(pawn);
        }
        playerPawns.append("\u25AD\u26CB]");
        Pattern playerPawnPattern = Pattern.compile(String.format("%s", playerPawns.toString())); // pattern for pawn
        Pattern playerQueenPatternWithOpponentPawn = Pattern.compile(String.format("[\u26CB]*%s[\u26CB]*",
                playerPawns.toString())); //pattern for queen when is opponent pawn on the road

        String[] movePoint = playerMove.split(" ");
        List<Integer> opponentPawn = new ArrayList<>(); //list with position of pawn when attack the opponent
        List<Integer> forbiddenMoves = new ArrayList<>(); //list with forbidden moves during attack
        for (int i = 0; i < movePoint.length - 1; i++) {
            int opponentPawnPosition =
                    BoardEnum.valueOf(movePoint[i + 1]).getFieldPosition() - BoardEnum.valueOf(movePoint[i]).getFieldPosition();
            if (opponentPawnPosition > 11 || opponentPawnPosition < -11) {
                opponentPawn.add(opponentPawnPosition);
            } else
                forbiddenMoves.add(opponentPawnPosition);
        }
        for (int i = 0; i < opponentPawn.size(); i++) {
            StringBuilder opponentSign = new StringBuilder();
            int oppoSize = 0;
            if (opponentPawn.get(i) % 9 == 0) {
                oppoSize = 9;
            } else if (opponentPawn.get(i) % 11 == 0) {
                oppoSize = 11;
            }
            for (int a = 1; a < (Math.abs(opponentPawn.get(i)) / oppoSize); a++) {
                opponentSign.append(chessBoardMap.get(
                        (BoardEnum.getValue(BoardEnum.valueOf(movePoint[i]).getFieldPosition() + a * oppoSize * (int) Math.signum(opponentPawn.get(i))))).getPawnAndBoardSymbol());
            }
            if (!opponentPawn.isEmpty() && chessBoardMap.get(BoardEnum.valueOf(movePoint[0])).getPawnRanged() == 1) {
                Matcher pawnMatcher = playerPawnPattern.matcher(opponentSign.toString());
                if (!pawnMatcher.matches() || !forbiddenMoves.isEmpty())
                    return false;
            } else if (!opponentPawn.isEmpty() && chessBoardMap.get(BoardEnum.valueOf(movePoint[0])).getPawnRanged() == 2) {
                Matcher queenMatcherWithOpponentPawn = playerQueenPatternWithOpponentPawn.matcher(opponentSign.toString());
                if (!queenMatcherWithOpponentPawn.matches() || !forbiddenMoves.isEmpty())
                    return false;
            }
        }
        return true;
    }
    
    /**
     * The method make modification of board after player accepted move.
     * @param playerMove string with player moves
     */
    public void updateChessboard(String playerMove, PawnEnum playerQueen) {
        String[] movePoint = playerMove.split(" ");
        List<Integer> pawnRoad = new ArrayList<>();
        for (int i = 0; i < movePoint.length - 1; i++) {
            int opponentPawnPosition =
                    BoardEnum.valueOf(movePoint[i + 1]).getFieldPosition() - BoardEnum.valueOf(movePoint[i]).getFieldPosition();
            if (opponentPawnPosition > 11 || opponentPawnPosition < -11) {
                pawnRoad.add(opponentPawnPosition);
            }
            if(IntStream.of(chessBoardMap.get(BoardEnum.valueOf(movePoint[0])).getQueenRow()).anyMatch(e -> e == (BoardEnum.valueOf(movePoint[movePoint.length - 1]).getFieldPosition()))){
                chessBoardMap.put(BoardEnum.valueOf(movePoint[movePoint.length - 1]), playerQueen);
            } else {
                chessBoardMap.put(BoardEnum.valueOf(movePoint[movePoint.length - 1]), chessBoardMap.get(BoardEnum.valueOf(movePoint[0])));
            }
            chessBoardMap.put(BoardEnum.valueOf(movePoint[0]), PawnEnum.BLACK_CHESSBOARD_FIELD);
        }
        for (int i = 0; i < pawnRoad.size(); i++) {
            int oppoSize = 0;
            if (pawnRoad.get(i) % 9 == 0) {
                oppoSize = 9;
            } else if (pawnRoad.get(i) % 11 == 0) {
                oppoSize = 11;
            }
            for (int a = 1; a < (Math.abs(pawnRoad.get(i)) / oppoSize); a++) {
                chessBoardMap.put(BoardEnum.getValue(BoardEnum.valueOf(movePoint[i]).getFieldPosition() + a * oppoSize * (int) Math.signum(pawnRoad.get(i))), PawnEnum.BLACK_CHESSBOARD_FIELD);
            }
        }
    }

    public Map<BoardEnum, PawnEnum> getChessBoardMap() {
        return chessBoardMap;
    }
}
