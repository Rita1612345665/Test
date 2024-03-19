package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

import static org.example.Arim.I;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //получение строки от пользователя
        String input = sc.nextLine(); // присвоить значение от пользователя строке ввод
        String resultat = calc(input);
        System.out.println(resultat);
    }

    static String calc(String input) {
        String[] simvols = input.split(" "); // массив символс присваивает подстроки между пробелами
        if (simvols.length == 3) {
            boolean isRimOne = isRim(simvols[0]); //возвращает римскость
            boolean isRimTwo = isRim(simvols[2]);
            boolean isArabOne = isArab(simvols[0]); //возвращает арабскость
            boolean isArabTwo = isArab(simvols[2]);
            int one;
            int two;
            if (isArabTwo && isArabOne) {
                one = getIntFromArab(simvols[0]); //возвращает число из строки арабских
                two = getIntFromArab(simvols[2]);
            } else if (isRimOne && isRimTwo) {
                one = getIntFromRim(simvols[0]); //возвращает число из строки римских
                two = getIntFromRim(simvols[2]);
            } else {
                throw new IllegalArgumentException("Введены неверные значения");
            }
            int x;

            if (((one > 0) && (one < 11)) && ((two > 0) && (two < 11))) {
                switch (simvols[1]) { //проверка действий
                    case ("+"):
                        x = one + two;
                        break;
                    case ("-"):
                        x = one - two;
                        break;
                    case ("*"):
                        x = one * two;
                        break;
                    case ("/"):
                        x = one / two;
                        break;
                    default:
                        throw new IllegalArgumentException("Введен неверный символ"); // исключение
                }
                if (isArabTwo && isArabOne) {
                    return String.valueOf(x);
                } else {
                    return getStringFromRim(x);

                }
            } else {
                throw new IllegalArgumentException("Введено неверное число"); //исключение
            }
        } else {
            throw new IllegalArgumentException("Введено больше 2 операндов");
        }
    }

    private static String getStringFromRim(int x) { //метод для перевода из римского числа в арабскую строку
        if (x > 0) {
            int edin = x % 10; //edinitsi
            int des = (x % 100) / 10; //desyatki
            int sot = (x % 1000) / 100; //sotni
            return sot(sot)+des (des)+edin(edin);
        } else {
            throw new IllegalArgumentException("Отрицательный результат");
        }
    }
    
    public static String edin ( int edin){ //перевод единиц
        String edinStr = "";
        switch (edin) {
            case 1:
                edinStr = "I";
                break;
            case 2:
                edinStr = "II";
                break;
            case 3:
                edinStr = "III";
                break;
            case 4:
                edinStr = "IV";
                break;
            case 5:
                edinStr = "V";
                break;
            case 6:
                edinStr = "VI";
                break;
            case 7:
                edinStr = "VII";
                break;
            case 8:
                edinStr = "VIII";
                break;
            case 9:
                edinStr = "IX";
                break;
        }
        return edinStr;
    }
    public static String des ( int des){ //перевод десяток
        String desStr = "";
        switch (des) {
            case 1:
                desStr = "X";
                break;
            case 2:
                desStr = "XX";
                break;
            case 3:
                desStr = "XXX";
                break;
            case 4:
                desStr = "XL";
                break;
            case 5:
                desStr = "L";
                break;
            case 6:
                desStr = "LX";
                break;
            case 7:
                desStr = "LXX";
                break;
            case 8:
                desStr = "LXXX";
                break;
            case 9:
                desStr = "XC";
                break;
        }
        return desStr;
    }
    public static String sot( int sot){ //перевод сотен
        String sotStr = "";
        switch (sot){
            case 1: sotStr = "C";
                break;
        }
        return sotStr;
    }

    private static int getIntFromRim(String simvol) { //вернуть из римской строки арабское число
        Arim arim = Arim.valueOf(simvol);
        return arim.getNumber();
    }

    private static int getIntFromArab(String simvol) { //вернуть из арабской строки арабское число
        return Integer.parseInt(simvol);
    }

    private static boolean isArab(String simvol) { //вернуть тру если числа арабские
        try {
            Integer.parseInt(simvol);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isRim(String simvol) { //вернуть тру если числа римские
        try {
            Arim.valueOf(simvol);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


}