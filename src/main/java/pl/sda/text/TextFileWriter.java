package pl.sda.text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class TextFileWriter {
    void write(List<String> lines, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.write("\n");
            }
            writer.flush();
         } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
