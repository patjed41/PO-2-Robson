package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class Plus extends WyrDwuargumentowe {

    public Plus() {
        typ = "Plus";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        return argument1.wykonaj(zmienne) + argument2.wykonaj(zmienne);
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        WyrDwuargumentoweToJava(zmienne_java, kod_java, średnik, taby, "+");
    }
}
