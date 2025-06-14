package ru.job4j.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PathCreate {
    public static void main(String[] args) {
        Path directory = Paths.get("example_dir");

        try {
            // Создаём директорию, если её нет
            if (Files.notExists(directory)) {
                Files.createDirectory(directory);
            }

            // Создаём файл info.txt внутри example_dir
            Path filePath = directory.resolve("info.txt");

            // Получаем текущую директорию
            Path currentDir = Paths.get("").toAbsolutePath();

            // Список строк для записи
            List<String> entries = new ArrayList<>();

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentDir)) {
                for (Path entry : stream) {
                    entries.add(entry.getFileName().toString());
                }
            }

            // Записываем список файлов и папок в info.txt
            Files.write(filePath, entries, StandardCharsets.UTF_8);

            System.out.println("Готово! Список файлов записан в " + filePath.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
