package pl.sda.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.csv.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class JSONJacksonWriter {
    void write(List<Person> persons, String filePath) throws IOException {
        Persons personsToWrite = new Persons();
        personsToWrite.setPersons(persons);

        ObjectMapper mapper = new ObjectMapper();
        String jsonToWrite = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(personsToWrite);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(jsonToWrite);
            bufferedWriter.flush();
        }
    }
}