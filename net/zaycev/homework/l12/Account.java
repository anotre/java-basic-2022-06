package net.zaycev.homework.l12;

import java.util.Random;
public class Account {
    private long amount;
    private String accountId;

    public long getAmount() {
        return this.amount;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public Account(long amount) {
        this.amount = amount;
        this.accountId = String.valueOf(new Random().nextLong()).replace("-", "");
    }
}
