package ru.dndev.tictactoe.input;

import java.util.Scanner;

public class InputConsole implements Input {

    private final Scanner scanner;

    public InputConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String inputStr() {
        return scanner.next();
    }

    @Override
    public int inputInt() {
        return scanner.nextInt();
    }
}
