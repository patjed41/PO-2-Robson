package elementy_jezyka;

public class Przypisanie extends ElementJęzyka {

    private String nazwa;
    private ElementJęzyka wartosc;

    public Przypisanie() {
        typ = "Przypisanie";
    }

    @Override
    public double wykonaj() {
        double wynik = wartosc.wykonaj();
        // zmienne.put(nazwa, wynik);
        return wynik;
    }
}