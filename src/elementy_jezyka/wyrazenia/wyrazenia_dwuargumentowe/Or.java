package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;

public class Or extends WyrArytDwuargumentowe {

    public Or() {
        typ = "Or";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (argument1.wykonaj(zmienne) != 0 || argument2.wykonaj(zmienne) != 0)
            return 1;
        else
            return 0;
    }
}