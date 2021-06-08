package elementy_jezyka.wyrazenia_arytmetyczne;

import elementy_jezyka.BladWykonania;

import java.util.Map;
import java.util.Set;

public class Przypisanie extends WyrAryt {

    private String nazwa;
    private WyrAryt wartosc;

    public Przypisanie() {
        typ = "Przypisanie";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        double wynik = wartosc.wykonaj(zmienne);
        zmienne.put(nazwa, wynik);
        return wynik;
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        zmienne_java.add(nazwa);
        dopiszTaby(kod_java, taby);
        if (średnik)
            kod_java.append("ustawWyn(");
        kod_java.append(nazwa).append(" = ");
        wartosc.toJava(zmienne_java, kod_java, false, 0);
        if (średnik)
            kod_java.append(");\n");
    }
}