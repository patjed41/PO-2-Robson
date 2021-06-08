package elementy_jezyka.wyrazenia_arytmetyczne;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class Zmienna extends WyrAryt {

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
        if (średnik)
            kod_java.append("ustawWyn(").append(nazwa).append(");\n");
        else
            kod_java.append(nazwa);
    }
}
