package main.java.com.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class GameLogic extends Field {
    Scanner in = new Scanner(System.in);
    private final char COMPUTER = 'O';
    private final char USER = 'X';
    String validInputValues;
    static String masOfChar[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    //random selection of cells by computer
    char randCount() {
        int random;
        do {
            random = new Random().nextInt(getMas().length);
        } while (getMas()[random] != '-');
        getMas()[random] = COMPUTER;
        return getMas()[random];

    }

    //input our mas of data
    void inputMas() {
        for (int i = 0; i < getMas().length; i++) {
            System.out.print(getMas()[i] + " ");
        }
    }

    //validation check for data entry
    boolean checkValid() {
        validInputValues = in.next();
        boolean flag = false;
        for (int i = 0; i < masOfChar.length; i++) {
            flag = new String(validInputValues).equals(masOfChar[i]);
            if (flag)
                break;
        }
        if (flag)
            return true;
        else
            return false;
    }

    //validation check for data entry and empty cell
    boolean checkIsEmpty() {
        validInputValues = in.next();
        boolean flag = false;
        int cell = -1;
        for (int i = 0; i < masOfChar.length; i++) {
            flag = new String(validInputValues).equals(masOfChar[i]);
            if (flag) {
                cell = Integer.parseInt(validInputValues);
                break;
            }
        }
        if ((flag) && cell <= 9 && cell >= 0) {
            if (getMas()[cell - 1] == '-') {
                return true;
            }
            return false;
        } else
            return false;
    }

    //check if any of the players has won
    boolean checkWinner() {
        if ((getMas()[0] == getMas()[1]) && (getMas()[1] == getMas()[2]) &&
                (getMas()[0] != '-') && (getMas()[1] != '-') && (getMas()[2] != '-'))
            return true;
        else if ((getMas()[3] == getMas()[4]) && (getMas()[4] == getMas()[5]) &&
                (getMas()[3] != '-') && (getMas()[4] != '-') && (getMas()[5] != '-'))
            return true;
        else if ((getMas()[6] == getMas()[7]) && (getMas()[7] == getMas()[8]) &&
                (getMas()[6] != '-') && (getMas()[7] != '-') && (getMas()[8] != '-'))
            return true;
        else if ((getMas()[0] == getMas()[3]) && (getMas()[3] == getMas()[6]) &&
                (getMas()[0] != '-') && (getMas()[3] != '-') && (getMas()[6] != '-'))
            return true;
        else if ((getMas()[1] == getMas()[4]) && (getMas()[4] == getMas()[7]) &&
                (getMas()[1] != '-') && (getMas()[4] != '-') && (getMas()[7] != '-'))
            return true;
        else if ((getMas()[2] == getMas()[5]) && (getMas()[5] == getMas()[8]) &&
                (getMas()[2] != '-') && (getMas()[5] != '-') && (getMas()[8] != '-'))
            return true;
        else if ((getMas()[0] == getMas()[4]) && (getMas()[4] == getMas()[8]) &&
                (getMas()[0] != '-') && (getMas()[4] != '-') && (getMas()[8] != '-'))
            return true;
        else if ((getMas()[6] == getMas()[4]) && (getMas()[4] == getMas()[2]) &&
                (getMas()[6] != '-') && (getMas()[4] != '-') && (getMas()[2] != '-'))
            return true;
        else
            return false;
    }

    //method with start of game
    public void start() {
        int inputNumber = -1;
        int checkCell = -1;
        //the choice who goes first
        do {
            System.out.println("Хто ходитиме першим: Ви(натисніть 1) чи Комп'ютер(натисніть 2)?");
            if (checkValid()) {
                inputNumber = Integer.parseInt(validInputValues);
                if (inputNumber != 1 && inputNumber != 2)
                    System.out.println("Невірно введені дані");
            } else {
                inputNumber = -1;
                System.out.println("Невірно ввели дані");
            }
        } while (inputNumber != 1 && inputNumber != 2);
        int counter = getMas().length;
        boolean f = false;
        //if you choose 1, you will be the first player
        if (inputNumber == 1) {
            for (int j = 0; j < counter; j++) {
                if (j % 2 == 0) {
                    System.out.println("Введіть число від 1 до 9");
                    //validation check for data entry and empty cell and and launching the loop for correct input
                    do {
                        checkCell = -1;
                        if (checkIsEmpty()) {
                            checkCell = Integer.parseInt(validInputValues);
                        } else
                            System.out.println("Невірно введені дані");
                    } while (checkCell < 0);
                    getMas()[checkCell - 1] = USER;
                    //Checking for the end of the game
                    if (checkWinner()) {
                        inputMas();
                        System.out.println();
                        System.out.println("Переміг гравець");
                        f = true;
                        break;
                    }
                }
                if (j % 2 != 0) {
                    randCount();
                    inputMas();
                    System.out.println();
                    if (checkWinner()) {
                        System.out.println();
                        System.out.println("Переміг комп");
                        f = true;
                        break;
                    }
                }
            }
        }
        // if you select 2, the computer goes first
        if (inputNumber == 2) {
            for (int j = 0; j < counter; j++) {
                if (j % 2 == 0) {
                    randCount();
                    inputMas();
                    System.out.println();
                    //Checking for the end of the game
                    if (checkWinner()) {
                        System.out.println();
                        System.out.println("Переміг комп");
                        f = true;
                        break;
                    }
                }
                if (j % 2 != 0) {
                    System.out.println("Введіть число від 1 до 9");
                    do {
                        checkCell = -1;
                        if (checkIsEmpty()) {
                            checkCell = Integer.parseInt(validInputValues);
                        } else
                            System.out.println("Невірно введені дані");
                    } while (checkCell < 0);
                    getMas()[checkCell - 1] = USER;
                    if (checkWinner()) {
                        inputMas();
                        System.out.println();
                        System.out.println("Переміг гравець");
                        f = true;
                        break;
                    }
                }
            }
        }
        //check for a draw
        if (f == false)
            System.out.println("Нічия!");
    }
}
