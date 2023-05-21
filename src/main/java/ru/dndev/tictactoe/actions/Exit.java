package ru.dndev.tictactoe.actions;

import ru.dndev.tictactoe.model.Table;

public class Exit implements Action {

    @Override
    public String name() {
        return "Выход из игры";
    }

    @Override
    public boolean execute(Table table) {
        return false;
    }
}
