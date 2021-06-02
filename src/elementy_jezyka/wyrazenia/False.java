package elementy_jezyka.wyrazenia;

import elementy_jezyka.ElementJęzyka;

public class False extends ElementJęzyka {

    public False() {
        typ = "True";
    }

    @Override
    public double wykonaj() {
        return 0;
    }
}
