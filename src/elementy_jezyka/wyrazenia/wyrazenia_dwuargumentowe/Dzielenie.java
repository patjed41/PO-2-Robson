package elementy_jezyka.wyrazenia.wyrazenia_dwuargumentowe;

public class Dzielenie extends WyrArytDwuargumentowe {

    public Dzielenie() {
        typ = "Plus";
    }

    @Override
    public double wykonaj() {
        return argument1.wykonaj() / argument2.wykonaj();
    }
}
