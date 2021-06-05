package elementy_jezyka.wyrazenia;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJęzyka;

import java.util.Map;
import java.util.Set;

public class Zmienna extends ElementJęzyka {

    private String nazwa;

    public Zmienna() {
        typ = "Zmienna";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (!zmienne.containsKey(nazwa))
            zmienne.put(nazwa, 0.);
        return zmienne.get(nazwa);
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        zmienne_java.add(nazwa);
        dopiszTaby(kod_java, taby);
        kod_java.append(nazwa);
        dopiszśrednik(kod_java, średnik);
    }
}
