import elementy_jezyka.BladWykonania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Klasa udostępniająca metodę testującą, czy algorytm Euklidesa napisany w Robsonie
// działa w poprawnie. Program nwd.JSON napisany w Robsonie i poniższa funkcja
// nwd(a, b) zawierają dokładnie ten sam algorytm Euklidesa w wersji z odejmowaniem.
// Aby przeprowadzić test na wybranych liczbach, należy zmienić wartości liczbowe
// w pliku nwd.JSON w wierszach 9. i 17 (po dwukropku nie może być spacji).
public class TestNWD {

    private static String nazwa_pliku = "src/nwd.JSON";

    private double nwd(double a, double b) {
        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    // Funkcją służąca do wyłuskiwania wartości, dla których liczymy nwd, z pliku nwd.JSON.
    // Aby poprawnie działała, plik nwd.JSON nie może się zmienić (poza liczbami z wierszy 9. i 17.).
    private double liczba_z_pliku(int numer_wiersza, int początek_liczby) {
        Scanner skaner;
        try {
            skaner = new Scanner(new File(nazwa_pliku));
            for (int i = 0; i < numer_wiersza - 1; i++)
                skaner.nextLine();

            String wiersz = skaner.nextLine();
            return Double.parseDouble(wiersz.substring(początek_liczby, wiersz.length()));
        }
        catch (FileNotFoundException e) {
            // Zwracamy -1 jeśli coś jest plik nwd.JSON nie istnieje.
            System.err.println("Plik nwd.JSON nie istnieje.");
            return -1;
        }
    }

    public void testuj() {
        Robson robson = new Robson();

        // wczytanie kodu w Robsonie
        try {
            robson.fromJSON(nazwa_pliku);
        }
        catch (NieprawidlowyProgram e) {
            System.err.println("Nieprawidłowy program.");
            return;
        }

        double wyn_robson = 0, wyn_java = 0;

        // wyznaczenie wyniku w Robsonie
        try {
            wyn_robson = robson.wykonaj();
        }
        catch (BladWykonania e) {
            System.err.println("Błąd wykonania. " + e.getMessage());
        }

        // wyznaczenie wyniku w Javie
        double a = liczba_z_pliku(9, 18);
        if (a == -1) // błąd pliku nwd.JSON
            return;
        double b = liczba_z_pliku(17, 18);
        wyn_java = nwd(a, b);

        if (wyn_robson == wyn_java)
            System.out.println("Poprawna odpowiedź dla liczb " + a + " i " + b + ".");
        else
            System.out.println("Błędna odpowiedź dla liczb " + a + " i " + b + ".");
    }
}
