package pl.sda.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CSVReader {
    List<Person> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            List<Person> persons = new ArrayList<>();
            int lineCounter = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (lineCounter == 0) {
                    lineCounter++;
                    continue;
                } else {
                    String[] personData = line.split(";");
                    String name = personData[0];
                    String lastName = personData[1];
                    String party = personData[2];
                    Person person = new Person(name, lastName, party);
                    persons.add(person);
                }
            }
            return persons;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
