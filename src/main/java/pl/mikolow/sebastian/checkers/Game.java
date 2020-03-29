package pl.mikolow.sebastian.checkers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sebastian on 25.03.2020
 */
@SuppressWarnings("ALL")
public class Game {

    private Chessboard chessboard = null;
    private String playerOne = "";
    private String playerTwo = "";
    private boolean whoPlay = true;
    private boolean checkWinner = false;
    private Pattern patternMove;
    private Matcher matcherMove;

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.welcomeText());
        System.out.println(game.gamesInstruction());

        Scanner in = new Scanner(System.in);
        String move = in.nextLine();
        game.firstTextToStart(move);

    }

    /**
     * This is the welcome text on the start of the game.
     *
     * @return the welcome text with link to the instruction.
     */
    public StringBuilder welcomeText() {
        StringBuilder welcomeText = new StringBuilder("Welcome in Checkers game!!!\n");
        welcomeText.append("This is a simple game for two players.\n");
        welcomeText.append("This game is for amateurs so You have unlimited time for move.\n");
        welcomeText.append("If You don't know rules of the game check this: https://en.wikipedia.org/wiki/Draughts\\.");
        return welcomeText;
    }

    /**
     * This method print text with game's instruction.
     *
     * @return text with instructions on how the player should enter moves,
     * how to exit the program, how to display the instructions and how to start the game.
     */
    public StringBuilder gamesInstruction() {
        StringBuilder instructionText = new StringBuilder("\nI N S T R U C T I O N\n");
        instructionText.append("Player One starts with white pawns.\n");
        instructionText.append("To move the pawn, You should enter the start position and end position, eg. (A6 " +
                "B5)\n");
        instructionText.append("Sometimes You have to make complex move, so You enter all positions where pawn " +
                "should be, eg (A6 B5 C4)\n");
        instructionText.append("If You want exit program, enter 'q' character.\n");
        instructionText.append("If You want display instruction, enter 'i' character.\n");
        instructionText.append("If You want start game, enter 's' character.\n");
        return instructionText;
    }

    /**
     * This method check what player want on start program.
     *
     * @param startText check input in console, <code>e</code> - exit program, <code>i</code> - instruction,
     *                  <code>s</code> - start game
     */
    @SuppressWarnings("IfCanBeSwitch")
    public void firstTextToStart(String startText) {
        //noinspection IfCanBeSwitch
        switch (startText) {
            case "e":
                exitProgram();
                break;
            case "i":
                System.out.println(gamesInstruction());
                break;
            case "s":
                startGame();
                break;
            default:
                return;
        }
    }

    /**
     * The method used to exit program
     */
    public void exitProgram() {
        System.out.println("Bye, bye. See you soon!!!");
        System.exit(0);
    }

    /**
     * The method used to start game.
     */
    public void startGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("Let's play and have fun!!!\n");
        do {
            System.out.println("Who is The Player One:");
            playerOne = in.nextLine();
        }
        while (playerOne.equals(""));
        System.out.println("The Player One is: " + playerOne + ". Your pawns are: " + PawnEnum.WHITE_PAWN.getPawnAndBoardSymbol() +
                " and " + PawnEnum.WHITE_QUEEN.getPawnAndBoardSymbol());
        do {
            System.out.println("Who is The Player Two:");
            playerTwo = in.nextLine();
        }
        while (playerTwo.equals("") || playerTwo.equals(playerOne));

        System.out.println("The Player One is: " + playerTwo + ". Your pawns are: " + PawnEnum.BLACK_PAWN.getPawnAndBoardSymbol() +
                " and " + PawnEnum.BLACK_QUEEN.getPawnAndBoardSymbol());
        chessboard = new Chessboard();
        chessboard.initialBoard();
        System.out.println(chessboard.printCheckersBoard());
        do {
            if (whoPlay) {
                playerMove(playerOne, PawnEnum.WHITE_QUEEN, PawnEnum.WHITE_PAWN, PawnEnum.WHITE_QUEEN);
                checkWinner = chessboard.checkWin(PawnEnum.BLACK_PAWN, PawnEnum.BLACK_QUEEN);
                whoPlay = false;
            } else {
                playerMove(playerTwo, PawnEnum.BLACK_QUEEN, PawnEnum.BLACK_PAWN, PawnEnum.BLACK_QUEEN);
                checkWinner = chessboard.checkWin(PawnEnum.WHITE_PAWN, PawnEnum.WHITE_QUEEN);
                whoPlay = true;
            }
        }
        while (!checkWinner);
        System.out.println("The end game");
    }

    /**
     * The method used to get move form player and checks if that move is accepted.
     *
     * @param playerName player's nick
     * @param pawns      player's pawn
     */
    public void playerMove(String playerName, PawnEnum playerQueen, PawnEnum... pawns) {
        System.out.println(playerName + " move.\n");
        checkPattern(playerQueen, pawns);
    }

    public void checkPattern(PawnEnum playerQueen, PawnEnum... pawns) {
        String playerMove;
        do {
            do {
                Scanner in = new Scanner(System.in);
                playerMove = in.nextLine();
                if (playerMove.equals("e") || playerMove.equals("i") || playerMove.equals("s")) {
                    do {
                        firstTextToStart(playerMove);
                    }
                    while (!in.hasNext());
                }
                patternMove = Pattern.compile("([A-H][1-8])( [A-H][1-8])+");
                matcherMove = patternMove.matcher(playerMove);
                if (!matcherMove.matches()) {
                    System.out.println("This is not a valid entry. Input one more time.");
                }
            }
            while (!matcherMove.matches());
            if (!chessboard.checkStartPointAndEndPoint(playerMove, pawns)) {
                System.out.println("That is not your pawn or destination is not correct.");
            } else if (!chessboard.checkAllowedMove(playerMove)) {
                System.out.println("This move is forbidden");
            } else if (!chessboard.checkOpponentPawn(playerMove, pawns)) {
                System.out.println("You need to attack opponent pawns");
            }
        }
        while (!chessboard.checkStartPointAndEndPoint(playerMove, pawns) || !chessboard.checkAllowedMove(playerMove) || !chessboard.checkOpponentPawn(playerMove, pawns));
        chessboard.updateChessboard(playerMove, playerQueen);
        System.out.println(chessboard.printCheckersBoard());
    }
}


