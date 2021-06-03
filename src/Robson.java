import ObsługaPlikówJSON.SerializatorJSON;
import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJęzyka;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Robson {
    // Mogłoby być "private Blok kod", gdybyśmy założyli, że program w Robsonie
    // musi być cały w jednym najbardziej zewnętrznym bloku.
    private ElementJęzyka kod;
    private Map<String, Double> zmienne; // zmienne globalne występujące w programie
    private static final SerializatorJSON serializator = new SerializatorJSON();

    public Robson() {
        zmienne = new HashMap<>();
    }

    void fromJSON(String filename) throws NieprawidlowyProgram {
        Scanner skaner;
        try {
            skaner = new Scanner(new File(filename));
            kod = serializator.fromJson(skaner.useDelimiter("\\Z").next());
            zmienne = new HashMap<>(); // Nie ma potrzeby trzymać w pamięci zmiennych ze starego kodu.
            skaner.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Błędna nazwa pliku.");
        }
    }

    void toJSON(String filename) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename, true));
            writer.append(serializator.toJson(kod));
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Błędna nazwa pliku.");
        }
    }

    double wykonaj() throws BladWykonania {
        return kod.wykonaj(zmienne);
    }

    public static void main(String[] args) {
        Robson robson = new Robson();
        try {
            robson.fromJSON("src/przyklad2.JSON");
        }
        catch (NieprawidlowyProgram e) {
            System.err.println("Nieprawidłowy program.");
        }
        System.out.println(serializator.toJson(robson.kod));
        try {
            System.out.println(robson.wykonaj());
        }
        catch (BladWykonania e) {
            System.err.println("Błąd wykonania. " + e.getMessage());
        }
        robson.kod = serializator.fromJson(serializator.toJson(robson.kod));
        System.out.println(serializator.toJson(robson.kod));
        try {
            System.out.println(robson.wykonaj());
        }
        catch (BladWykonania e) {
            System.err.println("Błąd wykonania. " + e.getMessage());
        }
    }
}
