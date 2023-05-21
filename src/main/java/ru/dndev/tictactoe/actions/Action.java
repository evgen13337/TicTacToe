package ru.dndev.tictactoe.actions;

import ru.dndev.tictactoe.model.Table;

public interface Action {

    String name();

    boolean execute(Table table);
}
