package Java_Exceptions.HomeWork.HW3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler {

    public static void writeToFile(Person person, String fileName) throws IOException {
        if (!Files.exists(Paths.get(fileName))) {
            Files.createFile(Paths.get(fileName));
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write(person.toString());
            writer.newLine();
        }
    }
}
