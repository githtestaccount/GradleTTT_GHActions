package edu.bht.ccdttt.data;

import java.util.*;

public class GameBoard {
    static final int GAME_BOARD_SIZE = 9;

    //three possible states of game board cells: X, O and EMPTY
    public enum CELL {
        X("X"),
        O("O"),
        EMPTY(" ");

        public final String label;
        CELL(String label) {
            this.label = label;
        }
    }

    //two possible Players: X and O
    public enum PLAYER_SYMBOL {
        X("X"),
        O("O");

        public final String label;
        PLAYER_SYMBOL(String label) {
            this.label = label;
        }
    }

    //eight cell combinations are full rows
    public static final HashSet<Integer>[] POSSIBLE_FULL_ROWS = new HashSet[]{
            (HashSet<Integer>) newHashSet(7,8,9),
            (HashSet<Integer>) newHashSet(4,5,6),
            (HashSet<Integer>) newHashSet(1,2,3),
            (HashSet<Integer>) newHashSet(7,4,1),
            (HashSet<Integer>) newHashSet(8,5,2),
            (HashSet<Integer>) newHashSet(9,6,3),
            (HashSet<Integer>) newHashSet(7,5,3),
            (HashSet<Integer>) newHashSet(9,5,1)
    };

    //nine game board cells for board display
    private Map<Integer, CELL> gameBoardCells = new HashMap<>(9, 1.0F);

    //two sets of cell indices to register the players moves
    private Map<PLAYER_SYMBOL, HashSet<Integer>> playerMoves = new EnumMap<>(PLAYER_SYMBOL.class);

    public GameBoard() {
        for (int i = 1; i <= GAME_BOARD_SIZE; i++) {
            this.gameBoardCells.put(i, CELL.EMPTY);
            this.playerMoves.put(PLAYER_SYMBOL.X, new HashSet<>());
            this.playerMoves.put(PLAYER_SYMBOL.O, new HashSet<>());
        }
    }

    public void registerMove(int cellIndex, PLAYER_SYMBOL currentPlayer) {
        CELL cellStatus;
        if (currentPlayer == PLAYER_SYMBOL.X) {
            cellStatus = CELL.X;
        } else {
            cellStatus = CELL.O;
        }
        gameBoardCells.put(cellIndex, cellStatus);
        playerMoves.get(currentPlayer).add(cellIndex);
    }

    public Map<Integer, CELL> getGameBoardCells() {
        return gameBoardCells;
    }

    public Map<PLAYER_SYMBOL, HashSet<Integer>> getPlayerMoves() {
        return playerMoves;
    }

    //helper method
    public static <T> Set<T> newHashSet(T... objs) {
        Set<T> set = new HashSet<T>();
        Collections.addAll(set, objs);
        return set;
    }
}
