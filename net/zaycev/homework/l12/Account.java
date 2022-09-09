package net.zaycev.homework.l12;

import java.util.Objects;
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
        ("").equals("");
        this.amount = amount;
        this.accountId = String.valueOf(new Random().nextLong()).replace("-", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return amount == account.amount && Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, accountId);
    }
}
