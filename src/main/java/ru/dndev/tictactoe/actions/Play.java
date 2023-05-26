package ru.dndev.tictactoe.actions;

import ru.dndev.tictactoe.model.Table;
import ru.dndev.tictactoe.output.Output;

public class Play implements Action {
    private final Output output;

    public Play(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Играть";
    }

    @Override
    public boolean execute(Table table) {
        return true;
    }
}
