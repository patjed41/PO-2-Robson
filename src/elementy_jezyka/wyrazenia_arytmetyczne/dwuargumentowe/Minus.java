package elementy_jezyka.wyrazenia_arytmetyczne.dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class Minus extends WyrArytDwuargumentowe {

    public Minus() {
        typ = "Minus";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        return argument1.wykonaj(zmienne) - argument2.wykonaj(zmienne);
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        WyrArytDwuargumentoweToJava(zmienne_java, kod_java, średnik, taby, "-");
    }
}
