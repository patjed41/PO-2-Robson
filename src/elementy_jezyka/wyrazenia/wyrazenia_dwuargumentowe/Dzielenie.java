package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class Dzielenie extends WyrDwuargumentowe {

    public Dzielenie() {
        typ = "Plus";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        double dzielna = argument1.wykonaj(zmienne);
        double dzielnik = argument2.wykonaj(zmienne);
        if (dzielnik == 0) // Nie można dzielić przez 0.
            throw new BladWykonania("Dzielenie przez 0");
        return dzielna / dzielnik;
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        WyrDwuargumentoweToJava(zmienne_java, kod_java, średnik, taby, "/");
    }
}
