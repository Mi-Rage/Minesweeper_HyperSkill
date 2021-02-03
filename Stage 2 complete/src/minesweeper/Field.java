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
                System.out.print(cells[i][j].isMine ? MINE : UNKNOWN);
            }
            System.out.println();

        }
    }
}
