package elementy_jezyka;

import java.util.Map;
import java.util.Set;

public abstract class ElementJęzyka {
    protected String typ = "ElementJęzyka";

    public abstract double wykonaj(Map<String, Double> zmienne) throws BladWykonania;

    public abstract void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby);

    // Poniższe funkcje służą uproszczeniu kodu funkcji toJava klas pochodnych.
    // Dzięki nim nie powielamy tego samego kodu w każdej klasie.
    protected void dopiszśrednik(StringBuilder kod_java, boolean średnik) {
        if (średnik)
            kod_java.append(";\n");
    }

    protected void dopiszTaby(StringBuilder kod_java, int taby) {
        for (int i = 0; i < taby; i++)
            kod_java.append("    "); // 4 spacje zamiast tabulacji
    }
}
