package com.javarush.task.task31.task3110;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }
    public void createZip(Path source) throws Exception{
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            String newSource = String.valueOf(source.getFileName());
            ZipEntry zipEntry = new ZipEntry(newSource);
            zipOutputStream.putNextEntry(zipEntry);
            try (InputStream newSourceStream = Files.newInputStream(source)) {
                while ((newSourceStream.available()) != 0) {
                    zipOutputStream.write(newSourceStream.read());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
