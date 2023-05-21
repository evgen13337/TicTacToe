package ru.dndev.tictactoe.actions;

import ru.dndev.tictactoe.input.Input;
import ru.dndev.tictactoe.output.Output;
import ru.dndev.tictactoe.model.Table;

public class MoveX implements Action {

    private final Input input;
    private final Output output;

    public MoveX(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String name() {
        return "'X' Сделайте ход";
    }

    @Override
    public boolean execute(Table table) {
        output.output("Введите координаты для хода 'X', через пробел");
        int row = input.inputInt();
        int colum = input.inputInt();
        table.getTable()[colum][row] = table.getFieldX();
        return true;
    }
}
