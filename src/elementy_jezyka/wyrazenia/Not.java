package elementy_jezyka.wyrazenia;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJęzyka;

import java.util.Map;
import java.util.Set;

public class Not extends ElementJęzyka {

    private ElementJęzyka argument;

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
        kod_java.append("!");
    }
}
