package elementy_jezyka.wyrazenia;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJęzyka;

import java.util.Map;

public class Liczba extends ElementJęzyka {

    private double wartosc;

    public Liczba() {
        typ = "Liczba";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        return wartosc;
    }
}
