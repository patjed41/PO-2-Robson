package elementy_jezyka.inne;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJezyka;
import elementy_jezyka.wyrazenia_logiczne.WyrLog;

import java.util.Map;
import java.util.Set;

public class If extends ElementJezyka {

    private WyrLog warunek;
    private ElementJezyka blok_prawda;
    private ElementJezyka blok_falsz;

    public If() {
        typ = "If";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (warunek.wykonaj(zmienne) != 0)
            return blok_prawda.wykonaj(zmienne);
        else if (blok_falsz == null) // warunek fałszywy i blok_falsz nie istnieje, więc wynik to 0
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
        dopiszTaby(kod_java, taby);
        kod_java.append("else\n");
        if (blok_falsz != null) {
            blok_falsz.toJava(zmienne_java, kod_java, true, taby);
        }
        else { // Jeśli blok_falsz jest pusty, to ustawiamy wynik na 0, na wypadek, gdyby warunek był fałszywy.
            dopiszTaby(kod_java, taby + 1);
            kod_java.append("ustawWyn(0);\n");
        }
    }
}
