package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к архиву и имя архива");
        String fileName = bufferedReader.readLine();
        Path path = Paths.get(fileName);
        ZipFileManager zipFileManager = new ZipFileManager(path);
        System.out.println("Выбирите фай для архивации");
        String fileNameLoad = bufferedReader.readLine();
        Path pathLoad = Paths.get(fileNameLoad);
        try {
            zipFileManager.createZip(pathLoad);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();

    }
}
