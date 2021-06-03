package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;

public class Dzielenie extends WyrArytDwuargumentowe {

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
}
