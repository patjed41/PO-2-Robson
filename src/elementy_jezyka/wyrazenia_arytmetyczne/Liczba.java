package elementy_jezyka.wyrazenia_arytmetyczne;

import elementy_jezyka.BladWykonania;
import java.util.Map;
import java.util.Set;

public class Liczba extends WyrAryt {

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
        if (średnik)
            kod_java.append("ustawWyn(").append(wartosc).append(");\n");
        else
            kod_java.append(wartosc);
    }
}
