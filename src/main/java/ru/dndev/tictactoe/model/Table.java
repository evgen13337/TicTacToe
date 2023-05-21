package ru.dndev.tictactoe.model;

public class Table {

    private final int tableSize;
    private final char emptyField;
    private final char fieldX = 'X';
    private final char fieldO = 'O';
    private char[][] table;

    public Table(int tableSize, char emptyField) {
        this.tableSize = tableSize;
        this.emptyField = emptyField;
        this.table = new char[tableSize][tableSize];
    }

    public int getTableSize() {
        return tableSize;
    }

    public char getEmptyField() {
        return emptyField;
    }

    public char[][] getTable() {
        return table;
    }

    public char getFieldX() {
        return fieldX;
    }

    public char getFieldO() {
        return fieldO;
    }

    public void setTable(char[][] table) {
        this.table = table;
    }
}
