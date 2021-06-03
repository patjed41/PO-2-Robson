package elementy_jezyka;

public class While extends ElementJęzyka {

    private ElementJęzyka warunek;
    private ElementJęzyka blok;

    public While() {
        typ = "While";
    }

    @Override
    public double wykonaj() {
        while (warunek.wykonaj() != 0)
            blok.wykonaj();
        return 0;
    }
}