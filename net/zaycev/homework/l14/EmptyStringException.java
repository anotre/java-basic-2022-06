package net.zaycev.homework.l14;

public class EmptyStringException extends Exception {
    public EmptyStringException() {}

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
