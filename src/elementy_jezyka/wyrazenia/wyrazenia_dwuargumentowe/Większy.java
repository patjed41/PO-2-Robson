package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

public class Większy extends WyrArytDwuargumentowe {

    public Większy() {
        typ = ">";
    }

    @Override
    public double wykonaj() {
        if (argument1.wykonaj() > argument2.wykonaj())
            return 1;
        else
            return 0;
    }
}
