package net.zaycev.homework.l16.homework;

import net.zaycev.homework.l16.homework.unit.DiceImplTest;
import net.zaycev.homework.l16.homework.unit.GameTest;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {

        new DiceImplTest().testDiceValuesVariety();
        new DiceImplTest().testDiceValueProbability();
        new GameTest().testGameWithSameResults();
        new GameTest().testGameWithExpectedResults(1, 2);
        new GameTest().testGameWithExpectedResults(2, 2);
        new GameTest().testGameWithExpectedResults(2, 1);
    }
    
}