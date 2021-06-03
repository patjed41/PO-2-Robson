package elementy_jezyka.wyrazenia;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJęzyka;

import java.util.Map;

public class Zmienna extends ElementJęzyka {

    private String nazwa;

    public Zmienna() {
        typ = "Zmienna";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (!zmienne.containsKey(nazwa))
            zmienne.put(nazwa, 0.);
        return zmienne.get(nazwa);
    }
}
