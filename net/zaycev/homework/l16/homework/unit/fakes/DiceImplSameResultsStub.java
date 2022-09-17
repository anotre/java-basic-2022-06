package net.zaycev.homework.l16.homework.src.main.java.ru.otus.unit.fakes;
import net.zaycev.homework.l16.game.Dice;

public class DiceImplSameResultsStub implements Dice {
    @Override
    public int roll() {
        // https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
        return 1;
    }
}
