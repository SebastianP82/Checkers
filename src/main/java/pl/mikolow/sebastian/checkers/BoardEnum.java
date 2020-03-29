package pl.mikolow.sebastian.checkers;

/**
 * Enum class with chessboard fields
 */
public enum BoardEnum {
    A1(11),
    B1(12),
    C1(13),
    D1(14),
    E1(15),
    F1(16),
    G1(17),
    H1(18),
    A2(21),
    B2(22),
    C2(23),
    D2(24),
    E2(25),
    F2(26),
    G2(27),
    H2(28),
    A3(31),
    B3(32),
    C3(33),
    D3(34),
    E3(35),
    F3(36),
    G3(37),
    H3(38),
    A4(41),
    B4(42),
    C4(43),
    D4(44),
    E4(45),
    F4(46),
    G4(47),
    H4(48),
    A5(51),
    B5(52),
    C5(53),
    D5(54),
    E5(55),
    F5(56),
    G5(57),
    H5(58),
    A6(61),
    B6(62),
    C6(63),
    D6(64),
    E6(65),
    F6(66),
    G6(67),
    H6(68),
    A7(71),
    B7(72),
    C7(73),
    D7(74),
    E7(75),
    F7(76),
    G7(77),
    H7(78),
    A8(81),
    B8(82),
    C8(83),
    D8(84),
    E8(85),
    F8(86),
    G8(87),
    H8(88);

    private final int fieldPosition;

    BoardEnum(int fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public int getFieldPosition() {
        return fieldPosition;
    }

    public static BoardEnum getValue(int value) {
        for(BoardEnum e: BoardEnum.values()) {
            if(e.getFieldPosition() == value) {
                return e;
            }
        }
        return null;// not found
    }
}
