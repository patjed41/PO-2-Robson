package elementy_jezyka;

import java.util.Map;

public abstract class ElementJęzyka {
    protected String typ = "ElementJęzyka";

    public abstract double wykonaj(Map<String, Double> zmienne) throws BladWykonania;
}
