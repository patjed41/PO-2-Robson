package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.BladWykonania;

import java.util.Map;

public class MniejszyRówny extends WyrArytDwuargumentowe {

    public MniejszyRówny() {
        typ = "<=";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (argument1.wykonaj(zmienne) <= argument2.wykonaj(zmienne))
            return 1;
        else
            return 0;
    }
}
