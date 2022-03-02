package com.company.epam.part3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    static void snake_case(String array[]) {
        for (int i = 0; i < array.length; i++) {
            char[] charArr = array[i].toCharArray();
            int idTemp = 0;
//находим в массиве заглавную букву, понижаем ее регистр и запоминаем порядковый номер данного символа
            for (int j = 0; j < charArr.length; j++) {
                if (Character.isUpperCase(charArr[j])) {
                    charArr[j] = Character.toLowerCase(charArr[j]);
                    idTemp = j;
                }
            }
            //создаем новый массив символов, заполняем его символами из charArr и добовляем символ '_'
            char[] charArrNew = new char[charArr.length + 1];
            for (int j = 0; j < charArrNew.length; j++) {
                if (j < idTemp) {
                    charArrNew[j] = charArr[j];
                } else if (j == idTemp) {
                    charArrNew[j] = '_';
                } else {
                    charArrNew[j] = charArr[j - 1];
                }
            }
            array[i] = new String(charArrNew);
        }
        System.out.println("Модифицированный массив строк: " + Arrays.toString(array));
    }

    static void word_letter(String str) {
        char[] charArr = str.toCharArray();
        int countWord = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'w' && charArr[i + 1] == 'o' && charArr[i + 2] == 'r' && charArr[i + 3] == 'd') {
                countWord++;//находим количество вхождений word
            }
        }
        //Создадим новый массив символов и заменим word на letter
        char[] charArrNew = new char[charArr.length + (countWord * 2)]; //word короче letter на 2 символа
        int j = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'w' && charArr[i + 1] == 'o' && charArr[i + 2] == 'r' && charArr[i + 3] == 'd') {
                charArrNew[j] = 'l';
                charArrNew[j + 1] = 'e';
                charArrNew[j + 2] = 't';
                charArrNew[j + 3] = 't';
                charArrNew[j + 4] = 'e';
                charArrNew[j + 5] = 'r';
                i = i + 3;
                j = j + 5;
            } else {
                charArrNew[j] = charArr[i];
            }
            j++;
        }
        str = new String(charArrNew);
        System.out.println("Измененная строка: " + str);
    }

    static void amountOfDigits(String str) {

        char[] charArr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                count++;
            }
        }
        System.out.println("Строка '" + str + "' содержит " + count + " цифр");
    }

    static void amountOfNumbers(String str) {
        char[] charArr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {//начало числа
                count++;
                for (int j = i + 1; j < charArr.length; j++) {//находим конец числа
                    if (Character.isDigit(charArr[j])) {
                        i = j;
                    } else break;
                }
            }
        }
        System.out.println("Строка '" + str + "' содержит " + count + " чисел");
    }

    public static void spaces(String str) {
        int count = 0;
        char[] charArr = str.trim().toCharArray();//удаляем пробелы в начале и в конце строки
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                while (charArr[i + 1] == ' ') {
                    count++;
                    i++;
                }
            }
        }
        //создаем новый массив за вычетом лишних пробелов
        char[] charArrNew = new char[charArr.length - count];
        int j = 0;
        for (int i = 0; i < charArr.length; i++) {
            charArrNew[j] = charArr[i];
            if (charArr[i] == ' ') {
                while (charArr[i + 1] == ' ') {
                    i++;
                }
            }
            j++;
        }
        str = new String(charArrNew);
        System.out.println(str);
    }

    static void numbersOfSpaces(String str) {
        char symbol = ' ';
        int length = str.length();
        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == symbol) {
                int count = 1;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == symbol) {
                        count++;
                    } else break;
                }
                maxCount = (count > maxCount) ? count : maxCount;
            }
        }
        System.out.println("В строке \"" + str + "\" наибольшее количество подряд идущих пробелов равно " + maxCount);
    }
    static void ab (StringBuilder str) {
        char symbol = 'a';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                str.insert((i + 1), 'b');
            }
        }
        System.out.println("Измененная строка - \"" + str + "\"");
    }

    // 1. отсортировать абзацы по количеству предложений;
    public static String sortingParagraphs(String text) {
        //разбиваем текст на абзацы и создаем массив
        String[] paragraphsArr = text.split("\\r?\\n");
        //поиск предложений по заглавным буква (начало) и знакам препинания (конец)
        Pattern patternSentence = Pattern.compile("[A-ZА-Я][^!.?]+[!.?]");
        boolean sorted = true;
        int countFirst = 0;
        int countSecond = 0;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < paragraphsArr.length - 1; i++) {
                Matcher matcherFirst = patternSentence.matcher(paragraphsArr[i]);
                while (matcherFirst.find()) {
                    countFirst++;
                }
                Matcher matcherSecond = patternSentence.matcher(paragraphsArr[i + 1]);
                while (matcherSecond.find()) {
                    countSecond++;
                }
                if (countFirst > countSecond) {
                    String tempStr = paragraphsArr[i];
                    paragraphsArr[i] = paragraphsArr[i + 1];
                    paragraphsArr[i + 1] = tempStr;
                    sorted = true;
                }
                countFirst = 0;
                countSecond = 0;
            }
        }
        StringBuilder sortParagraph = new StringBuilder();
        for (int i = 0; i < paragraphsArr.length; i++) {
            sortParagraph.append(paragraphsArr[i] + "\n");
        }
        return sortParagraph.toString().trim();
    }

    //Создадим массив из предложений текста
    public static String[] creatingArraySentences(String text) {
        Pattern patternSentence = Pattern.compile("[A-ZА-Я][^!.?]+[!.?]");
        Matcher matcher = patternSentence.matcher(text);
        int count = 0;
        while (matcher.find()) {//подсчитываем количество предложений в тексте
            count++;
        }
        matcher = patternSentence.matcher(text);
        String[] arraySentence = new String[count];
        int id = 0;
        while (matcher.find()) {
            arraySentence[id] = matcher.group();
            id++;
        }
        return arraySentence;
    }

    //2. в каждом предложении отсортировать слова по длине;
    public static String sortingSentences(String sentence) {
        //шаблон для поиска слов и массив из найденых слов

        Pattern patternSymbol = Pattern.compile("[A-ZА-Яa-zа-я0-9]+");
        Matcher matcherSymbol = patternSymbol.matcher(sentence);
        StringBuilder builder = new StringBuilder();
        while (matcherSymbol.find()) {
            builder.append(new StringBuffer(matcherSymbol.group()) + " ");
        }
        String[] sentenceArr = builder.toString().trim().split(" ");
        Arrays.sort(sentenceArr, Comparator.comparing(String::length));
        StringBuilder sortSentence = new StringBuilder();
        for (int i = 0; i < sentenceArr.length; i++) {
            sortSentence.append(sentenceArr[i] + " ");
        }
        return sortSentence.toString().trim();
    }

    //3. отсортировать лексемы в предложении по убыванию количества вхождений заданного символа,
    //  а в случае равенства – по алфавиту.
    public static String sortedWordsCountSymbol(String sentence, char symbol) {
        Pattern patternSymbol = Pattern.compile("[A-ZА-Яa-zа-я0-9]+");
        Matcher matcherSymbol = patternSymbol.matcher(sentence);
        StringBuilder builder = new StringBuilder();
        while (matcherSymbol.find()) {
            builder.append(new StringBuffer(matcherSymbol.group()) + " ");
        }
        int countFirst = 0;
        int countSecond = 0;
        String[] wordsArray = builder.toString().trim().split(" ");
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < wordsArray.length - 1; i++) {
                for (int j = 0; j < wordsArray[i].length(); j++) {
                    if (wordsArray[i].charAt(j) == symbol) {
                        countFirst++;
                    }
                }
                for (int k = 0; k < wordsArray[i + 1].length(); k++) {
                    if (wordsArray[i + 1].charAt(k) == symbol) {
                        countSecond++;
                    }
                }
                if (countFirst <= countSecond) {
                    if (countFirst < countSecond) {
                        String temp = wordsArray[i];
                        wordsArray[i] = wordsArray[i + 1];
                        wordsArray[i + 1] = temp;
                        sorted = true;
                    } else {
                        if (wordsArray[i].toLowerCase(Locale.ROOT).compareTo(wordsArray[i + 1].toLowerCase(Locale.ROOT)) > 0) {
                            String temp = wordsArray[i];
                            wordsArray[i] = wordsArray[i + 1];
                            wordsArray[i + 1] = temp;
                            sorted = true;
                        }
                    }
                }
                countFirst = 0;
                countSecond = 0;
            }
        }
        StringBuilder sortWord = new StringBuilder();
        for (int i = 0; i < wordsArray.length; i++) {
            sortWord.append(wordsArray[i] + " ");
        }
        return sortWord.toString().trim();
    }
    static void analysisXML(String line) {
        String openingTag = "^<\\w+>$";
        String closingTag = "^</\\w+>$";
        String emptyTag = "^<\\w+/>$";
        String contentTag = "(<.+>)(.+)(</.+>)";
        //String tagAttribute = "<[\\w\\s=]+\".+\">";
        String tagAttribute = "(<\\w+\\s+)(\\w+)([\\s=\\s\"]+)(.+)(\">)";
        Pattern patternContent = Pattern.compile(contentTag);
        Matcher matcherContent = patternContent.matcher(line.trim());
        if (matcherContent.find()) {
            System.out.print(matcherContent.group(1) + " - открывающий тег, ");
            System.out.print(matcherContent.group(2) + " - содержимое тега (значение элемента), ");
            System.out.println(matcherContent.group(3) + " - закрывающий тег");
        }
        Pattern patternOpening = Pattern.compile(openingTag);
        Matcher matherOpening = patternOpening.matcher(line.trim());
        if (matherOpening.find()) {
            System.out.println(matherOpening.group() + " - открывающий тег");
        }
        Pattern patternClosing = Pattern.compile(closingTag);
        Matcher matcherClosing = patternClosing.matcher(line.trim());
        if (matcherClosing.find()) {
            System.out.println(matcherClosing.group() + " - закрывающий тег");
        }
        Pattern patternEmpty = Pattern.compile(emptyTag);
        Matcher matcherEmpty = patternEmpty.matcher(line.trim());
        if (matcherEmpty.find()) {
            System.out.println(matcherEmpty.group() + " - тег без тела");
        }
        Pattern patternAttribute = Pattern.compile(tagAttribute);
        Matcher matcherAttribute = patternAttribute.matcher(line.trim());
        if (matcherAttribute.find()) {
            System.out.print(matcherAttribute.group(0) + " - открывающий тег с атрибутом: ");
            System.out.print(matcherAttribute.group(2) + " - название атрибута, ");
            System.out.println(matcherAttribute.group(4) + " - значение атрибута");
        }
    }
}