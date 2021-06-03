package obsluga_plikow_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import elementy_jezyka.*;
import elementy_jezyka.wyrazenia.*;
import elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe.*;

// Klasy uwożliwiająca serializację i deserializację elementów języka Robson ze Stringa w formacie JSON.
public class SerializatorJSON {
    private static final RuntimeTypeAdapterFactory<ElementJęzyka> adapter =
            RuntimeTypeAdapterFactory.of(ElementJęzyka.class, "typ")
                    .registerSubtype(Blok.class)
                    .registerSubtype(If.class)
                    .registerSubtype(While.class)
                    .registerSubtype(Przypisanie.class)
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
                    .registerSubtype(False.class)
                    .registerSubtype(Zmienna.class);

    private static final Gson gson_read = new GsonBuilder().registerTypeAdapterFactory(adapter).create();
    private static final Gson gson_write = new GsonBuilder().setPrettyPrinting().create();

    public ElementJęzyka fromJson(String json) {
        return gson_read.fromJson(json, ElementJęzyka.class);
    }

    public String toJson(ElementJęzyka element) {
        return gson_write.toJson(element);
    }
}
