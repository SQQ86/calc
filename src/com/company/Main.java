package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String inp = scan.nextLine();
        System.out.println(calc(inp));


    }

    public static String calc(String input) throws Exception {
        String[] inp = input.split(" ");
        if(inp.length>3 || inp.length==2) {
            try{
                throw new IOException();
            }
            catch (IOException e){
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(1);
            }

        }
        if(inp.length==1){
            try{
                throw new IOException();
            }
            catch (IOException e){
                System.out.println("throws Exception //т.к. строка не является математической операцией");
                System.exit(1);
            }
        }
        String done = "";
        String done2 = "";
        String regex = "[0-9]+";
        if(inp[1].charAt(0)!=43 & inp[1].charAt(0)!=42 & inp[1].charAt(0)!=45 & inp[1].charAt(0)!=47){
            try {
                throw new IOException();
            }
            catch (IOException e){
                System.out.println("throws Exception //т.к. неверно указан оператор");
                System.exit(1);
            }
        }
        if((inp[0].matches(regex)&!inp[2].matches(regex)) || (!inp[0].matches(regex)&inp[2].matches(regex)))
            try {
                throw new IOException();
            }
        catch (IOException e ){
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            System.exit(1);
        }
        if (inp[0].matches(regex) && inp[2].matches(regex)) {
            int a = Integer.parseInt(inp[0]);
            char b = inp[1].charAt(0);
            int c = Integer.parseInt(inp[2]);
            if (a>10 || c >10 || a<1 || c<1) {
                try {
                    throw new IOException();

                } catch (IOException e) {
                    System.out.println("Ошибка: Введите арабские числа от 1 до 10");
                    System.exit(1);
                }
            }
            if (b == 43) {
                done = String.valueOf(a + c);
            }
            if (b == 42) {
                done = String.valueOf(a * c);
            }
            if (b == 45) {
                done = String.valueOf(a - c);
            }
            if (b == 47) {
                done = String.valueOf(a / c);
            }
            return done;
        }




        String[] rome = new String[101];
        rome[1] = "I";
        rome[2] = "II";
        rome[3] = "III";
        rome[4] = "IV";
        rome[5] = "V";
        rome[6] = "VI";
        rome[7] = "VII";
        rome[8] = "VIII";
        rome[9] = "IX";
        rome[10] = "X";
        rome[40] = "XL";
        rome[50] = "L";
        rome[90] = "XC";
        rome[100] = "C";
        for (int i = 1; i < 30; i++) {
            rome[i + 10] = rome[10] + rome[i];
        }
        for (int i = 1; i < 10; i++) {
            rome[40 + i] = rome[40] + rome[i];
        }
        for (int i = 1; i < 40; i++) {
            rome[50 + i] = rome[50] + rome[i];
        }
        for (int i = 1; i < 10; i++) {
            rome[90 + i] = rome[90] + rome[i];
        }
        int a = 0, c = 0;
        char b = inp[1].charAt(0);
        for (int i = 1; i <= 100; i++) {
            if (rome[i].equals(inp[0])) {
                a = i;
            }

        }

        for (int i = 1; i <= 100; i++) {
            if (rome[i].equals(inp[2])) {
                c = i;

            }

        }
        int buf =0;
        if (a != 0 && c != 0) {
            if (b == 43) {
                buf = (a + c);
            }
            if (b == 42) {
                buf = (a * c);
            }
            if (b == 45) {
                buf = (a - c);
            }
            if (b == 47) {
                buf = (a / c);
            }
        }




            if (a>10 || c >10) {
                try {
                    throw new IOException();

                } catch (IOException e) {
                    System.out.println("Ошибка: Введите римские числа от I до X");
                    System.exit(1);
                }
            }
            if (buf<=0){
                try {
                    throw new IOException();

                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    System.exit(1);
                }
            }


        return rome[buf];


    }
}
