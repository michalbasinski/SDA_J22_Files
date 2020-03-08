package pl.sda.text;

import java.util.List;

class App {
    public static void main(String[] args) {
        TextFileReader reader = new TextFileReader();

        List<String> content = reader.read("/home/michal/SDA/Java22/Projekty/SDA_J22_Files/src/main/resources/test.txt");

        TextFileWriter writer = new TextFileWriter();
        writer.write(content, "/home/michal/text.txt");
    }
}
