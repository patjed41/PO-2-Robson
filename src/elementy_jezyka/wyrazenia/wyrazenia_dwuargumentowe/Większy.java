package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class Większy extends WyrDwuargumentowe {

    public Większy() {
        typ = ">";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (argument1.wykonaj(zmienne) > argument2.wykonaj(zmienne))
            return 1;
        else
            return 0;
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        dopiszTaby(kod_java, taby);
        kod_java.append("(");
        argument1.toJava(zmienne_java, kod_java, false, 0);
        kod_java.append(" > ");
        argument2.toJava(zmienne_java, kod_java, false, 0);
        kod_java.append(")");
        dopiszśrednik(kod_java, średnik);
    }
}
