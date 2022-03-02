package com.company.epam.part5.textfile.main;

import com.company.epam.part5.textfile.entity.Directory;
import com.company.epam.part5.textfile.entity.File;
import com.company.epam.part5.textfile.entity.TextFile;

public class MainTextFile {
    public static void main(String[] args) {

//        Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//                вывести на консоль содержимое, дополнить, удалить.

        String text1 = "Гадание на Крещение.\n" +
                "Если ты хочешь, чтобы у тебя было все хорошо, положи в ночь на Крещение под подушку шоколад...";
        String text2 = "И утром у тебя все будет в шоколаде)\n";
        Directory directory = new Directory("src\\com\\company\\epam\\part5\\textFile");
        File file = new File("text", "txt", directory);
        TextFile textFile = new TextFile(text1, file);
        textFile.createTextFile();
        textFile.renameFile("анекдот");
        textFile.printTextFile();
        textFile.addText(text2);
        textFile.deleteText();
        textFile.deleteFile();
    }
}
