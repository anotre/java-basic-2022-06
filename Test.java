import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        final int ANSWER_OPTION = 1;

        String[][][] test = {
            {
                {"Что такое массив?"},
                {
                    "Набор элементов одного из ссылочных типов, на который ссылаются по одному имени.",
                    "Набор элементов одного из примитивных типов, на который ссылаются по одному имени.",
                    "Набор элементов любого типа, на который ссылаются по одному имени.",
                    "Набор элементов одного типа, на который ссылаются по одному имени."
                }
            },
            {
                {"Какое из перечисленных ключевых слов не существует в языке Java?"},
                {
                    "for",
                    "elseif",
                    "class",
                    "byte"
                }
            },
            {
                {"Какое утверждение характеризует enum (перечисление)?"},
                {
                    "Перечисления предоставляют возможные значения для какого-либо элемента",
                    "Перечисления представляют собой дополняемые объекты",
                    "Перечисления объявляются при помощи ключевого слова new",
                    "Перечисления объявляются как обычные переменные - внутри методов"
                }
            }
        };

        Integer[] rightAnswers = {4, 2, 1};

        for (int qnNumber = 0; qnNumber < test.length; qnNumber++) {
            for (int qnComponent = 0; qnComponent < test[qnNumber].length; qnComponent++) {
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
            String result = (rightAnswers[i] == answers[i]) ? "верно" : "неверно";
            System.out.println("Вопрос №" + (i + 1) + " - " + result + ";");
        }
    }
}