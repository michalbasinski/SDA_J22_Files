package pl.sda.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.csv.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class JSONJacksonReader {
    List<Person> read(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String fileContents = new String(bytes, "UTF-8");

        ObjectMapper mapper = new ObjectMapper();

        Persons persons = mapper.readValue(fileContents, Persons.class);

        return persons.getPersons();
    }
}
