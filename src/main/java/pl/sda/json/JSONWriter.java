package pl.sda.json;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.csv.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class JSONWriter {
    void write(List<Person> persons, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            JSONArray personsJSON = new JSONArray();
            for (Person person : persons) {
                JSONObject personJSON = new JSONObject();
                personJSON.put("name", person.getName());
                personJSON.put("lastName", person.getLastName());
                personJSON.put("party", person.getParty());
                personsJSON.put(personJSON);
            }
            JSONObject mainJSON = new JSONObject();
            mainJSON.put("persons", personsJSON);
            writer.write(mainJSON.toString(2));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
