package pl.sda.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class CSVWriter {
    void write(List<Person> persons, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String headerRow = "name;lastName;party\n";
            writer.write(headerRow);
            for (Person person : persons) {
                StringBuilder builder = new StringBuilder();
                builder.append(person.getName())
                        .append(";")
                        .append(person.getLastName())
                        .append(";")
                        .append(person.getParty())
                        .append("\n");
                writer.write(builder.toString());
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
