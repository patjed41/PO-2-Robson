package elementy_jezyka.wyrazenia;

import elementy_jezyka.ElementJęzyka;

public class Zmienna extends ElementJęzyka {

    private String nazwa;

    public Zmienna() {
        typ = "Zmienna";
    }

    @Override
    public double wykonaj() {
        return 0; // return zmienne.getValue(nazwa);
    }
}
