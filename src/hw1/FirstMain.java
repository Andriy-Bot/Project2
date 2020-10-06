package hw1;

import java.util.*;

public class FirstMain {
    static Scanner sc;


    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Random random = new Random();

//
//        int answer;
//        int counter = 0;
//
//        do {
//            int RandomNum = random.nextInt(10);
//            System.out.println("Угадайте цыфру от 0 до 9, у вас есть 3 попытки");
//
//            for (int i = 0; i < 4; i++) {
//
//                int x = sc.nextInt();
//
//                if (counter == 3) {
//                    System.out.println("У вас не осталось попыток");
//                    break;
//                }
//
//                if (x == RandomNum) {
//                    System.out.println("Вы угадали");
//                    break;
//                }
//                if (x > RandomNum) {
//                    System.out.println("Слишком большая цыфра");
//                }
//                if (x < RandomNum) {
//                    System.out.println("Слишком маленькая цыфра");
//                }
//                counter++;
//            }
//            System.out.println("Пофтоить попытку 1 да, 0 нет");
//
//            answer = sc.nextInt();
//
//        } while (answer == 1);


        String[] words = {"apple","orange","lemon","banana","apricot","avocado","broccoli",
                "carrot","cherry","garlic","grape","melon","leak","kiwi","mango","mushroom","nut","olive","pea","peanut",
                "pear","pepper","pineapple","pumpkin","potato"};

           String RandomWord = words[random.nextInt(24)];
           System.out.println(RandomWord);


        char[] ch2 = new char [15];
        for (int i = 0; i < 15; i++) {
            ch2[i] = '#';
        }

        for (int j = 0; j < 1;) {

            char[] ch = new char[15];
            char[] ch1 = new char[15];
            String AnswerWord = sc.next();

            if(RandomWord.equals(AnswerWord)){
                System.out.println("Yuo have right");
                break;
            }else{


                for (int i = 0; i < 15; i++) {
                    ch[i] = '#';
                    ch1[i] = '#';
                }

                for (int i = 0; i < RandomWord.length(); i++) {
                    ch[i] = RandomWord.charAt(i);
                    //System.out.println(ch[i]);
                }

                for (int i = 0; i < AnswerWord.length(); i++) {
                    ch1[i] = AnswerWord.charAt(i);
                    //System.out.println(ch1[i]);
                }

                for (int i = 0; i < 15; i++) {
                    if(ch2[i] != '#' || ch[i] == ch1[i]){
                        ch2[i] = ch[i];
                    }
                     else {
                        ch2[i] = '#';
                    }
                    System.out.print(ch2[i]);
                }
                System.out.println();
            }




        }









    }

}

