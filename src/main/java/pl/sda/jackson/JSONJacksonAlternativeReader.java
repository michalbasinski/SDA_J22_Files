package pl.sda.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import pl.sda.csv.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JSONJacksonAlternativeReader {
    List<Person> read(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String fileContents = new String(bytes, "UTF-8");

        ObjectMapper mapper = new ObjectMapper();

        CollectionType customType = mapper
                .getTypeFactory()
                .constructCollectionType(List.class, Person.class);

        List<Person> persons = mapper.readValue(fileContents, customType);

        return persons;
    }
}
