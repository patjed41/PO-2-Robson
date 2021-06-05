package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class Minus extends WyrDwuargumentowe {

    public Minus() {
        typ = "Minus";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        return argument1.wykonaj(zmienne) - argument2.wykonaj(zmienne);
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        dopiszTaby(kod_java, taby);
        kod_java.append("(");
        argument1.toJava(zmienne_java, kod_java, false, 0);
        kod_java.append(" - ");
        argument2.toJava(zmienne_java, kod_java, false, 0);
        kod_java.append(")");
        dopiszśrednik(kod_java, średnik);
    }
}
