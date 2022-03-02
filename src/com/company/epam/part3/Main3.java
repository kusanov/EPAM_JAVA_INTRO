package com.company.epam.part3;


import java.io.*;
import java.util.Arrays;
import static com.company.epam.part3.Part3.*;

public class Main3 {


    public static void main(String[] args) {

//        Работа со строкой как с массивом символов
//        1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
        String[] strArray1 = new String[]{"sergeiKusanov", "epamCompany", "webDeveloper"};
        System.out.println("Исходный массив строк: " + Arrays.toString(strArray1));
        snake_case(strArray1);

//        2. Замените в строке все вхождения 'word' на 'letter'.
        String str2 = "wordSergei_wordKusanovword";
        System.out.println("Исходная строка: " + str2);
        word_letter(str2);

//        3. В строке найти количество цифр.
        String str3 = "19/02/2022";
        amountOfDigits(str3);

//        4. В строке найти количество чисел.
        String str4 = "Happy New Year 2022! 1 22 333 4444 55555";
        amountOfNumbers(str4);

//        5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
//        Крайние пробелы в строке удалить.
        String str5 = "  Happy New   Year 2022! 1 22  333   4444    55555  ";
        spaces(str5);

//        Работа со строкой как с объектом типа String или StringBuilder
//        1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
        String str6 = "     java web  developer       string     ";
        numbersOfSpaces(str6);

//        2. В строке вставить после каждого символа 'a' символ 'b'.
        StringBuilder str7 = new StringBuilder("a aa java web developer aaaa string");
        System.out.println("Исходная строка - \"" + str7 + "\"");
        ab(str7);

//        3. Проверить, является ли заданное слово палиндромом.
        String str8 = "Казак";
        StringBuilder palindrome = new StringBuilder(str8).reverse();
        System.out.print("Слово \"" + str8 + "\" ");
        if (str8.equalsIgnoreCase(palindrome.toString())) {
            System.out.println("является полиндромом");
        } else {
            System.out.println("не является полиндромом");
        }

//        4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
        String str9 = "информатика";
        String cake = str9.charAt(7) + str9.substring(3, 5) + str9.charAt(7);
        System.out.println("Новое слово - \"" + cake + "\"");

//        5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
        String str10 = "a aa java web developer AAAA string";
        int count = 0;
        //найдем общее количество букв 'a' в верхнем и нижнем регистрах, латиницей и кириллицей
        for (int i = 0; i < str10.length(); i++) {
            if (str10.charAt(i) == 'a' || str10.charAt(i) == 'A' || str10.charAt(i) == 'а' || str10.charAt(i) == 'А') {
                count++;
            }
        }
        System.out.println("В строке \"" + str10 + "\" встречается " + count + " букв \"a\"");

//        6. Из заданной строки получить новую, повторив каждый символ дважды.
        String str11 = "java web developer";
        String strNew6 = new String();
        for (int i = 0; i < str11.length(); i++) {
            strNew6 = strNew6 + str11.charAt(i) + str11.charAt(i);
        }
        System.out.println("Исходная строка - \"" + str11 + "\"");
        System.out.println("Измененная строка - \"" + strNew6 + "\"");

//        7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
//        def", то должно быть выведено "abcdef".
        String str12 = "  aazzzb deeeef cbaff  kvgjuc ";
        StringBuilder newStr12 = new StringBuilder(str12.replace(" ", ""));
        //удаляем повторяющиеся символы в строке
        for (int i = 0; i < newStr12.length(); i++) {
            for (int j = newStr12.length() - 1; j > i; j--) {
                if (newStr12.charAt(i) == newStr12.charAt(j)) {
                    newStr12.deleteCharAt(j);
                }
            }
        }
        System.out.println("Измененная строка - \"" + newStr12 + "\"");

//        8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
//        длинных слов может быть несколько, не обрабатывать.
        //Вариант без использования регулярного выражения
        String startString = "java web  developer";
        String strNew = startString.trim().replaceAll("\\s+", " ");
        System.out.println("Заданная строка - \"" + strNew + "\"");
        int begin = 0;
        int end = 0;
        int length = 0;
        int maxLengthWord = 0;
        int idBegin = 0;
        int idEnd = 0;
        int countWord = 1;
        for (int i = 0; i < strNew.length(); i++) { //подсчитываем количество слов в строке
            if (strNew.charAt(i) == ' ') {
                countWord++;
            }
        }
        int[] lengthWord = new int[countWord];
        //ищем максимальное по длине слова, индексы начало и конца самого длинного слова
        for (int i = 0; i < strNew.length(); ) {
            for (int j = 0; j < lengthWord.length; j++) {
                begin = i;
                if (strNew.indexOf(' ', i + 1) != -1) {
                    end = strNew.indexOf(' ', i + 1);
                } else {
                    end = strNew.length();
                }
                length = end - begin;
                lengthWord[j] = length;
                if (length > maxLengthWord) {
                    maxLengthWord = length;
                    idBegin = begin;
                    idEnd = end;
                }
                i = end + 1;
            }
        }
        int countTemp = 0;
        for (int i = 0; i < lengthWord.length; i++) {
            if (maxLengthWord == lengthWord[i]) {
                countTemp++;
            }
            if (countTemp > 1) break;
        }
        if (countTemp == 1) {
            String maxWord = strNew.substring(idBegin, idEnd);
            System.out.println("Самое длинное слово из " + countWord + " в строке - \"" + maxWord + "\"");
        }

//        9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
//        буквы.
        String str13 = "JaVa wEb  DeveloPer";
        System.out.println("Задана строка - \"" + str13 + "\"");
        int countUpper = 0;
        int countLower = 0;
        for (int i = 0; i < str13.length(); i++) {
            if (str13.charAt(i) >= 'a' && str13.charAt(i) <= 'z') {
                countLower++;
            } else if (str13.charAt(i) >= 'A' && str13.charAt(i) <= 'Z') {
                countUpper++;
            } else continue;
        }
        System.out.println("Количество строчных букв - " + countLower + ", количество прописных букв - " + countUpper);

//        10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
//        знаком. Определить количество предложений в строке X.
        String str14 = "Hello! How are you? - " +
                "Hello! Thank you. I'm fine!";
        int count10 = 0;
        for (int i = 0; i < str14.length(); i++) {
            if (str14.charAt(i) == '!' || str14.charAt(i) == '?' || str14.charAt(i) == '.') {
                count10++;
            }
        }
        System.out.println("Исходная строка - \"" + str14 + "\"");
        System.out.println("Количество предложений в строке - " + count10);
    }
}