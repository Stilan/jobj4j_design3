package ru.job4j.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInput {
    public static void main(String[] args) {
        Path path = Paths.get("input.txt");
        try {
            String content = Files.readString(path).replace(" ", "_");
            Path filePath = Path.of("output.txt");
            Files.write(filePath, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
