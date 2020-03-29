package pl.mikolow.sebastian.checkers;

/**
 * Enum class with checkers pieces.
 */
public enum PawnEnum {
    WHITE_PAWN('\u265F', new int[]{-22, -18, 9, 11, 18, 22}, 1, new int[]{81, 83, 85, 87}),
    BLACK_PAWN('\u2659', new int[]{22, 18, -9, -11, -18, -22},1, new int[]{12, 14, 16, 18}),
    WHITE_QUEEN('\u265B', new int[]{-66, -55, -44, -33, -22, -11, -63, -54, -45, -36, -27, -18, -9, 9, 18, 27, 36, 45
            , 54, 63, 11, 22, 33, 44, 55, 66}, 2, new int[]{0}),
    BLACK_QUEEN('\u2655', new int[]{-66, -55, -44, -33, -22, -11, -63, -54, -45, -36, -27, -18, -9, 9, 18, 27, 36, 45
            , 54, 63, 11, 22, 33, 44, 55, 66}, 2, new int[]{0}),
    WHITE_CHESSBOARD_FIELD('\u25AD', new int[]{0}, 0, new int[]{0}),
    BLACK_CHESSBOARD_FIELD('\u26CB', new int[]{0}, 0, new int[]{0});

    private final char pawnAndBoardSymbol;
    private final int[] allowedMove;
    private final int pawnRanged;
    private final int[] queenRow;

    PawnEnum(char pawnAndBoardSymbol, int[] allowedMove, int pawnRanged, int[] queenRow) {
        this.pawnAndBoardSymbol = pawnAndBoardSymbol;
        this.allowedMove = allowedMove;
        this.pawnRanged = pawnRanged;
        this.queenRow = queenRow;
    }

    /**
     * Method used to get symbols of checkers pieces and chessboard fields.
     * @return The symbol of checkers pieces or chessboard fields
     */
    public char getPawnAndBoardSymbol() {
        return pawnAndBoardSymbol;
    }

    public int[] getAllowedMove() {
        return allowedMove;
    }

    public int getPawnRanged() {
        return pawnRanged;
    }

    public int[] getQueenRow() {
        return queenRow;
    }

    @Override
    public String toString() {
        return "" + pawnAndBoardSymbol;
    }

}
