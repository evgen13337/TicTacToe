package ru.dndev.tictactoe.gamelogic;

import ru.dndev.tictactoe.input.Input;
import ru.dndev.tictactoe.model.Table;
import ru.dndev.tictactoe.output.Output;

public class GameChecker {
    private final Table table;
    private Input input;
    private Output output;

    public GameChecker(Table table) {
        this.table = table;
    }

    public boolean checkWinner(char[][] board, char field) {
        for (int i = 0; i < board.length; i++) {
            if (winnerHorizontal(board, i, field) || winnerVertical(board, i, field)
                    || diagonalWinner(board, field) || diagonalWinnerReverse(board, field)
                    || draw(board)) {
                return true;
            }
        }
        return false;
    }

    private boolean winnerHorizontal(char[][] board, int row, char field) {
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != field) {
                return false;
            }
        }
        System.out.println("Победил: " + field);
        return true;
    }

    private boolean winnerVertical(char[][] board, int col, char field) {
        for (int i = 0; i < board[col].length; i++) {
            if (board[i][col] != field) {
                return false;
            }
        }
        System.out.println("Победил: " + field);
        return true;
    }

    private boolean diagonalWinner(char[][] board, char field) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != field) {
                return false;
            }
        }
        System.out.println("Победил: " + field);
        return true;
    }

    private boolean diagonalWinnerReverse(char[][] board, char field) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - i - 1] != field) {
                return false;
            }
        }
        System.out.println("Победил: " + field);
        return true;
    }

    private boolean draw(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == table.getEmptyField()) {
                    return false;
                }
            }
        }
        System.out.println("Ничья, победила дружба :)");
        return true;
    }

    public boolean coordinateValid(int x, int y) {
        if (x < 0 || y < 0 || table.getTableSize() > x || table.getTableSize() > y) {
            if (table.getTable()[x][y] != table.getEmptyField()) {
                System.out.println("Не верно введены координаты");
                return false;
            }
        }
        return true;
    }
}

