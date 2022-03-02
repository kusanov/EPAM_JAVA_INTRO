package com.company.epam.part5.textfile.entity;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {
    private String name;
    private String type;
    private Directory directory;
    private Path filePath;

    public File(String name, String type, Directory directory) {
        this.name = name;
        this.type = type;
        this.directory = directory;
        this.filePath = createFile();
    }

    //создание файла
    public Path createFile() {
        String filePath = directory.getPath() + "\\" + name + '.' + type;
        try {
            return Files.createFile(Paths.get(filePath));
        } catch (FileAlreadyExistsException e) {
            System.out.println("Файл \"" + filePath + "\" уже существует.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }
}
