package Game;

import java.util.Random;

public class GameLogic {
    //рандомний вибір клітинки компютером
    char randCount() {
        int random;
        do {
            random = new Random().nextInt(GameField.mas.length);
        } while (GameField.mas[random] != '-');
        GameField.mas[random] = GameField.COMPUTER;
        return GameField.mas[random];
    }

    //перевірка, чи хтось із гравців не виграв
    boolean finishGame() {
        if ((GameField.mas[0] == GameField.mas[1]) && (GameField.mas[1] == GameField.mas[2]) &&
                (GameField.mas[0] != '-') && (GameField.mas[1] != '-') && (GameField.mas[2] != '-'))
            return true;
        else if ((GameField.mas[3] == GameField.mas[4]) && (GameField.mas[4] == GameField.mas[5]) &&
                (GameField.mas[3] != '-') && (GameField.mas[4] != '-') && (GameField.mas[5] != '-'))
            return true;
        else if ((GameField.mas[6] == GameField.mas[7]) && (GameField.mas[7] == GameField.mas[8]) &&
                (GameField.mas[6] != '-') && (GameField.mas[7] != '-') && (GameField.mas[8] != '-'))
            return true;
        else if ((GameField.mas[0] == GameField.mas[3]) && (GameField.mas[3] == GameField.mas[6]) &&
                (GameField.mas[0] != '-') && (GameField.mas[3] != '-') && (GameField.mas[6] != '-'))
            return true;
        else if ((GameField.mas[1] == GameField.mas[4]) && (GameField.mas[4] == GameField.mas[7]) &&
                (GameField.mas[1] != '-') && (GameField.mas[4] != '-') && (GameField.mas[7] != '-'))
            return true;
        else if ((GameField.mas[2] == GameField.mas[5]) && (GameField.mas[5] == GameField.mas[8]) &&
                (GameField.mas[2] != '-') && (GameField.mas[5] != '-') && (GameField.mas[8] != '-'))
            return true;
        else if ((GameField.mas[0] == GameField.mas[4]) && (GameField.mas[4] == GameField.mas[8]) &&
                (GameField.mas[0] != '-') && (GameField.mas[4] != '-') && (GameField.mas[8] != '-'))
            return true;
        else if ((GameField.mas[6] == GameField.mas[4]) && (GameField.mas[4] == GameField.mas[2]) &&
                (GameField.mas[6] != '-') && (GameField.mas[4] != '-') && (GameField.mas[2] != '-'))
            return true;
        else
            return false;
    }
}
