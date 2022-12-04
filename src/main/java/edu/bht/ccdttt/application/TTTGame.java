package edu.bht.ccdttt.application;

import edu.bht.ccdttt.data.GameBoard;
import edu.bht.ccdttt.data.GameBoard.PLAYER_SYMBOL;

import java.util.Random;

import static java.lang.System.out;

public class TTTGame {
    public static void main(String[] args) {

        //print instructions banner once
        out.println();
        out.println("Tic Tac Toe console game");
        out.println();
        out.println("Instructions:");
        out.println("Player X and Player Y may use \nthe numpad to make a move");

        //start game
        while(InputValidator.askForNewGame()) {

            //choose randomly which player gets the first move
            PLAYER_SYMBOL[] players;
            players = GameBoard.PLAYER_SYMBOL.values();
            int randomNum = new Random().nextInt(players.length);
            PLAYER_SYMBOL currentPlayer = players[randomNum];

            GameBoard gameBoard = new GameBoard();
            InputValidator input = new InputValidator(gameBoard);
            GameBoardDrawer.drawGameBoardIndices(gameBoard);

            //game loop
            while(true) {
                int nextMove = input.getPlayerNextMove(currentPlayer);
                gameBoard.registerMove(nextMove, currentPlayer);
                GameBoardDrawer.drawGameBoard(gameBoard);

                if (GameBoardRules.checkWinner(gameBoard, currentPlayer)) {
                    System.out.println(currentPlayer.label + " wins!");
                    break;
                }

                if (GameBoardRules.checkTie(gameBoard)) {
                    System.out.println("No one wins!");
                    break;
                }

                if (currentPlayer == PLAYER_SYMBOL.X) {
                    currentPlayer = PLAYER_SYMBOL.O;
                } else {
                    currentPlayer = PLAYER_SYMBOL.X;
                }

            }

        }
    }
}