package pl.sda.json;

import pl.sda.csv.Person;

import java.util.List;

class App {
    public static void main(String[] args) {
        JSONReader reader = new JSONReader();
        List<Person> persons = reader.read("/home/michal/SDA/Java22/Projekty/SDA_J22_Files/src/main/resources/persons.json");

        JSONWriter writer = new JSONWriter();
        writer.write(persons, "/home/michal/test.json");
    }
}
