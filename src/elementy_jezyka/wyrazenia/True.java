package elementy_jezyka.wyrazenia;

import elementy_jezyka.ElementJęzyka;

public class True extends ElementJęzyka {

    public True() {
        typ = "True";
    }

    @Override
    public double wykonaj() {
        return 1;
    }
}
