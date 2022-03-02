package com.company.epam.part5.textfile.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class TextFile {
    private String text;
    private File file;

    public TextFile(String text, File file) {
        this.text = text;
        this.file = file;
    }

    //создание текстового файла
    public Path createTextFile() {
        try {
            return Files.write(file.getFilePath(), Collections.singleton(text));
        } catch (Exception e) {
            System.out.println("Текстовый файл не создан: " + e);
            return null;
        }
    }

    //переименование файла
    public void renameFile(String newName) {
        java.io.File original = file.getFilePath().toFile();
        java.io.File newFile = null;
        try {
            newFile = file.getDirectory().getPath().resolve(newName + '.' + file.getType()).toFile();
        } catch (InvalidPathException e) {
            System.out.println("Новое имя файла введено некорректно: " + e);
        }
        //проверка переименования файла
        try {
            if (original.exists() && original.isFile() && original.canWrite()) {
                if (original.renameTo(newFile)) {
                    System.out.println("Файл переименован успешно.");
                    file.setFilePath(newFile.toPath());
                    file.setName(newName);
                } else {
                    System.out.println("Файл не переименован.");
                }
            } else {
                System.out.println("Файл не переименован.");
            }
        } catch (NullPointerException e) {
            System.out.println("Файл не переименован: " + e);
        }
    }

    //вывод в консоль содержимого текстового файла
    public void printTextFile() {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getFilePath().toString()))) {
            String str = reader.readLine();
            while (str != null) {
                text.append(str);
                text.append(System.lineSeparator());
                str = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка вывода файла в консоль: " + e);
        }
        System.out.println("Содержимое файла \"" + file.getFilePath().toString() + "\":\n" + text.toString());
    }

    //добавление текста в существующий текстовый файл
    public void addText(String textAdd) {
        try {
            Path filePath = Files.write(file.getFilePath(), textAdd.getBytes(), StandardOpenOption.APPEND);
            file.setFilePath(filePath);
            System.out.println("Текст успешно добавлен в файл \"" + file.getName() + '.' + file.getType() + "\".");
        } catch (NullPointerException | IOException e) {
            System.out.println("Текст не добавлен в файл: " + e);
        }
    }

    //удаление содерживого файла текстового файла
    public void deleteText() {
        try {
            Path filePath = Files.write(file.getFilePath(), Collections.singleton(""));
            file.setFilePath(filePath);
            System.out.println("Содерживое файла \"" + file.getName() + '.' + file.getType() + "\" успешно удалено.");
        } catch (NullPointerException | IOException e) {
            System.out.println("Ошибка удаления содержимого файла: " + e);
        }
    }

    //удаление текстового файла
    public void deleteFile() {
        java.io.File fileD = file.getFilePath().toFile();
        String nameFile = file.getName() + '.' + file.getType();
        if (fileD.delete()) {
            System.out.println("Файл \"" + nameFile + "\" успешно удален.");
        } else {
            System.out.println("Файл \"" + nameFile + "\" не обнаружен.");
        }
    }
}
