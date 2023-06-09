package ru.dndev.tictactoe.game;

import ru.dndev.tictactoe.input.Input;
import ru.dndev.tictactoe.input.InputConsole;
import ru.dndev.tictactoe.model.BotPLayer;
import ru.dndev.tictactoe.model.Player;
import ru.dndev.tictactoe.model.Table;
import ru.dndev.tictactoe.output.Output;
import ru.dndev.tictactoe.output.OutputConsole;
import java.util.Objects;
import java.util.Random;

public class Game {
    private final Table table;
    private final Input input;
    private final Output output;
    private final Random random = new Random();

    public Game(Table table) {
        this.table = table;
        this.input = new InputConsole();
        this.output = new OutputConsole();
    }

    public void initialisationTable(Table table) {
        for (int i = 0; i < table.getTableSize(); i++) {
            for (int j = 0; j < table.getTableSize(); j++) {
                table.getTable()[i][j] = table.getEmptyField();
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < table.getTableSize(); i++) {
            drawLine();
            drawRow(i);
        }
        drawLine();
    }

    private void drawLine() {
        for (int i = 0; i < table.getTableSize(); i++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    private void drawRow(int row) {
        for (int i = 0; i < table.getTableSize(); i++) {
            System.out.print("| " + table.getTable()[row][i] + " ");
        }
        System.out.println("|");
    }

    public void moveHuman(Player player) {
        boolean flag = true;
        System.out.println("Ход игрока - " + player.getName());
        do {
            int x = input.inputInt();
            int y = input.inputInt();
            if ((x < 0) || (x >= table.getTableSize()) || (y < 0) || (y >= table.getTableSize())) {
                output.output("Некорректное значение!");
            } else if (!Objects.equals(table.getTable()[x][y], table.getEmptyField())) {
                output.output("Данная ячейка уже занята");
            } else {
                table.getTable()[x][y] = player.getField();
                flag = false;
            }
        } while (flag);
    }

    public void moveBot(BotPLayer botPLayer) {
        boolean flag = true;
        output.output("Ход бота");
        do {
            int x = random.nextInt(table.getTableSize());
            int y = random.nextInt(table.getTableSize());
            if (Objects.equals(table.getTable()[x][y], table.getEmptyField())) {
                table.getTable()[x][y] = botPLayer.getBotField();
                flag = false;
            }
        } while (flag);
    }

    public boolean checkWinner(Table table, String field) {
        int row = 0;
        int colum = 0;
        int diagonal = 0;
        int diagonalReverse = 0;
        int count = table.getTableSize();
        for (int i = 0; i < table.getTable().length; i++) {
            for (int j = 0; j < table.getTable().length; j++) {
                if (Objects.equals(table.getTable()[i][j], field)) {
                    row++;
                }
                if (Objects.equals(table.getTable()[j][i], field)) {
                    colum++;
                }
                if (colum == count || row == count) {
                    return true;
                }
            }
            colum = 0;
            row = 0;
        }
        for (int i = 0; i < table.getTable().length; i++) {
            if (Objects.equals(table.getTable()[i][i], field)) {
                diagonal++;
            }
            if (Objects.equals(table.getTable()[table.getTable().length - 1 - i][i], field)) {
                diagonalReverse++;
            }
            if (diagonal == count || diagonalReverse == count) {
                return true;
            }
        }
        return false;
    }

    public boolean draw(Table table) {
        for (int i = 0; i < table.getTable().length; i++) {
            for (int j = 0; j < table.getTable().length; j++) {
                if (Objects.equals(table.getTable()[i][j], table.getEmptyField())) {
                    return true;
                }
            }
        }
        System.out.println("Ничья, победила дружба :)");
        return false;
    }
}