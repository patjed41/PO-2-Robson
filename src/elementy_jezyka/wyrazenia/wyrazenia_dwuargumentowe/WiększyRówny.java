package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

public class WiększyRówny extends WyrArytDwuargumentowe {

    public WiększyRówny() {
        typ = ">=";
    }

    @Override
    public double wykonaj() {
        if (argument1.wykonaj() >= argument2.wykonaj())
            return 1;
        else
            return 0;
    }
}
