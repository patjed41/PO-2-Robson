package elementy_jezyka;

import java.util.Map;

public class Przypisanie extends ElementJęzyka {

    private String nazwa;
    private ElementJęzyka wartosc;

    public Przypisanie() {
        typ = "Przypisanie";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        double wynik = wartosc.wykonaj(zmienne);
        zmienne.put(nazwa, wynik);
        return wynik;
    }
}