package ru.dndev.tictactoe.gamelogic;

import ru.dndev.tictactoe.model.Table;
public class GameLogic {

    public void initialisationTable(Table table) {
        for (int i = 0; i < table.getTableSize(); i++) {
            for (int j = 0; j < table.getTableSize(); j++) {
                table.getTable()[i][j] = table.getEmptyField();
            }
        }
    }

    public void printTable(Table table) {
        for (int i = 0; i <= table.getTableSize(); i++) {
            System.out.print((i - 1)  + "  ");
        }
        System.out.println();
        for (int i = 0; i < table.getTableSize(); i++) {
            System.out.print((i) + "   ");
            for (int j = 0; j < table.getTableSize(); j++) {
                System.out.print(table.getTable()[i][j] + "   ");
            }
            System.out.println();
        }

    }
}
