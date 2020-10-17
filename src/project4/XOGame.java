package project4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {

    static final int SIZE = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char [][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        int turnCount = 0;

        while (true) {
            humanTurn();
            printMap();
            turnCount ++;

            if(turnCount >= SIZE * SIZE) {
                System.out.println("Ничья");
                break;
            }
            if (checkWin(DOT_X)){
                System.out.println("Победа человека");
                break;
            }

            aiTurn();
            printMap();
            turnCount ++;

            if(turnCount >= SIZE * SIZE) {
                System.out.println("Ничья");
                break;
            }
            if (checkWin(DOT_O)){
                System.out.println("Победа робота");
                break;
            }

        }

    }


    public static void initMap (){
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap(){

        System.out.print("  ");

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 +" ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn (){
        int x,y;

        do {
            System.out.println("Введите координаты вашего хода X Y");

            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y,x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid (int y, int x){
        if(x < 0 || y < 0 || x >= SIZE || y >= SIZE){
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn (){
        int x, y;

        for (int i = 0; i < SIZE; i++) {
            for ( int j = 0; j < SIZE; j++) {

                if(map[i][j] == DOT_EMPTY) {

                    map[i][j] = DOT_O;
                    if(checkWin(DOT_O)){
                        return;
                    }else {
                        map[i][j] = DOT_EMPTY;
                    }

                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }

                }
            }
        }

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y,x));
        map[y][x] = DOT_O;

    }

    public static boolean checkWin (char c){
        int x = 0;
        int y = 0;

        // Horizontal check

        for (int i = 0; i < SIZE - 2; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[y][x] == c && map[y][x + 1] == c && map[y][x + 2] == c) {
                        return true;
                }
                y++;
            }
            x++;
            y = 0;
        }

        x = 0;
        y = 0;

        // Vertical check

        for (int i = 0; i < SIZE - 2; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[y][x] == c && map[y + 1][x] == c && map[y + 2][x] == c) {
                        return true;
                }
                x++;
            }
            y++;
            x = 0;
        }

        x = 0;
        y = 0;

        // Diagonal check by left to right

        for (int i = 0; i < SIZE - 2; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[y][x] == c && map[y + 1][x + 1] == c && map[y + 2][x + 2] == c){
                            return true;
                }
                x++;
            }
            y++;
            x = 0;
        }

        x = 2;
        y = 0;

        // Diagonal check by right to left

        for (int i = 0; i < SIZE - 2; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[y][x] == c && map[y + 1][x - 1] == c && map[y + 2][x - 2] == c){
                    return true;
                }
                x++;
            }
            y++;
            x = 2;
        } return false;

    }

}
