package ru.dndev.tictactoe.model;

public class BotPLayer {
    private final String botName = "BOT";
    private String botField;

    public BotPLayer(String botField) {
        this.botField = botField;
    }

    public String getBotName() {
        return botName;
    }

    public String getBotField() {
        return botField;
    }

    public void setBotField(String botField) {
        this.botField = botField;
    }

    @Override
    public String toString() {
        return "BotPLayer{"
                + "botName='" + botName
                + '\''
                + ", botField='" + botField
                + '\'' + '}';
    }
}
