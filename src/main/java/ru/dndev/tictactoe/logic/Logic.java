package ru.dndev.tictactoe.logic;

import ru.dndev.tictactoe.actions.*;
import ru.dndev.tictactoe.gamelogic.GameChecker;
import ru.dndev.tictactoe.gamelogic.GameLogic;
import ru.dndev.tictactoe.input.Input;
import ru.dndev.tictactoe.input.InputConsole;
import ru.dndev.tictactoe.model.Table;
import ru.dndev.tictactoe.output.Output;
import ru.dndev.tictactoe.output.OutputConsole;
import java.util.HashMap;
import java.util.Map;

public class Logic {
    private final Table table;
    private final GameLogic gameLogic;
    private final GameChecker gameChecker;
    private final Input input;
    private final Output output;
    private final MoveX moveX;
    private final MoveO moveO;
    private final Map<Integer, Action> action;

    public Logic() {
        this.input = new InputConsole();
        this.output = new OutputConsole();
        this.table = new Table(3, '*');
        this.gameLogic = new GameLogic();
        this.gameChecker = new GameChecker(table);
        this.moveX = new MoveX(input, output);
        this.moveO = new MoveO(input, output);
        this.action = new HashMap<>();
        init();
    }

    public void play() {
        gameLogic.initialisationTable(table);
        client();
        while (true) {
            gameLogic.printTable(table);
            moveX.execute(table);
            if (gameChecker.checkWinner(table.getTable(), table.getFieldX())) {
                gameLogic.printTable(table);
                break;
            }
            gameLogic.printTable(table);
            moveO.execute(table);
            if (gameChecker.checkWinner(table.getTable(), table.getFieldO())) {
                gameLogic.printTable(table);
                break;
            }
        }
    }

    public void init() {
        action.put(1, new Play(output));
        action.put(2, new Exit());
    }

    private boolean client() {
        for (Map.Entry<Integer, Action> entry : action.entrySet()) {
            output.output(entry.getKey().toString() + ") " + entry.getValue().name());
        }
        output.output("Введите число");
        int in = input.inputInt();
        return action.containsKey(in) ? action.get(in).execute(table) : false;
    }
}
