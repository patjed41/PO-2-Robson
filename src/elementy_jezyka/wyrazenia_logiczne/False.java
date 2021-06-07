package elementy_jezyka.wyrazenia_logiczne;

import elementy_jezyka.BladWykonania;
import elementy_jezyka.ElementJezyka;

import java.util.Map;
import java.util.Set;

public class False extends WyrLog {

    public False() {
        typ = "True";
    }

    @Override
    public double wykonaj(Map<String, Double> zmienne) throws BladWykonania {
        return 0;
    }

    @Override
    public void toJava(Set<String> zmienne_java, StringBuilder kod_java, boolean średnik, int taby) {
        dopiszTaby(kod_java, taby);
        if (średnik)
            kod_java.append("ustawWyn(false);\n");
        else
            kod_java.append("false");
    }
}
