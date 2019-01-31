package main.java.com.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    Field field = new Field();
    Scanner in = new Scanner(System.in);
    private final char COMPUTER = 'O';
    private final char USER = 'X';
    static final String validInputChars[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private final String choiceFirstMove = "Хто ходитиме першим: Ви(натисніть 1) чи Комп'ютер(натисніть 2)?";
    private final String winUser = "Переміг гравець";
    private final String winComp = "Переміг компютер";
    private final String isDraw = "Нічия";
    private final String incorrectlyEnteredData = "Невірно введені дані";
    private final String enterCell = "Введіть число від 1 до 9";
    String validInputValues;
    int random;
    boolean flag;
    int cell;
    int inputNumber;
    int checkCell;
    boolean isWinner;

    GameLogic() {
        validInputValues = " ";
        random = -1;
        flag = false;
        cell = -1;
        inputNumber = -1;
        checkCell = -1;
        isWinner = false;
    }

    //random selection of cells by computer
    char randCount() {
        do {
            random = new Random().nextInt(field.getMas().length);
        } while (field.getMas()[random] != '-');
        field.getMas()[random] = COMPUTER;
        return field.getMas()[random];

    }

    //input our mas of data
    void inputMas() {
        for (int i = 0; i < field.getMas().length; i++) {
            System.out.print(field.getMas()[i] + " ");
        }
    }

    //validation check for data entry
    boolean checkValid() {
        validInputValues = in.next();
        flag = false;
        for (int i = 0; i < validInputChars.length; i++) {
            flag = new String(validInputValues).equals(validInputChars[i]);
            if (flag) {
                break;
            }
        }
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    //validation check for data entry and empty cell
    boolean checkIsEmpty() {
        validInputValues = in.next();
        flag = false;
        for (int i = 0; i < validInputChars.length; i++) {
            flag = new String(validInputValues).equals(validInputChars[i]);
            if (flag) {
                cell = Integer.parseInt(validInputValues);
                break;
            }
        }
        if ((flag) && cell <= 9 && cell >= 0) {
            if (field.getMas()[cell - 1] == '-') {
                return true;
            }
            return false;
        }
        return false;
    }

    //check if any of the players has won
    boolean checkWinner() {
        if ((field.getMas()[0] == field.getMas()[1]) && (field.getMas()[1] == field.getMas()[2]) &&
                (field.getMas()[0] != '-') && (field.getMas()[1] != '-') && (field.getMas()[2] != '-')) {
            return true;
        }
        if ((field.getMas()[3] == field.getMas()[4]) && (field.getMas()[4] == field.getMas()[5]) &&
                (field.getMas()[3] != '-') && (field.getMas()[4] != '-') && (field.getMas()[5] != '-')) {
            return true;
        }
        if ((field.getMas()[6] == field.getMas()[7]) && (field.getMas()[7] == field.getMas()[8]) &&
                (field.getMas()[6] != '-') && (field.getMas()[7] != '-') && (field.getMas()[8] != '-')) {
            return true;
        }
        if ((field.getMas()[0] == field.getMas()[3]) && (field.getMas()[3] == field.getMas()[6]) &&
                (field.getMas()[0] != '-') && (field.getMas()[3] != '-') && (field.getMas()[6] != '-')) {
            return true;
        }
        if ((field.getMas()[1] == field.getMas()[4]) && (field.getMas()[4] == field.getMas()[7]) &&
                (field.getMas()[1] != '-') && (field.getMas()[4] != '-') && (field.getMas()[7] != '-')) {
            return true;
        }
        if ((field.getMas()[2] == field.getMas()[5]) && (field.getMas()[5] == field.getMas()[8]) &&
                (field.getMas()[2] != '-') && (field.getMas()[5] != '-') && (field.getMas()[8] != '-')) {
            return true;
        }
        if ((field.getMas()[0] == field.getMas()[4]) && (field.getMas()[4] == field.getMas()[8]) &&
                (field.getMas()[0] != '-') && (field.getMas()[4] != '-') && (field.getMas()[8] != '-')) {
            return true;
        }
        if ((field.getMas()[6] == field.getMas()[4]) && (field.getMas()[4] == field.getMas()[2]) &&
                (field.getMas()[6] != '-') && (field.getMas()[4] != '-') && (field.getMas()[2] != '-')) {
            return true;
        }
        return false;
    }

    //method with start of game
    public void start() {
        //the choice who goes first
        do {
            System.out.println(choiceFirstMove);
            if (checkValid()) {
                inputNumber = Integer.parseInt(validInputValues);
                if (inputNumber != 1 && inputNumber != 2)
                    System.out.println(incorrectlyEnteredData);
            } else {
                inputNumber = -1;
                System.out.println(incorrectlyEnteredData);
            }
        } while (inputNumber != 1 && inputNumber != 2);
        int counter = field.getMas().length;
        //if you choose 1, you will be the first player
        if (inputNumber == 1) {
            for (int j = 0; j < counter; j++) {
                if (j % 2 == 0) {
                    System.out.println(enterCell);
                    //validation check for data entry and empty cell and and launching the loop for correct input
                    do {
                        checkCell = -1;
                        if (checkIsEmpty()) {
                            checkCell = Integer.parseInt(validInputValues);
                        } else {
                            System.out.println(incorrectlyEnteredData);
                        }
                    } while (checkCell < 0);
                    field.getMas()[checkCell - 1] = USER;
                    //Checking for the end of the game
                    if (checkWinner()) {
                        inputMas();
                        System.out.println();
                        System.out.println(winUser);
                        isWinner = true;
                        break;
                    }
                }
                if (j % 2 != 0) {
                    randCount();
                    inputMas();
                    System.out.println();
                    if (checkWinner()) {
                        System.out.println();
                        System.out.println(winComp);
                        isWinner = true;
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
                        System.out.println(winComp);
                        isWinner = true;
                        break;
                    }
                }
                if (j % 2 != 0) {
                    System.out.println(enterCell);
                    do {
                        checkCell = -1;
                        if (checkIsEmpty()) {
                            checkCell = Integer.parseInt(validInputValues);
                        } else {
                            System.out.println(incorrectlyEnteredData);
                        }
                    } while (checkCell < 0);
                    field.getMas()[checkCell - 1] = USER;
                    if (checkWinner()) {
                        inputMas();
                        System.out.println();
                        System.out.println(winUser);
                        isWinner = true;
                        break;
                    }
                }
            }
        }
        //check for a draw
        if (isWinner == false)
            System.out.println(isDraw);
    }
}
