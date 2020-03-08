package pl.sda.jackson;

import lombok.Data;
import pl.sda.csv.Person;

import java.util.List;

@Data
public class Persons {
    private List<Person> persons;
}
