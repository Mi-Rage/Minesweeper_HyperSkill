package minesweeper;

import java.util.Random;

public class Field {
    final int SIZE = 9;
    final char UNKNOWN = '.';
    final char MINE = 'X';
    final char MARKED = '*';

    Cell[][] cells;

    public Field(int mines) {
        cells = new Cell[SIZE][SIZE];
        int minesQuantity = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell();
            }
        }

        while (minesQuantity < mines) {
            Random random = new Random();
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (!cells[row][col].isMine) {
                cells[row][col].isMine = true;
                minesQuantity++;
            }
        }
    }

    public void printField() {
        System.out.println(" │123456789│\n—│—————————│");
        for (int i = 0; i < cells.length; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < cells.length; j++) {
                    if (cells[i][j].isMarked) {
                        System.out.print(MARKED);
                    } else {
                        int numberOfMine = checkMineAround(i, j);
                        if (numberOfMine <= 0) {
                            System.out.print(UNKNOWN);
                        } else {
                            System.out.print(numberOfMine);
                        }
                    }
            }
            System.out.println("|");
        }
        System.out.println("—│—————————│");
    }

    public int checkMineAround(int row, int col) {
        int result = 0;

        if (cells[row][col].isMine) {
            return -1;
        }

        int upShift = 1;
        int downShift = 1;
        int leftShift = 1;
        int rightShift = 1;

        if (row == 0) {
            upShift = 0;
        }
        if (row == cells.length - 1) {
            downShift = 0;
        }
        if (col == 0) {
            leftShift = 0;
        }
        if (col == cells.length - 1) {
            rightShift = 0;
        }
        for (int i = row - upShift; i <= row + downShift; i++) {
            for (int j = col - leftShift; j <= col + rightShift; j++) {
                    if (cells[i][j].isMine) {
                        result++;
                    }
            }
        }
        return result;
    }

    public boolean isAllMineMarked() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[i][j].isMine && !cells[i][j].isMarked) {
                    return false;
                }
            }
        }
        return true;
    }
}
