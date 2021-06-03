package elementy_jezyka;

import java.util.Map;
import java.util.Set;

public class Przypisanie extends ElementJęzyka {

    private String nazwa;
    private ElementJęzyka wartosc;

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
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java) {
        kod_java.append(nazwa).append(" = ").append(wartosc).append(";\n");
    }
}