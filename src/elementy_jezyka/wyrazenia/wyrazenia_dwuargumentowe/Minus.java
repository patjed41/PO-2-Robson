package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

public class Minus extends WyrArytDwuargumentowe {

    public Minus() {
        typ = "Minus";
    }

    @Override
    public double wykonaj() {
        return argument1.wykonaj() - argument2.wykonaj();
    }
}
