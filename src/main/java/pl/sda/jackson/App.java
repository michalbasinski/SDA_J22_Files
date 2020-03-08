package pl.sda.jackson;

import pl.sda.csv.Person;

import java.io.IOException;
import java.util.List;

class App {
    public static void main(String[] args) throws IOException {
        JSONJacksonReader reader = new JSONJacksonReader();
        List<Person> persons = reader.read("/home/michal/SDA/Java22/Projekty/SDA_J22_Files/src/main/resources/persons.json");

        JSONJacksonWriter writer = new JSONJacksonWriter();
        writer.write(persons, "/home/michal/jackson.json");
    }
}
