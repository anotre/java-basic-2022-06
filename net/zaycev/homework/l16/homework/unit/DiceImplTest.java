package net.zaycev.homework.l16.homework.unit;

import net.zaycev.homework.l16.homework.game.DiceImpl;
import java.util.HashMap;
import java.util.Collections;

public class DiceImplTest {
    DiceImpl sut = new DiceImpl();

    public void testDiceValuesVariety() {
        String scenario = "Тест возможных выброшенных значений";
        try {
            for (int i = 0; i < 100; i++) {
                int testVal = sut.roll();
                System.out.println("Тестовое значение: " + testVal);

                if (testVal > 6 || testVal < 1) {
                    throw new Exception("получено значение вне допустимых пределов");
                }
            }
            
            System.out.printf("\u2705 \"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\u274C \"%s\" failed with message \"%s\"%n", scenario, e.getMessage());
        }
    }

    public void testDiceValueProbability() {
        String scenario = "Тест равномерности вероятности выпадения чисел";
        final float MAX_PROBABILITY_INDEX = 1.15F;

        try {
            HashMap<Integer, Integer> results = new HashMap<>();

            for (int i = 0; i < 100000; i++) {
                int result = sut.roll();
                if (!results.containsKey(result)) {
                    results.put(result, 1);
                    continue;
                }

                int buffer = results.get(result);
                results.put(result, ++buffer);
            }

            float min = Collections.min(results.values());
            float max = Collections.max(results.values());
            float divisionResult = max / min;

            System.out.println("Тестовое значение: " + divisionResult);

            if ((divisionResult) > MAX_PROBABILITY_INDEX) {
                throw new Exception(String.format("некорректное распределение вероятности (%f)", divisionResult));
            }

            System.out.printf("\u2705 \"%s\" passed %n", scenario);
        } catch(Exception e) {
            System.err.printf("\u274C \"%s\" failed with message \"%s\"%n", scenario, e.getMessage());
        }
    }
}
