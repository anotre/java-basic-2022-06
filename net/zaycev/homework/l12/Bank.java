package net.zaycev.homework.l12;

import java.util.HashMap;
import java.util.HashSet;

public class Bank {
    private HashMap <Client, HashSet<Account>> accauntRegistry;
    private HashMap <String, Client> accountOwners;
    public Bank() {
        this.accauntRegistry = new HashMap<>();
        this.accountOwners = new HashMap<>();
    }

    private HashMap <Client, HashSet<Account>> getAccauntRegistry() {
        return this.accauntRegistry;
    }
    public Boolean createAccount(Client client, long amount) {
        if (client.getAge() < 18) {
            System.out.println("Извините, открыть счет можно только с 18 лет.");
            return false;
        }

        Account newAccount = new Account(amount);
        this.accountOwners.put(newAccount.getAccountId(), client);
        if (this.accauntRegistry.containsKey(client)) {
            this.getAccounts(client).add(newAccount);
        } else {
            HashSet<Account> userAccounts = new HashSet<>();
            userAccounts.add(newAccount);
            accauntRegistry.put(client, userAccounts);
        }
        System.out.println("Аккаунт в банке успешно создан");

        return true;
    }
     public HashSet<Account> getAccounts(Client client) {
        if (this.accauntRegistry.containsKey(client)) {
            return this.accauntRegistry.get(client);
        } else {
            return null;
        }
     }

     public Client findClient(Account account) {
        return this.accountOwners.get(account.getAccountId());
     }


}
