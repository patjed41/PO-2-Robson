package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;

public class Minus extends WyrArytDwuargumentowe {

    public Minus() {
        typ = "Minus";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        return argument1.wykonaj(zmienne) - argument2.wykonaj(zmienne);
    }
}
