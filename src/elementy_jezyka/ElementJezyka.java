package elementy_jezyka;

import java.util.Map;
import java.util.Set;

// Klase reprezentująca element języka Robson.
public abstract class ElementJezyka {
    // Atrybut typ istnieje tylko na potrzeby serializacji do formatu JSON.
    protected String typ = "ElementJęzyka";

    // Funkcja wykonująca element języka w języku Robson. Parametr zmienne, to mapa
    // zmiennych, które do tej pory wystąpiły w wykonywanym programie. Klucze to
    // nazwy zmiennych, a wartości, to odpowiadające nazwom wartości double.
    public abstract double wykonaj(Map<String, Double> zmienne) throws BladWykonania;

    // Funkcja zapisująca kod Robsonowego programu w Javie.
    public abstract void toJava(Set<String> zmienne_java, // zbiór zmiennych występujących w programie
                                StringBuilder kod_java,   // kod programu w Javie
                                boolean średnik,          // czy po instrukcji powinien pojawić się średnik?
                                int taby);                // ile tabulacji powinno się pojawić przed instrukcją?

    // Poniższe funkcja dopisuje taby tabulacji do kod_java.
    // Służy tylko uproszczeniu kodu funkcji toJava klas pochodnych.
    protected void dopiszTaby(StringBuilder kod_java, int taby) {
        for (int i = 0; i < taby; i++)
            kod_java.append("    "); // 4 spacje zamiast tabulacji, żeby kod ładnie wyglądał w każdym edytorze
    }
}
