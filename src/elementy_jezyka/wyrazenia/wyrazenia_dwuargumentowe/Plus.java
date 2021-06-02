package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

public class Plus extends WyrArytDwuargumentowe {

    public Plus() {
        typ = "Plus";
    }

    @Override
    public double wykonaj() {
        return argument1.wykonaj() + argument2.wykonaj();
    }
}
