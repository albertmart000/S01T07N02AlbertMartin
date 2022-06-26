package S01T07N02Ex1AlbertMartin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class App {
    public static void main(String[] args) {

        Person person = new Person("Nom", "Cognom", 25);
        String directoryFile = "person.json";
        serializeObject(person, directoryFile);

    }

    //Serialitzem l'objecte Person en un fitxer JSON.
    @DirectoryFileJSon
    private static void serializeObject(Person person, String directoryFile) {

        try {
            shownJson(person,directoryFile );
            saveJsonInFile(person);
            System.out.println("\nArxiu creat correctament.");

        } catch (IOException e) {
            throw new RuntimeException(e);
            }

    }

    private static void saveJsonInFile(Person person) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(person);
        System.out.println(json);
    }

    @DirectoryFileJSon()
    private static void shownJson(Person person, String directoryFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(directoryFile), person);
    }

}