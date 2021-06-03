package elementy_jezyka;

import java.util.Map;

public class While extends ElementJęzyka {

    private ElementJęzyka warunek;
    private ElementJęzyka blok;

    public While() {
        typ = "While";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        while (warunek.wykonaj(zmienne) != 0)
            blok.wykonaj(zmienne);
        return 0;
    }
}