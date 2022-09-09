package net.zaycev.homework.l12;

import java.util.Iterator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Bank sberbank = new Bank();
        Client steven = new Client("Steven", (byte) 16);
        Client maria = new Client("Maria", (byte) 20);
        Client sergey = new Client("Sergey", (byte) 50);
        sberbank.createAccount(steven, 185);
        sberbank.createAccount(maria, 1342);
        sberbank.createAccount(maria, 2431);
        sberbank.createAccount(sergey, 1111);

        printAccounts(steven, sberbank);
        printAccounts(maria, sberbank);

        HashSet<Account> accounts = sberbank.getAccounts(maria);
        Iterator<Account> iterator = accounts.iterator();
        // Аккаунт для тестов
        Account testAccount;
        while (iterator.hasNext()) {
            testAccount = iterator.next();
            Client client = sberbank.findClient(testAccount);
            if (client != null) {
                System.out.println(client.getName());
            } else {
                System.out.println("Ошибка! Владелец счета не найден.");
            }

        }

        System.out.println("Проверка получения списка аккаунтов при изменении состояния средства их получения.");
        System.out.println((sberbank.getAccounts(maria) != null) ? "Получили список аккаунтов" : "Не получили список аккаунтов");
        // (hashCode и equals класса Client переопределены)
        System.out.println("Изменили возраст клиента");
        maria.incrementAge();
        System.out.println((sberbank.getAccounts(maria) != null) ? "Получили список аккаунтов" : "Не получили список аккаунтов");

        System.out.println("Проверка при переопределении только equals у Client");
        System.out.println((sberbank.getAccounts(sergey) != null) ? "Получили список аккаунтов" : "Не получили список аккаунтов");
        System.out.println((sberbank.getAccounts(new Client("Sergey", (byte) 50)) != null) ? "Получили список аккаунтов" : "Не получили список аккаунтов");

        System.out.println("Проверка при переопределении только hashCode у Client");
        System.out.println((sberbank.getAccounts(sergey) != null) ? "Получили список аккаунтов" : "Не получили список аккаунтов");
        System.out.println((sberbank.getAccounts(new Client("Sergey", (byte) 50)) != null) ? "Получили список аккаунтов" : "Не получили список аккаунтов");




    }

    private static void printAccounts(Client client, Bank bank) {
        HashSet<Account> accounts = bank.getAccounts(client);

        if (accounts != null) {
            System.out.println(accounts.size());
        } else {
            System.out.println("Запрашиваемая информация не найдена");
        }
    }
}


