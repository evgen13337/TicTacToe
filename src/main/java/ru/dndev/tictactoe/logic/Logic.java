package ru.dndev.tictactoe.logic;

import ru.dndev.tictactoe.game.Game;
import ru.dndev.tictactoe.input.Input;
import ru.dndev.tictactoe.input.InputConsole;
import ru.dndev.tictactoe.model.BotPLayer;
import ru.dndev.tictactoe.model.Player;
import ru.dndev.tictactoe.model.Table;
import ru.dndev.tictactoe.output.Output;
import ru.dndev.tictactoe.output.OutputConsole;

public class Logic {
    private final Table table;
    private final int tableSize = 3;
    private final String emptyField = "*";
    private final Game game;
    private final Input input;
    private final Output output;

    public Logic() {
        this.input = new InputConsole();
        this.output = new OutputConsole();
        this.table = new Table(tableSize, emptyField);
        this.game = new Game(table);
    }

    public void play() {
        System.out.println("Введите свое имя, и введите символ которым хотите играть");
        Player player = new Player(input.inputStr(), input.inputStr());
        System.out.println("Введите символ для бота которым он будет играть");
        BotPLayer botPLayer = new BotPLayer(input.inputStr());
        game.initialisationTable(table);
        do {
            game.printTable();
            System.out.println("Введите координаты черел пробел");
            game.moveHuman(player);
            if (game.checkWinner(table, player.getField())) {
                output.output("Победил " + player);
                game.printTable();
                break;
            }
            game.moveBot(botPLayer);
            if (game.checkWinner(table, botPLayer.getBotField())) {
                output.output("Победил " + botPLayer);
                break;
            }
        } while (true);
    }
}