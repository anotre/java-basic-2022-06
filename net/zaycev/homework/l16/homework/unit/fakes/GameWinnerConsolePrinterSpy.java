package net.zaycev.homework.l16.homework.unit.fakes;

import java.util.List;

import net.zaycev.homework.l16.homework.game.GameWinnerPrinter;
import net.zaycev.homework.l16.homework.game.Player;

public class GameWinnerConsolePrinterSpy implements GameWinnerPrinter {

    private List<Player> winners;

    public GameWinnerConsolePrinterSpy(List<Player> winners) {
        this.winners = winners;
    }

    @Override
    public void printWinner(Player winner) {
        this.winners.add(winner);
        System.out.printf("Победитель: %s%n", winner.getName());
    }
}
