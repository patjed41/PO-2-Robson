import obsluga_plikow_json.SerializatorJSON;
import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJęzyka;

import java.io.*;
import java.util.*;

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
            writer = new BufferedWriter(new FileWriter(filename));
            writer.append(serializator.toJson(kod));
            writer.close();
        }
        catch (IOException e) {
            // To się raczej nie wydarzy. Jeśli plik nie istnieje, to zostanie utworzony.
            System.err.println("Błędny plik.");
        }
    }

    void toJava(String filename) {
        if (!filename.endsWith(".java")) {
            System.err.println("Plik musi mieć rozszerzenie \".java\".");
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            Set<String> zmienne_java = new HashSet<>();
            StringBuilder kod_java = new StringBuilder();

            kod.toJava(zmienne_java, kod_java, true, 2);

            int początek_nazwy_pliku = filename.lastIndexOf('/') + 1; // jeśli '\' nie występuje, to 0

            writer.append("public class ");
            writer.append(filename.substring(początek_nazwy_pliku, filename.length() - 5));
            writer.append("\n{\n");
            writer.append("    static double wyn = 0;\n\n");
            writer.append("    private static void ustawWyn(double wyr_arytmetyczne) {\n");
            writer.append("        wyn = wyr_arytmetyczne;\n    }\n\n");
            writer.append("    private static void ustawWyn(boolean wyr_logiczne) {\n");
            writer.append("        if (wyr_logiczne)\n            wyn = 1;\n        else\n            wyn = 0;\n    }\n\n");
            writer.append("    public static void main(String[] args) {\n");
            writer.append("        // deklaracje zmiennych, które w Robsonie są globalne\n");

            for (String nazwa : zmienne_java)
                writer.append("        double ").append(nazwa).append(" = 0;\n");

            writer.append("\n");
            writer.append(kod_java.toString());
            writer.append("        System.out.println(wyn);\n");
            writer.append("    }\n}");
            writer.close();
        }
        catch (IOException e) {
            // To się raczej nie wydarzy. Jeśli plik nie istnieje, to zostanie utworzony.
            System.err.println("Błędny plik.");
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
        try {
            System.out.println(robson.wykonaj());
        }
        catch (BladWykonania e) {
            System.err.println("Błąd wykonania. " + e.getMessage());
        }
        robson.toJava("src/przyklad.java");
    }
}
