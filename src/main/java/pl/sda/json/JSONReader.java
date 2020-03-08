package pl.sda.json;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.csv.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class JSONReader {
    List<Person> read(String filePath) {
        List<Person> result = new ArrayList<>();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String fileContents = new String(bytes, "UTF-8");

            JSONObject persons = new JSONObject(fileContents);

            JSONArray personCollection = persons.getJSONArray("persons");

            for (int i = 0; i < personCollection.length(); i++) {
                Object record = personCollection.get(i);
                JSONObject personJSON = new JSONObject(record.toString());
                String name = personJSON.getString("name");
                String lastName = personJSON.getString("lastName");
                String party = personJSON.getString("party");
                Person person = new Person(name, lastName, party);
                result.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
