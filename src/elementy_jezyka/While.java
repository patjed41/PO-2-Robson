package elementy_jezyka;

import java.util.Map;
import java.util.Set;

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

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        dopiszTaby(kod_java, taby);
        kod_java.append("while (");
        warunek.toJava(zmienne_java, kod_java, false, 0);
        kod_java.append(")\n");
        blok.toJava(zmienne_java, kod_java, true, taby);
        dopiszTaby(kod_java, taby);
        kod_java.append("ustawWyn(0);\n");
    }
}