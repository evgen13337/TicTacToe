package ru.dndev.tictactoe.model;

public class Table {

    private final int tableSize;
    private final String emptyField;
    private String[][] table;

    public Table(int tableSize, String emptyField) {
        this.tableSize = tableSize;
        this.emptyField = emptyField;
        this.table = new String[tableSize][tableSize];
    }

    public int getTableSize() {
        return tableSize;
    }

    public String getEmptyField() {
        return emptyField;
    }

    public String[][] getTable() {
        return table;
    }

    public void setTable(String[][] table) {
        this.table = table;
    }
}
