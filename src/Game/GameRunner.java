package Game;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();
        int i = -1;
        //вибір, хто ходитиме першим
        do {
            System.out.println("Хто ходитиме першим: Ви(натисніть 1) чи Комп'ютер(натисніть 2)?");
            i = in.nextInt();
        } while (i != 1 && i != 2);
        int counter = GameField.mas.length;
        int a = -1;
        boolean f = false;
        //якщо вибрали 1, ходитиме першим гравець
        if (i == 1) {
            for (int j = 0; j < counter; j++) {
                if (j % 2 == 0) {
                    System.out.println("Введіть число від 1 до 9");
                    //перевірка на те, чи поле не зайняте
                    do {
                        a = in.nextInt();
                        if (GameField.mas[a - 1] == GameField.USER || GameField.mas[a - 1] == GameField.COMPUTER)
                            System.out.println("Клітинка зайнята. Введіть число від 1 до 9");
                    } while (GameField.mas[a - 1] != '-');
                    GameField.mas[a - 1] = GameField.USER;
                    //перевірка на завершення гри
                    if (gameLogic.finishGame()) {
                        for (int k = 0; k < GameField.mas.length; k++) {
                            System.out.print(GameField.mas[k] + " ");
                        }
                        System.out.println();
                        System.out.println("Переміг гравець");
                        f = true;
                        break;
                    }
                }
                if (j % 2 != 0) {
                    gameLogic.randCount();
                    for (int k = 0; k < GameField.mas.length; k++) {
                        System.out.print(GameField.mas[k] + " ");
                    }
                    System.out.println();
                    if (gameLogic.finishGame()) {
                        System.out.println();
                        System.out.println("Переміг комп");
                        f = true;
                        break;
                    }
                }
            }
        }
        // якщо вибрали 2, компютер ходить першим
        if (i == 2) {
            for (int j = 0; j < counter; j++) {
                if (j % 2 == 0) {
                    gameLogic.randCount();
                    for (int k = 0; k < GameField.mas.length; k++) {
                        System.out.print(GameField.mas[k] + " ");
                    }
                    System.out.println();
                    //перевірка на завершення гри
                    if (gameLogic.finishGame()) {
                        System.out.println();
                        System.out.println("Переміг комп");
                        f = true;
                        break;
                    }
                }
                if (j % 2 != 0) {
                    System.out.println("Введіть число від 1 до 9");
                    do {
                        a = in.nextInt();
                        if (GameField.mas[a - 1] == GameField.USER || GameField.mas[a - 1] == GameField.COMPUTER)
                            System.out.println("Клітинка зайнята. Введіть число від 1 до 9");
                    } while (GameField.mas[a - 1] != '-');
                    GameField.mas[a - 1] = GameField.USER;
                    if (gameLogic.finishGame()) {
                        for (int l = 0; l < GameField.mas.length; l++) {
                            System.out.print(GameField.mas[l] + " ");
                        }
                        System.out.println();
                        System.out.println("Переміг гравець");
                        f = true;
                        break;
                    }
                }
            }
        }
        //перевірка на нічию
        if (f == false)
            System.out.println("Нічия!");
    }
}