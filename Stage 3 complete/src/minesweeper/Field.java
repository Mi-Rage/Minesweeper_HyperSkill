package minesweeper;

import java.util.Random;

public class Field {
    final int SIZE = 9;
    final char UNKNOWN = '.';
    final char MINE = 'X';

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
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                int numberOfMine = checkMineAround(i,j);
                if (numberOfMine == -1) {
                    System.out.print(MINE);
                } else if (numberOfMine == 0) {
                    System.out.print(UNKNOWN);
                } else {
                    System.out.print(numberOfMine);
                }
            }
            System.out.println();
        }
    }

    public int checkMineAround(int row, int col) {
        int result = 0;

        if (cells[row][col].isMine) {
            return -1;
        }

        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;

        if (row == 0) {
            up = 0;
        }
        if (row == cells.length - 1) {
            down = 0;
        }
        if (col == 0) {
            left = 0;
        }
        if (col == cells.length - 1) {
            right = 0;
        }
        for (int i = row - up; i <= row + down; i++) {
            for (int j = col - left; j <= col + right; j++) {
                    if (cells[i][j].isMine) {
                        result++;
                    }
            }
        }
        return result;
    }
}
