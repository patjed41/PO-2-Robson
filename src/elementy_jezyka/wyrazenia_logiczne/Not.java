package elementy_jezyka.wyrazenia_logiczne;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class Not extends WyrLog {

    private WyrLog argument;

    public Not() {
        typ = "Not";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (argument.wykonaj(zmienne) != 0)
            return 0;
        else
            return 1;
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        dopiszTaby(kod_java, taby);
        if (średnik) {
            kod_java.append("ustawWyn(!");
            argument.toJava(zmienne_java, kod_java, false, 0);
            kod_java.append(");\n");
        }
        else {
            kod_java.append("!");
            argument.toJava(zmienne_java, kod_java, false, 0);
        }
    }
}
