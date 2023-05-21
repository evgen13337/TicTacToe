    package ru.dndev.tictactoe.gamelogic;

    import org.junit.Before;
    import org.junit.Test;
    import ru.dndev.tictactoe.model.Table;
    import static org.assertj.core.api.Assertions.assertThat;

    public class GameCheckerTest {
        private GameLogic gameLogic;
        private GameChecker gameChecker;
        private Table table;

        @Before
        public void init() {
            table = new Table(3, '*');
            gameChecker = new GameChecker(table);
            gameLogic = new GameLogic();
            gameLogic.initialisationTable(table);
        }

        @Test
        public void whenXWinHorizontal() {
            table.getTable()[1][0] = table.getFieldX();
            table.getTable()[1][1] = table.getFieldX();
            table.getTable()[1][2] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldX())).isTrue();
        }

        @Test
        public void whenXNotWinHorizontal() {
            table.getTable()[2][0] = table.getFieldX();
            table.getTable()[1][1] = table.getFieldX();
            table.getTable()[1][2] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldX())).isFalse();
        }

        @Test
        public void whenXWinVertical() {
            table.getTable()[0][0] = table.getFieldX();
            table.getTable()[1][0] = table.getFieldX();
            table.getTable()[2][0] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldX())).isTrue();
        }

        @Test
        public void whenXNotWinVertical() {
            table.getTable()[0][2] = table.getFieldX();
            table.getTable()[1][0] = table.getFieldX();
            table.getTable()[2][0] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldX())).isFalse();
        }

        @Test
        public void whenXWinDiagonal() {
            table.getTable()[0][0] = table.getFieldX();
            table.getTable()[1][1] = table.getFieldX();
            table.getTable()[2][2] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldX())).isTrue();
        }

        @Test
        public void whenXNotWinDiagonal() {
            table.getTable()[1][0] = table.getFieldX();
            table.getTable()[1][1] = table.getFieldX();
            table.getTable()[2][2] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldX())).isFalse();
        }

        @Test
        public void whenXWinDiagonalReverse() {
            table.getTable()[0][2] = table.getFieldX();
            table.getTable()[1][1] = table.getFieldX();
            table.getTable()[2][0] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldX())).isTrue();
        }

        @Test
        public void whenXNotWinDiagonalReverse() {
            table.getTable()[1][2] = table.getFieldX();
            table.getTable()[1][1] = table.getFieldX();
            table.getTable()[2][0] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldX())).isFalse();
        }

        @Test
        public void whenOWinHorizontal() {
            table.getTable()[1][0] = table.getFieldO();
            table.getTable()[1][1] = table.getFieldO();
            table.getTable()[1][2] = table.getFieldO();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldO())).isTrue();
        }

        @Test
        public void whenONotWinHorizontal() {
            table.getTable()[2][0] = table.getFieldO();
            table.getTable()[1][1] = table.getFieldO();
            table.getTable()[1][2] = table.getFieldO();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldO())).isFalse();
        }


        @Test
        public void whenOWinVertical() {
            table.getTable()[0][0] = table.getFieldO();
            table.getTable()[1][0] = table.getFieldO();
            table.getTable()[2][0] = table.getFieldO();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldO())).isTrue();
        }

        @Test
        public void whenONotWinVertical() {
            table.getTable()[0][2] = table.getFieldX();
            table.getTable()[1][0] = table.getFieldX();
            table.getTable()[2][0] = table.getFieldX();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldO())).isFalse();
        }

        @Test
        public void whenOWinDiagonal() {
            table.getTable()[0][0] = table.getFieldO();
            table.getTable()[1][1] = table.getFieldO();
            table.getTable()[2][2] = table.getFieldO();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldO())).isTrue();
        }

        @Test
        public void whenONotWinDiagonal() {
            table.getTable()[1][0] = table.getFieldO();
            table.getTable()[1][1] = table.getFieldO();
            table.getTable()[2][2] = table.getFieldO();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldO())).isFalse();
        }

        @Test
        public void whenOWinDiagonalReverse() {
            table.getTable()[0][2] = table.getFieldO();
            table.getTable()[1][1] = table.getFieldO();
            table.getTable()[2][0] = table.getFieldO();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldO())).isTrue();
        }

        @Test
        public void whenONotWinDiagonalReverse() {
            table.getTable()[1][2] = table.getFieldO();
            table.getTable()[1][1] = table.getFieldO();
            table.getTable()[2][0] = table.getFieldO();
            assertThat(gameChecker.checkWinner(table.getTable(), table.getFieldO())).isFalse();
        }

        @Test(expected = ArrayIndexOutOfBoundsException.class)
        public void testWithExpection() {
            table.getTable()[10][10] = table.getFieldX();
            table.getTable()[10][10] = table.getFieldX();
            table.getTable()[10][10] = table.getFieldX();
        }
    }




