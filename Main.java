package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String s = in.nextLine ();
    }

    /*а) определяем является ли строка строкой "abcd111111102019"*/
    public static void one_1(String s) {
        System.out.println (Pattern.matches ("abcd1{7}02019", s));
    }

    /*б) выделяем из строки все натуральные десятеричные числа, создаем динамический массив, выводим сумму, макс и индекс макс*/
    public static void one_2(String s) {
        Pattern pattern = Pattern.compile ("[0-9]");
        Matcher matcher = pattern.matcher (s);
        System.out.println (matcher.toString ());
        matcher.find ();
        long sum = 0;
        long max = Long.parseLong (s.substring (matcher.start (), matcher.end ()));
        ArrayList<Long> chisla = new ArrayList<> ();
        chisla.add (max);
        while (matcher.find ()) {
            long i = Long.parseLong (s.substring (matcher.start (), matcher.end ()));
            if (i > max) max = i;
            sum += i;
            System.out.println (i);
            chisla.add (i);
        }
        System.out.println ("Сумма чисел: " + sum);
        System.out.println ("Максимальное число: " + max);
        System.out.println ("Индекс максимального числа: " + chisla.indexOf (max));
    }

    /*в) выделяем из строки десятичные числа и выводим полученный массив*/
    public static void one_3(String s) {
        Pattern pattern = Pattern.compile ("[0-9]*[.,][0-9]*");
        Matcher matcher = pattern.matcher (s);
        ArrayList<String> arrayList = new ArrayList<> ();
        while (matcher.find ()) {
            String i = s.substring (matcher.start (), matcher.end ());
            arrayList.add (i);
        }
        System.out.println (arrayList);
    }

    /*г) заменяем слова, состоящие больше, чем из 10 символов одной "*" */
    public static void one_4(String s) {
        Pattern pattern = Pattern.compile ("\\w{10,}");
        Matcher matcher = pattern.matcher (s);
        while (matcher.find ()) {
            s = matcher.replaceAll ("*");
        }
        System.out.println (s);
    }

    /*д) определяем, является ли строка GUID*/
    public static void one_5(String s) {

        System.out.println (Pattern.matches ("\\w{8}(-\\w{4}){3}-\\w{12}", s));
    }

    /*е) определяем, является ли строка шестнадцатиричным идентификатором цвета в HTML*/
    public static void one_6(String s) {

        System.out.println (Pattern.matches ("#[A-F0-9]{6}", s));
    }

    /*ж) выделяем в динамический массив и выводим имена всех папок из пути к файлу*/
    public static void one_7(String s) {
        Pattern pattern = Pattern.compile ("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher (s);
        ArrayList<String> files = new ArrayList<> ();
        while (matcher.find ()) {
            files.add (s.substring (matcher.start (), matcher.end ()));
        }
        System.out.println (files);
    }

    /*з) удаляем из текста все суффиксы “ик”*/
    public static void one_8(String s) {
        Pattern pattern = Pattern.compile ("[ик]");
        Matcher matcher = pattern.matcher (s);
        s = matcher.replaceAll ("");
        System.out.println (s);
    }

    /*3. регулярное выражение, определяющее является ли строка правильным MAC-адресом. */
    public static void three(String s) {
        System.out.println (Pattern.matches ("([a-fA-F0-9]{2}:){5}[a-fA-F0-9]{2}", s));
    }


    /*4. регулярное выражение, определяющее является ли данная строчка валидным URL адресом*/
    public static void four(String s) {
        System.out.println (Pattern.matches ("(https?://)?([a-zA-Z0-9])(([a-zA-Z0-9-])+\\.)+([a-z]{2,6})(:\\d+)?((/[a-zA-Z0-9]+)?)+/?(#[a-zA-Z0-9]+)?", s));
    }

    /*задание 5 вроде то же самое, что и пункт е в первом*/

    /*задание 6 не полное*/
    public static void six(String s) {
        Pattern pattern = Pattern.compile ("(0[1-9]|[12]\\d|3[01])/([0][1-9]|1[0-2])/((1[6-9]|[2-9]\\d)\\d{2})");
        Matcher matcher = pattern.matcher (s);
        matcher.find ();
        System.out.println (pattern.matcher (s));
    }

    //7. регулярное  выражение, определяющее является ли данная строчка валидным Email адресом согласно RFC под номером 2822.
    public static void seven(String s) {
        System.out.println (Pattern.matches ("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", s));
    }

    //8. регулярное выражение, определяющее является ли заданная строка IP адресом, записанным в десятичном виде.
    public static void eight(String s) {
        System.out.println (Pattern.matches (
                "(((2((5[0-5])|([0-4]\\d)))|(1?\\d?\\d))\\.){3}((2((5[0-5])|([0-4]\\d)))|(1?\\d?\\d))"
                , s));
    }


    //10. Проверить является ли заданная строка шестизначным числом, записанным в десятичной системе счисления без нулей в старших разрядах.
    public static void ten(String s) {
        System.out.println (Pattern.matches ("[1-9]\\d{5}", s));
    }

    //12. Проверить существуют ли в тексте цифры, за которыми не стоит «+».
    public static void twelve(String s) {
        Pattern pattern = Pattern.compile ("\\d[^+]");
        Matcher matcher = pattern.matcher (s);
        System.out.println (matcher.find ());
    }
}


