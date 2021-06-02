import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import elementy_jezyka.*;
import elementy_jezyka.wyrazenia.*;
import elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Robson {
    private ElementJęzyka program;

    private static final RuntimeTypeAdapterFactory<ElementJęzyka> adapter =
        RuntimeTypeAdapterFactory.of(ElementJęzyka.class, "typ")
            .registerSubtype(Blok.class)
            .registerSubtype(Plus.class)
            .registerSubtype(Minus.class)
            .registerSubtype(Razy.class)
            .registerSubtype(Dzielenie.class)
                .registerSubtype(And.class)
                .registerSubtype(Or.class)
                .registerSubtype(Mniejszy.class, "<")
                .registerSubtype(Większy.class, ">")
                .registerSubtype(MniejszyRówny.class, "<=")
                .registerSubtype(WiększyRówny.class, ">=")
                .registerSubtype(Równy.class, "==")
                .registerSubtype(Not.class)
            .registerSubtype(Liczba.class)
                .registerSubtype(True.class)
                .registerSubtype(False.class);

    private static final Gson gson_read = new GsonBuilder().registerTypeAdapterFactory(adapter).create();
    private static final Gson gson_write = new GsonBuilder().create();

    void fromJSON(String filename) throws NieprawidlowyProgram {
        Scanner skaner;
        try {
            skaner = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e) {
            System.err.println("Błędna nazwa pliku.");
            return;
        }

        program = gson_read.fromJson(skaner.useDelimiter("\\Z").next(), ElementJęzyka.class);
    }

    public static void main(String[] args) {
        Robson robson = new Robson();
        try {
            robson.fromJSON("src/przyklad.JSON");
        }
        catch (NieprawidlowyProgram e) {
            System.err.println("Nieprawidłowy program.");
        }
        System.out.println(gson_write.toJson(robson.program));
        System.out.println(robson.program.wykonaj());
    }
}
