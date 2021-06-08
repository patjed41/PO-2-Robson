package elementy_jezyka.inne;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJezyka;

import java.util.Map;
import java.util.Set;

public class Blok extends ElementJezyka {

    private ElementJezyka[] instrukcje;

    public Blok() {
        typ = "Blok";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (instrukcje.length == 0) { // blok jest pusty, więc wynik to 0
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
        if (instrukcje.length == 0) { // blok jest pusty, więc wynik to 0
            dopiszTaby(kod_java, taby);
            kod_java.append("ustawWyn(0);\n");
        }
        else {
            for (ElementJezyka instrukcja : instrukcje)
                instrukcja.toJava(zmienne_java, kod_java, true, taby + 1);
        }
        dopiszTaby(kod_java, taby);
        kod_java.append("}\n");
    }
}
