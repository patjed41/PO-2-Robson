package elementy_jezyka.wyrazenia_logiczne.dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class WiększyRówny extends WyrPorównujące {

    public WiększyRówny() {
        typ = ">=";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (argument1.wykonaj(zmienne) >= argument2.wykonaj(zmienne))
            return 1;
        else
            return 0;
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        WyrDwuargumentoweToJava(zmienne_java, kod_java, średnik, taby, ">=");
    }
}
