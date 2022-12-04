package edu.bht.ccdttt.data;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameBoardTest {

    @Test
    public void testGameBoard() {

        GameBoard gameBoardUnderTest = new GameBoard();

        //Test size of cell map
        assertThat(gameBoardUnderTest.getGameBoardCells().size(), is(9));

        //Test empty values/labels of new cell map
        assertThat(gameBoardUnderTest.getGameBoardCells(), IsMapContaining.hasEntry(1, GameBoard.CELL.EMPTY));
        assertThat(gameBoardUnderTest.getGameBoardCells().get(1).label, is(" "));
        assertThat(gameBoardUnderTest.getGameBoardCells(), IsMapContaining.hasEntry(9, GameBoard.CELL.EMPTY));
        assertThat(gameBoardUnderTest.getGameBoardCells().get(9).label, is(" "));
    }
}
