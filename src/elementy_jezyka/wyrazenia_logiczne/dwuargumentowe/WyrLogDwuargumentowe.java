package elementy_jezyka.wyrazenia_logiczne.dwuargumentowe;

import elementy_jezyka.wyrazenia_logiczne.WyrLog;

import java.util.Set;

// Klasa reprezentująca wyrażenie logiczne dwuargumentowe o argumentach logicznych.
public abstract class WyrLogDwuargumentowe extends WyrLog {

    protected WyrLog argument1;
    protected WyrLog argument2;

    // Funkcja pozwalająca uniknąć pisania identycznego kodu w każdej klasie pochodnej.
    protected void WyrLogDwuargumentoweToJava(Set<String> zmienne_java,
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
            kod_java.append(");\n");
    }
}