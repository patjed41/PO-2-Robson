package elementy_jezyka;

import java.util.Map;
import java.util.Set;

public class If extends ElementJęzyka {

    private ElementJęzyka warunek;
    private ElementJęzyka blok_prawda;
    private ElementJęzyka blok_falsz;

    public If() {
        typ = "If";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (warunek.wykonaj(zmienne) != 0)
            return blok_prawda.wykonaj(zmienne);
        else if (blok_falsz == null)
            return 0;
        else
            return blok_falsz.wykonaj(zmienne);
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        dopiszTaby(kod_java, taby);
        kod_java.append("if (");
        warunek.toJava(zmienne_java, kod_java, false, 0);
        kod_java.append(")\n");
        blok_prawda.toJava(zmienne_java, kod_java, true, taby);
        if (blok_falsz != null) {
            dopiszTaby(kod_java, taby);
            kod_java.append("else\n");
            blok_falsz.toJava(zmienne_java, kod_java, true, taby);
        }
    }
}
