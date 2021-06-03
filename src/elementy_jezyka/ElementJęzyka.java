package elementy_jezyka;

import java.util.Map;
import java.util.Set;

public abstract class ElementJęzyka {
    protected String typ = "ElementJęzyka";

    public abstract double wykonaj(Map<String, Double> zmienne) throws BladWykonania;

    public abstract void toJava(Set<String> zmienne_java, StringBuilder kod_java);
}
