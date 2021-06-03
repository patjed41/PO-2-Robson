package elementy_jezyka;

import java.util.Map;

public class Blok extends ElementJęzyka {

    private ElementJęzyka[] instrukcje;

    public Blok() {
        typ = "Blok";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (instrukcje.length == 0) {
            return 0;
        }
        else {
            for (int i = 0; i < instrukcje.length - 1; i++)
                instrukcje[i].wykonaj(zmienne);
            return instrukcje[instrukcje.length - 1].wykonaj(zmienne);
        }
    }
}
