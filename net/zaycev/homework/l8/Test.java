package net.zaycev.homework.l8;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questions = new ArrayList<>();

    public Test() {

    }

    private int[] getUserAnswers() {
        int[] answers = new int[this.questions.size()];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите ответы на вопросы:");
        for  (int i = 0; i < this.questions.size(); i++) {
            answers[i] = scanner.nextInt();
        }
        scanner.close();
        return answers;
    }

    private boolean[] checkUserAnswers(int[] answers, int[] keys) {
        boolean[] results = new boolean[keys.length];
        for (int i = 0; i < keys.length; i++) {
            results[i] = (answers[i] == keys[i]) ? true : false;
        }
        return results;
    }

    private void outputTest() {
        final String INDENT = "   ";
        for (int i = 0; i < this.questions.size(); i++) {
            System.out.println(this.questions.get(i).getQuestion());
            for (String answer: this.questions.get(i).getAnswers()) {
                System.out.println(INDENT + answer);
            }
        }
    }

    private void outputResults(boolean[] testResults) {
        System.out.println("Результаты тестирования:");
        for (int i = 0; i < this.questions.size(); i++) {
            String resultString = (testResults[i]) ? "верно" : "неверно";
            System.out.println("Вопрос №" + (i + 1) + " - " + resultString + ";");
        }
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    private int[] getTestKeys() {
        int[] testKeys = new int[this.questions.size()];
        for (int i = 0; i < this.questions.size(); i++) {
            testKeys[i] = this.questions.get(i).getKey();
        }
        return testKeys;
    }

    public void startTest() {
        if (this.questions.size() != 0) {
            this.outputTest();
            int[] userAnswers = this.getUserAnswers();
            int[] testKeys = this.getTestKeys();
            boolean[] testResults = this.checkUserAnswers(userAnswers, testKeys);
            this.outputResults(testResults);
        } else {
            System.out.println("Нет вопросов для проведения тестирования");
        }
        

    }
}