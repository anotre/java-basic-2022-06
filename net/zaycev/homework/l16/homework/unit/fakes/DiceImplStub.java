package net.zaycev.homework.l16.homework.unit.fakes;

import net.zaycev.homework.l16.homework.game.Dice;

public class DiceImplStub implements Dice {
    private final int[] results;;
    private int currentIndex;
    
    public DiceImplStub(int[] results) {
        this.currentIndex = 0;
        this.results = results;
    }

    public int roll() {
        return this.results[this.currentIndex++];
    }
}
