package S01T07N02Ex1AlbertMartin;

import java.lang.annotation.*;

//Fem l'anotació personalitzada per a serialitzar un objecte Person
//en un fitxer JSON amb el seu directori.
@Target(value= ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DirectoryFileJSon {

    String directoryFile() default "person.json";
}
