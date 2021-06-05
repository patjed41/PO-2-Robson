package elementy_jezyka.wyrazenia;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJęzyka;

import java.util.Map;
import java.util.Set;

public class Liczba extends ElementJęzyka {

    private double wartosc;

    public Liczba() {
        typ = "Liczba";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        return wartosc;
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        dopiszTaby(kod_java, taby);
        kod_java.append(wartosc);
        dopiszśrednik(kod_java, średnik);
    }
}
