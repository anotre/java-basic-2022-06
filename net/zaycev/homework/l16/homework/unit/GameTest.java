package net.zaycev.homework.l16.homework.unit;

import net.zaycev.homework.l16.homework.game.*;
import net.zaycev.homework.l16.homework.unit.fakes.DiceImplSameResultsStub;
import net.zaycev.homework.l16.homework.unit.fakes.DiceImplStub;
import net.zaycev.homework.l16.homework.unit.fakes.GameWinnerConsolePrinterSpy;

import java.util.ArrayList;
import java.util.List;

public class GameTest {


    public void testGameWithSameResults() {
        String scenario = "Тест при равных значениях";
           
        try {
            List<Player> winners = new ArrayList<>();
            Dice dice = new DiceImplSameResultsStub();
            GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinterSpy(winners);
            Game game = new Game(dice, winnerPrinter);
            game.playGame(new Player("Алексей"), new Player("Игорь"));

            if (winners.size() != 2) {
                throw new Exception("Wrong result. Draw result expected.");
            }
            System.out.printf("\u2705 \"%s\" passed %n", scenario);
        } catch (Exception e) {
            System.err.printf("\u274C \"%s\" failed with message \"%s\"%n", scenario, e.getMessage());
        }       
    }

    public void testGameWithExpectedResults(int a, int b) {
        String scenario = "Тест на корректность интерпретации результатов при A > B или C < D";

        try {
            Player playerA = new Player("Алексей");
            Player playerB = new Player("Игорь");
            // Player winner = null;
            List<Player> winners = new ArrayList<>();
            Player expectedWinner = (a > b) ? playerA : playerB;
            Dice dice = new DiceImplStub(new int[] {a, b});
            GameWinnerPrinter gameWinnerPrinter = new GameWinnerConsolePrinterSpy(winners);
            Game game = new Game(dice, gameWinnerPrinter);
            game.playGame(playerA, playerB);
            if (winners.size() == 1 && winners.get(0).hashCode() != expectedWinner.hashCode()) {
                throw new Exception("Wrong result in playGame method");
            }
            System.out.printf("\u2705 \"%s\" passed with parameters: (%d, %d) %n", scenario, a, b);
        } catch (Exception e) {
            System.err.printf("\u274C \"%s\" failed with message \"%s\" and parameters (%d, %d)%n", scenario, e.getMessage(), a, b);
        }
    }
}
