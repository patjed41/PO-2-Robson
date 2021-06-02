package elementy_jezyka.wyrazenia;

import elementy_jezyka.ElementJęzyka;

public class Liczba extends ElementJęzyka {

    private double wartosc;

    public Liczba() {
        typ = "Liczba";
    }

    @Override
    public double wykonaj() {
        return wartosc;
    }
}
