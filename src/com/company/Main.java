package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Замена элементов масива

        int[] arr1 = {1,1,0,0,1,0,1,0,0,1,1};

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
            System.out.print(" "+arr1[i]);
        }
        System.out.println();

        // Заполнение масива числами возростающими на 3

        int[] arr2 = new int[8];

        int a = 0;

        for (int i = 0; i < arr2.length; i++) {


            arr2[i] = a;
            a += 3;

            System.out.print(" "+ arr2[i]);
        }
        System.out.println();

        // Умножение на 2 всех элементов масива менше 6

        int[] arr3 = {1,5,3,2,11,4,5,2,4,8,9,1};

        for (int i = 0; i < arr3.length; i++) {

            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
            System.out.print(" "+arr3[i]);
        }
        System.out.println("\n");

        // Заполнение двухмерного масива по диагоналям

        int[][] arr4 = new int[5][5];

        for (int i = 0; i < arr4.length; i++) {

            for (int j = 0; j < arr4.length; j++) {
                if(i == j || i + j == arr4.length - 1){
                    arr4[i][j] = 1;
                }
                System.out.print(arr4[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        // Поиск максимального и минимального числа масива

        int[] arr5 = {8,4,5,23,5,10,56,3,2,12,33,5,23,};
        int MaxArrNumber = 0;
        int MinimalArrNumber = arr5[1];

        for (int i = 0; i < arr5.length; i++) {
            if (MaxArrNumber < arr5[i]) {
                MaxArrNumber = arr5[i];
            }
            if(MinimalArrNumber > arr5[i]){
                MinimalArrNumber = arr5[i];
            }
        }
        System.out.println("максимальное число масива - " + MaxArrNumber);
        System.out.println("минимальное число масива - " + MinimalArrNumber);

        int[] arr6 = {1,2,3,4,5,6,7};

        System.out.println(checkBalance(arr6));
        System.out.println(Arrays.toString(swipe(arr6,1)));

    }




    public static boolean checkBalance(int[] arr){
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }

        int halfArrSum = arrSum / 2;
        int newArrSum = 0;

        for (int i = 0; i < arr.length; i++) {
            newArrSum += arr[i];
            if(halfArrSum == newArrSum){
                return true;
            }
        }
        return false;
    }

    public static int[] swipe (int[] arr, int n){

        for (int i = 0; i < n; i++) {

        int helper = arr[0];

            for (int j = 0; j < arr.length - 1 ; j++) {
                  arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = helper;
        } return arr;
    }






}
