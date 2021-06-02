package elementy_jezyka.wyrazenia;

import elementy_jezyka.ElementJęzyka;

public class Not extends ElementJęzyka {

    private ElementJęzyka argument;

    public Not() {
        typ = "Not";
    }

    @Override
    public double wykonaj() {
        if (argument.wykonaj() != 0)
            return 0;
        else
            return 1;
    }
}
