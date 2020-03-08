package pl.sda.csv;

import java.util.List;

class App {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<Person> persons =
                csvReader.read("/home/michal/SDA/Java22/Projekty/SDA_J22_Files/src/main/resources/persons.csv");

        CSVWriter writer = new CSVWriter();
        writer.write(persons, "/home/michal/persons.csv");
    }
}
