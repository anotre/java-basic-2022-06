package net.zaycev.homework.l8;

public class Question {
    private String question;
    private String answers[];
    private int key;

    public Question(String question, String[] answers, int key) {
        this.question = question;
        this.answers = answers;
        this.key = key;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getKey() {
        return key;
    }
}
