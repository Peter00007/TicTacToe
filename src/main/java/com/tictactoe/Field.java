package main.java.com.tictactoe;


public class Field {
    private char mas[];
    Field() {
        mas = new char[]{'-', '-', '-', '-', '-', '-', '-', '-', '-'};
    }
    public char[] getMas() {
        return mas;
    }

    public void setMas(char[] mas) {
        this.mas = mas;
    }
}
