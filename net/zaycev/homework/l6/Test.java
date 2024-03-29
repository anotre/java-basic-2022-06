package net.zaycev.homework.l6;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        final int ANSWER_OPTION = 1;
        final int RIGHT_ANSWER = 2;
        final int ANSWER_INDEX = 0;

        String[][][] test = {
            {
                {"Что такое массив?"},
                {
                    "Набор элементов одного из ссылочных типов, на который ссылаются по одному имени.",
                    "Набор элементов одного из примитивных типов, на который ссылаются по одному имени.",
                    "Набор элементов любого типа, на который ссылаются по одному имени.",
                    "Набор элементов одного типа, на который ссылаются по одному имени."
                },
                {"4"}
            },
            {
                {"Какое из перечисленных ключевых слов не существует в языке Java?"},
                {
                    "for",
                    "elseif",
                    "class",
                    "byte"
                },
                {"2"}
            },
            {
                {"Какое утверждение характеризует enum (перечисление)?"},
                {
                    "Перечисления предоставляют возможные значения для какого-либо элемента",
                    "Перечисления представляют собой дополняемые объекты",
                    "Перечисления объявляются при помощи ключевого слова new",
                    "Перечисления объявляются как обычные переменные - внутри методов"
                },
                {"1"}
            }
        };
        String[][] newQuestion = {
            {"(Копия)Какое утверждение характеризует enum (перечисление)?"},
            {
                "Перечисления предоставляют возможные значения для какого-либо элемента",
                "Перечисления представляют собой дополняемые объекты",
                "Перечисления объявляются при помощи ключевого слова new",
                "Перечисления объявляются как обычные переменные - внутри методов"
            },
            {"1"}
        };

        test = addQuestion(test, newQuestion);

        for (int qnNumber = 0; qnNumber < test.length; qnNumber++) {
            for (int qnComponent = 0; qnComponent < test[qnNumber].length - 1; qnComponent++) {
                final String INDENT = (qnComponent == ANSWER_OPTION) ? "   " : "";

                for (int item = 0; item < test[qnNumber][qnComponent].length; item++) {
                    System.out.println(INDENT + test[qnNumber][qnComponent][item]);
                }
            }
        }

        int[] answers = new int[test.length];
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите ответы на вопросы:");
        for (int i = 0; i < test.length; i++) {
            answers[i] = inputScanner.nextInt();
        }
        inputScanner.close();
     
        for (int i = 0; i < test.length; i++) {
            String result = (Integer.parseInt(test[i][RIGHT_ANSWER][ANSWER_INDEX]) == answers[i]) ? "верно" : "неверно";
            System.out.println("Вопрос №" + (i + 1) + " - " + result + ";");
        }
    }

    private static String[][][] addQuestion(String[][][] test, String[][] newItem) {
        String[][][] updatedTest = new String[test.length + 1][test[0].length][];
    
        for (int i = 0; i < test.length + 1; i++) { // Вопросы
            for (int j = 0; j < test[0].length; j++) { // компоненты
                updatedTest[i][j] = ((updatedTest.length - 1) != i) ? test[i][j] : newItem[j];
            }
        }
    
        return updatedTest;
    }
}