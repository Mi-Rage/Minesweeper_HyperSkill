package minesweeper;

import java.util.Scanner;

public class Game {
    Field field;
    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.print("How many mines do you want on the field? ");
        int mines = scanner.nextInt();
        field = new Field(mines);
        field.printField();
    }
}
