package S01T07N02Ex1AlbertMartin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Nom", "Cognom", 25);

        //  ObjectMapper mapper = new ObjectMapper();

        serializeObject(person);
        //deserializeObject();

    }

    private static void serializeObject(Person person) {

        try {
            shownJson(person);
            saveJsonInFile(person);
            System.out.println("Arxiu creat correctament.");

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

    private static void shownJson(Person person) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File("person.json"), person);
    }



















   /* private static void deserializeObject() {
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Fruits.ser"));
            Object inputFruit = readFile.readObject();
            readFile.close();
            System.out.println(inputFruit);

        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }*/

      /*  try {
            mapper.writeValue(System.out, person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

}