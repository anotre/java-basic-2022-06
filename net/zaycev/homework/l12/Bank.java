package net.zaycev.homework.l12;

//import java.util.List;
import java.util.HashMap;

public class Bank {
    private HashMap <Client, HashMap> bank;
    private HashMap <String, Client> accountOwners;
    public Bank() {
        this.bank = new HashMap<>();
        this.accountOwners = new HashMap<>();
    }

    public Boolean createAccount(Client client, long amount) {
        if (client.getAge() < 18) {
            System.out.println("Извините, открыть счет можно только с 18 лет.");
            return false;
        }

        Account newAccount = new Account(amount);
        this.accountOwners.put(newAccount.getAccountId(), client);
        if (this.bank.containsKey(client)) {
            this.getAccounts(client).put(newAccount.getAccountId(), newAccount);
        } else {
            HashMap <String, Account> userAccounts = new HashMap<>();
            userAccounts.put(newAccount.getAccountId(), newAccount);
            bank.put(client, userAccounts);
        }
        System.out.println("Аккаунт в банке успешно создан");

        return true;
    }
     public HashMap getAccounts(Client client) {
        if (this.bank.containsKey(client)) {
            return this.bank.get(client);
        } else {
            return null;
        }
     }

     public Client findClient(Account account) {
        if (this.accountOwners.containsKey(account.getAccountId())) {
            return this.accountOwners.get(account.getAccountId());
        } else {
            return null;
        }
     }


}
