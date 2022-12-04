package edu.bht.ccdttt.application;

import edu.bht.ccdttt.data.GameBoard;
import edu.bht.ccdttt.data.GameBoard.PLAYER_SYMBOL;

import java.util.HashSet;

public class GameBoardRules {

    private GameBoardRules() {
        throw new IllegalStateException("Constant Class, no instantiation!");
    }

    public static boolean checkWinner(GameBoard gameBoard, PLAYER_SYMBOL currentPlayer) {
        for (HashSet<Integer> fullRow : GameBoard.POSSIBLE_FULL_ROWS) {
            if (gameBoard.getPlayerMoves().get(currentPlayer).containsAll(fullRow)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkTie(GameBoard gameBoard) {
        return gameBoard.getPlayerMoves().get(PLAYER_SYMBOL.X).size() +
                gameBoard.getPlayerMoves().get(PLAYER_SYMBOL.O).size() == 9;
    }
}
