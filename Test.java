import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String[] questions = {
            "Что такое массив?",
            "Какое из перечисленных ключевых слов не существует в языке Java?",
            "Какое утверждение характеризует enum (перечисление)?"
        }; 
        String[][] answerOptions = {
            {
                "Набор элементов одного из ссылочных типов, на который ссылаются по одному имени.",
                "Набор элементов одного из примитивных типов, на который ссылаются по одному имени.",
                "Набор элементов любого типа, на который ссылаются по одному имени.",
                "Набор элементов одного типа, на который ссылаются по одному имени."
            },
            {
                "for",
                "elseif",
                "class",
                "byte"
            },
            {
                "Перечисления предоставляют возможные значения для какого-либо элемента",
                "Перечисления представляют собой дополняемые объекты",
                "Перечисления объявляются при помощи ключевого слова new",
                "Перечисления объявляются как обычные переменные - внутри методов"
            }
        };
        int[] keys = {4, 2, 1};

        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            for (int j = 0; j < answerOptions[i].length; j++) {
                System.out.println("   " + (j + 1) + ") " + answerOptions[i][j]);
            }
        }

        int[] answers = new int[questions.length];
        Scanner inputScanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            answers[i] = inputScanner.nextInt();
            System.out.println(answers[i]);
        }
        inputScanner.close();

        System.out.println("Пожалуйста, введите ответы на вопросы:");
        for (int i = 0; i < questions.length; i++) {
            String result = (answers[i] == keys[i]) ? "верно" : "неверно";
            System.out.println("Вопрос №" + (i + 1) + " - " + result + ";");
        }
    }
}
