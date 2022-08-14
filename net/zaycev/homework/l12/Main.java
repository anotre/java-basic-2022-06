package net.zaycev.homework.l12;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Bank sberbank = new Bank();
        Client steven = new Client("Steven", (byte) 16);
        Client maria = new Client("Maria", (byte) 20);
        sberbank.createAccount(steven, 185);
        sberbank.createAccount(maria, 1342);
        sberbank.createAccount(maria, 2431);

        printAccounts(steven, sberbank);
        printAccounts(maria, sberbank);

        HashMap<String, Account> accounts = sberbank.getAccounts(maria);
        Iterator<String> iterator = accounts.keySet().iterator();
        while (iterator.hasNext()) {
            Client client = sberbank.findClient(accounts.get(iterator.next()));
            if (client != null) {
                System.out.println(client.getName());
            } else {
                System.out.println("Ошибка! Владелец счета не найден.");
            }

        }
    }

    private static void printAccounts(Client client, Bank bank) {
        HashMap<String, Account> accounts = bank.getAccounts(client);

        if (accounts != null) {
            System.out.println(accounts.keySet());
            System.out.println(accounts.size());
        } else {
            System.out.println("Запрашиваемая информация не найдена");
        }
    }
}


