package ru.dndev.tictactoe.actions;

import ru.dndev.tictactoe.input.Input;
import ru.dndev.tictactoe.model.Table;
import ru.dndev.tictactoe.output.Output;

public class MoveO implements Action {

    private final Input input;
    private final Output output;

    public MoveO(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String name() {
        return "'O' Сделайте ход";
    }

    @Override
    public boolean execute(Table table) {
        output.output("Введите координаты для хода 'O', через пробел");
        int row = input.inputInt();
        int colum = input.inputInt();
        table.getTable()[colum][row] = table.getFieldO();
        return true;
    }
}
