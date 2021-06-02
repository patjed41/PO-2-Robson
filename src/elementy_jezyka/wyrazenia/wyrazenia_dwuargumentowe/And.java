package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

public class And extends WyrArytDwuargumentowe {

    public And() {
        typ = "And";
    }

    @Override
    public double wykonaj() {
        if (argument1.wykonaj() != 0 && argument2.wykonaj() != 0)
            return 1;
        else
            return 0;
    }
}
