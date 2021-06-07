package elementy_jezyka;

import java.util.Map;
import java.util.Set;

public abstract class ElementJezyka {
    protected String typ = "ElementJęzyka";

    public abstract double wykonaj(Map<String, Double> zmienne) throws BladWykonania;

    public abstract void toJava(Set<String> zmienne_java, // zbiór zmiennych występujących w programie
                                StringBuilder kod_java,   // kod programu w Javie
                                boolean średnik,          // czy po instrukcji powinien pojawić się średnik?
                                int taby);                // ile tabulacji powinno się pojawić przed instrukcją?

    // Poniższe funkcja służy tylko uproszczeniu kodu funkcji toJava klas pochodnych.
    protected void dopiszTaby(StringBuilder kod_java, int taby) {
        for (int i = 0; i < taby; i++)
            kod_java.append("    "); // 4 spacje zamiast tabulacji
    }
}
