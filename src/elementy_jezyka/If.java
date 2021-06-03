package elementy_jezyka;

public class If extends ElementJęzyka {

    private ElementJęzyka warunek;
    private ElementJęzyka blok_prawda;
    private ElementJęzyka blok_falsz;

    public If() {
        typ = "If";
    }

    @Override
    public double wykonaj() {
        if (warunek.wykonaj() != 0)
            return blok_prawda.wykonaj();
        else if (blok_falsz == null)
            return 0;
        else
            return blok_falsz.wykonaj();
    }
}
