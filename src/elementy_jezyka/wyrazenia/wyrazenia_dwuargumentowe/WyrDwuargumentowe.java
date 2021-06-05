package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

import elementy_jezyka.ElementJęzyka;

import java.util.Set;

// klasa reprezentująca wyrażenie dwuargumentowe (arytmetyczne i logiczne)
public abstract class WyrDwuargumentowe extends ElementJęzyka {

    protected ElementJęzyka argument1;
    protected ElementJęzyka argument2;

    // Funkcja pozwalająca uniknąć pisania identycznego kodu w każdej klasie pochodnej.
    protected void WyrDwuargumentoweToJava(Set<String> zmienne_java,
                                           StringBuilder kod_java, boolean średnik, int taby, String wyr) {
        dopiszTaby(kod_java, taby);
        if (średnik)
            kod_java.append("ustawWyn(");
        kod_java.append("(");
        argument1.toJava(zmienne_java, kod_java, false, 0);
        kod_java.append(" ").append(wyr).append(" ");
        argument2.toJava(zmienne_java, kod_java, false, 0);
        kod_java.append(")");
        if (średnik)
            kod_java.append(");");
    }
}