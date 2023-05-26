package ru.dndev.tictactoe.model;

public class Player {
    private String name;
    private String field;

    public Player(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name
                + '\''
                + ", field='" + field
                + '\''
                + '}';
    }
}
