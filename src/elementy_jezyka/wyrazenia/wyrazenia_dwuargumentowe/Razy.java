package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

public class Razy extends WyrArytDwuargumentowe {

    public Razy() {
        typ = "Razy";
    }

    @Override
    public double wykonaj() {
        return argument1.wykonaj() * argument2.wykonaj();
    }
}
