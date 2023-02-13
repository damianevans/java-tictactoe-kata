package com.asos.katas;

public class Board {
    private int size;
    private char[][] squares;

    public Board(int size) {
        this.size = size;
        squares = new char[this.size][this.size];
        initialiseBoard();
    }

    public int getMaxTurns() {
        return this.size * this.size;
    }

    private void initialiseBoard(){
        //fill the board with '-'
        for(int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++){
                squares[row][col] = '-';
            }
        }
    }

    public void renderBoard() {
        StringBuilder board = new StringBuilder();
        for(int row = 0; row < this.size; row ++) {
           for(int col = 0; col < this.size; col++) {
               board.append(String.format(" %s ", squares[row][col]));
           }
           board.append("\n");

        }

        System.out.println(board.toString());
    }



    public String getCellAtPosition(int row, int col) {
        return String.valueOf(this.squares[row][col]);
    }

    public void setCellValue(int row, int column, char playerCounter) {
        this.squares[row][column] = playerCounter;
    }
}
