package com.asos.katas;

public class Game {

    boolean playerXTurn = false;
    int remainingMoves = 0;
    Board board = null;

    public Game() {
        this.board = new Board(3);
        remainingMoves = this.board.getMaxTurns();
    }

    public Game(Board board) {
        this.board = board;
        remainingMoves = this.board.getMaxTurns();
    }

    public void play(int row, int column) {
        playerXTurn = !playerXTurn;
        remainingMoves --;
        char playerCounter = (playerXTurn)? 'X' : 'Y';
        this.board.setCellValue(row, column, playerCounter);

    }

    public String getNextPlayer() {
        if(playerXTurn)
            return "X";

        return "Y";
    }


    public int countRemainingMoves() {
        return remainingMoves;
    }

    public boolean isOver() {
        return remainingMoves == 0;
    }

    public String getCellValue(int row, int col) {
        return this.board.getCellAtPosition(row, col);
    }
}
