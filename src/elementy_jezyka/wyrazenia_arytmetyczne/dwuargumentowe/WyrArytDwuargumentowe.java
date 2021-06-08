package elementy_jezyka.wyrazenia_arytmetyczne.dwuargumentowe;

import elementy_jezyka.wyrazenia_arytmetyczne.WyrAryt;

import java.util.Set;

// klasa reprezentująca wyrażenie arytmetyczne dwuargumentowe.
public abstract class WyrArytDwuargumentowe extends WyrAryt {

    protected WyrAryt argument1;
    protected WyrAryt argument2;

    // Funkcja pozwalająca uniknąć pisania identycznego kodu w każdej klasie pochodnej.
    // Każde wyrażenie dwuargumentowe przepisuje się do javy w taki sam sposób, jedyną
    // różnicą jest symbol wyr oddzielający argumenty.
    protected void WyrArytDwuargumentoweToJava(Set<String> zmienne_java,
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