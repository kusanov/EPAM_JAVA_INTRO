package com.company.epam.part3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.company.epam.part3.Part3.*;
import static com.company.epam.part3.Part3.creatingArraySentences;

public class MainRegex {
    public static void main(String[] args) throws IOException {
        //        Работа с регулярными выражениями (Pattern, Matcher)
//        1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
//        операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
//        отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
//        алфавиту.
        //считываем текст из файла в строку
        String addressText = "C:\\Users\\kusan\\IdeaProjects\\EPAM\\Fundamentals\\src\\com\\company\\epam\\part3\\text.txt";
        BufferedReader reader = new BufferedReader(new FileReader(addressText));
        StringBuilder str = new StringBuilder();
        String text = reader.readLine();
        while (text != null) {
            str.append(text);
            str.append(System.lineSeparator());
            text = reader.readLine();
        }
        reader.close();
        text = str.toString();
        char symbol = 'а';
        System.out.println("Исходный текст:");
        System.out.println(text);
        System.out.println("Абзацы текста отсортированы по количеству предложений в них:");
        String sortText = sortingParagraphs(text);
        System.out.println(sortText);
        System.out.println("\nПредложения текста отсортированы по длине слов в них:");
        String[] arraySentences = creatingArraySentences(sortText);
        for (int i = 0; i < arraySentences.length; i++) {
            System.out.println(sortingSentences(arraySentences[i]));
        }
        System.out.println("\nЛексемы в предложениях отсортированы по количеству вхождения символа '" + symbol + "':");
        for (int i = 0; i < arraySentences.length; i++) {
            System.out.println(sortedWordsCountSymbol(creatingArraySentences(text)[i], symbol));
        }

        //        2. Дана строка, содержащая следующий текст (xml-документ):
//<notes>
// <note id = "1">
// <to>Вася</to>
// <from>Света</from>
// <heading>Напоминание</heading>
// <body>Позвони мне завтра!</body>
// </note>
// <note id = "2">
// <to>Петя</to>
// <from>Маша</from>
// <heading>Важное напоминание</heading>
// <body/>
// </note>
//</notes>
//                Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
//                тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
//                нельзя.

        String addressText2 = "C:\\Users\\kusan\\IdeaProjects\\EPAM\\Fundamentals\\src\\com\\company\\epam\\part3\\text2.xml";
        BufferedReader reader2 = new BufferedReader(new FileReader(addressText2));
        String line = reader2.readLine();
        while (line != null) {
            System.out.println(line.trim());
            analysisXML(line);
            System.out.println();
            line = reader2.readLine();
        }
    }
}
