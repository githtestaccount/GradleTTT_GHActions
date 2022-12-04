package edu.bht.ccdttt.application;

import edu.bht.ccdttt.data.GameBoard;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.apache.commons.text.StringSubstitutor.*;

public class GameBoardDrawer {

    private GameBoardDrawer() {
        throw new IllegalStateException("Utility Class, no instantiation!");
    }

    //draw game board with all cells status
    static void drawGameBoard(GameBoard currentGameBoard) {
        Map<String, String> displayMap;
        displayMap = new HashMap<>();
        for (Map.Entry<Integer, GameBoard.CELL> entry : currentGameBoard.getGameBoardCells().entrySet()) {
            displayMap.put(String.valueOf(entry.getKey()), entry.getValue().label);
        }
        draw(displayMap);
    }

    //draw game board indices for instructions
    static void drawGameBoardIndices(GameBoard currentGameBoard) {
        Map<String, String> displayMap;
        displayMap = new HashMap<>();
        for (Map.Entry<Integer, GameBoard.CELL> entry : currentGameBoard.getGameBoardCells().entrySet()) {
            String index = String.valueOf(entry.getKey());
            displayMap.put(index, index);
        }
        draw(displayMap);
    }

    static void draw(Map<String, String> displayMap) {

        out.println();
        out.println("     |     |");
        out.println(replace("  ${7}  |  ${8}  |  ${9}", displayMap));
        out.println("_____|_____|_____");
        out.println(replace("  ${4}  |  ${5}  |  ${6}", displayMap));
        out.println("_____|_____|_____");
        out.println("     |     |");
        out.println(replace("  ${1}  |  ${2}  |  ${3}", displayMap));
        out.println("     |     |");
        out.println();
    }
}
