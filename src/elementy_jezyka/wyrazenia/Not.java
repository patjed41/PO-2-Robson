package elementy_jezyka.wyrazenia;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJęzyka;

import java.util.Map;

public class Not extends ElementJęzyka {

    private ElementJęzyka argument;

    public Not() {
        typ = "Not";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        if (argument.wykonaj(zmienne) != 0)
            return 0;
        else
            return 1;
    }
}
