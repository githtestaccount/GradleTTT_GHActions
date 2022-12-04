package edu.bht.ccdttt.application;

import edu.bht.ccdttt.data.GameBoard;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputValidator {

    GameBoard currentGameBoard;

    public InputValidator(GameBoard currentGameBoard) {
        this.currentGameBoard = currentGameBoard;
    }

   static boolean askForNewGame() {
        while(true) {
            try {
                System.out.print("Start new game? (0 = no, 1 = yes): ");
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();

                if (input < 0 || input > 1) {
                    System.out.print("\nOny numbers 0 to 1, please! ");
                    continue;
                }

                if (input == 1) {
                    return true;
                } else {
                    System.exit(0);
                }

            } catch(InputMismatchException | NumberFormatException ex ) {
                System.out.print("\nOny numbers 0 to 1, please! ");
            } catch(Exception e ) {
                System.out.println("\n\nException caught :: " + e);
            }
        }
    }

    int getPlayerNextMove(GameBoard.PLAYER_SYMBOL currentPlayer) {
        int nextMove;

        while(true) {
            try {
                System.out.print("\nPlayer " + currentPlayer.label + " is on the move: ");
                Scanner scanner = new Scanner(System.in);
                nextMove = scanner.nextInt();

                if (nextMove < 1 || nextMove > 9) {
                    System.out.print("\nOny numbers 1 to 9, please! ");
                    continue;
                }

                if (currentGameBoard.getGameBoardCells().get(nextMove) != GameBoard.CELL.EMPTY) {
                    System.out.print("\nChoose a free square, please! ");
                    continue;
                }
                break;

            } catch(InputMismatchException | NumberFormatException ex ) {
                System.out.print("\nOny numbers 1 to 9, please! ");
            } catch(Exception e ) {
                System.out.println("\n\nException caught :: " + e);
            }
        }
        return nextMove;
    }
}
