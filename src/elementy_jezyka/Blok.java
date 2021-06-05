package elementy_jezyka;

import java.util.Map;
import java.util.Set;

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

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        dopiszTaby(kod_java, taby);
        kod_java.append("{\n");
        for (ElementJęzyka instrukcja : instrukcje)
            instrukcja.toJava(zmienne_java, kod_java, true, taby + 1);
        dopiszTaby(kod_java, taby);
        kod_java.append("}\n");
    }
}
