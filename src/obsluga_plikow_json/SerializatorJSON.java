package obsluga_plikow_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import elementy_jezyka.*;
import elementy_jezyka.inne.*;
import elementy_jezyka.wyrazenia_arytmetyczne.*;
import elementy_jezyka.wyrazenia_arytmetyczne.dwuargumentowe.*;
import elementy_jezyka.wyrazenia_logiczne.*;
import elementy_jezyka.wyrazenia_logiczne.dwuargumentowe.*;

// Klasy uwożliwiająca serializację i deserializację elementów języka Robson
// (obiektów klasy ElementJezyka) ze Stringa w formacie JSON.
public class SerializatorJSON {

    // adapter rejestrujący klasy pochodne klasy ElementJezyka
    private static final RuntimeTypeAdapterFactory<ElementJezyka> element_jezyka_adapter =
            RuntimeTypeAdapterFactory.of(ElementJezyka.class, "typ")
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

    // adapter rejestrujący klasy pochodne klasy WyrAryt
    private static final RuntimeTypeAdapterFactory<WyrAryt> wyr_aryt_adapter =
            RuntimeTypeAdapterFactory.of(WyrAryt.class, "typ")
                    .registerSubtype(Przypisanie.class)
                    .registerSubtype(Plus.class)
                    .registerSubtype(Minus.class)
                    .registerSubtype(Razy.class)
                    .registerSubtype(Dzielenie.class)
                    .registerSubtype(Liczba.class)
                    .registerSubtype(Zmienna.class);

    // adapter rejestrujący klasy pochodne klasy WyrLog
    private static final RuntimeTypeAdapterFactory<WyrLog> wyr_log_adapter =
            RuntimeTypeAdapterFactory.of(WyrLog.class, "typ")
                    .registerSubtype(And.class)
                    .registerSubtype(Or.class)
                    .registerSubtype(Mniejszy.class, "<")
                    .registerSubtype(Większy.class, ">")
                    .registerSubtype(MniejszyRówny.class, "<=")
                    .registerSubtype(WiększyRówny.class, ">=")
                    .registerSubtype(Równy.class, "==")
                    .registerSubtype(Not.class)
                    .registerSubtype(True.class)
                    .registerSubtype(False.class);

    // obiekt klasy Gson służący do deserializacji z formatu JSON
    private static final Gson gson_read =
            new GsonBuilder().registerTypeAdapterFactory(element_jezyka_adapter)
                             .registerTypeAdapterFactory(wyr_aryt_adapter)
                             .registerTypeAdapterFactory(wyr_log_adapter).create();

    // obiekt klasy Gson służący do serializacji do formatu JSON
    private static final Gson gson_write = new GsonBuilder().setPrettyPrinting().create();

    // deserializacja obiektów klasy ElementJezyka
    public ElementJezyka fromJson(String json) {
        return gson_read.fromJson(json, ElementJezyka.class);
    }

    // serializacja obiektów klasy ElementJezyka
    public String toJson(ElementJezyka element) {
        return gson_write.toJson(element);
    }
}
