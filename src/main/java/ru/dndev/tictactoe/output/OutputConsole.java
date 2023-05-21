package ru.dndev.tictactoe.output;

public class OutputConsole implements Output {

    @Override
    public void output(String str) {
        System.out.println(str);
    }
}
