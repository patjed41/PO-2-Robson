# Robson

Proszę o dokładne przeczytanie tego pliku. Jest w nim dużo istotnych
informacji odnośnie rozwiązania.

Kompilacja:

Proszę kompilować rozwiązanie będąc w folderze robson linijkami:

javac -cp lib/gson-2.8.7.jar:. Robson.java
java -cp lib/gson-2.8.7.jar:. Robson

Rozwiązanie może nie kompilować się na innych systemach niż linuks i nie
jest to tylko kwestia zmiany linijek kompilacji. Nie gwarantuję, że nie
korzystam w rozwiązaniu z czegoś, co jest charakterystyczne wyłącznie
dla linuksa.


Uruchamianie i testowanie:

W funkcji main w klasie Robson jest opisane jak skorzystać z przykładowej
klasy TestNWD testującej język Robson. Są tam również przykłady uruchomień
wszystkich metod z polecania na teście przykładowym z treści. Proponuję
korzystać z nich jak z szablonów. Wystarczy bowiem zmienić nazwy plików
i można uruchamiać/testować program na innych plikach, nie wgłębiając się
w strukture rozwiązania, dzięki czemu unikniemy potencjalnych problemów
związanych z hierarchią plików. Proponuję również korzystać
z następujących folderów:
 - pliki_robson, do trzymania plików używanych przez fromJSON
 - pliki_toJava, do trzymania plików utworzonych przez toJava
 - pliki_toJSON, do trzymania plików utworzonych przez toJSON
Z tych folderów korzystają przykładowe wywołania metod w main, więc
korzystając z nich, wystarczy tylko zmieniać nazwy plików w tych
wywołaniach. W ten sposób zachowamy zarówno prostotę testowania jak
i porządek.

Uruchomić program przykladowy_program.java utworzony przez wywołanie
toJava(przykladowy_program.java) można w najzwyklejszy sposób:

javac przykladowy_program.java
java przykladowy_program

Należy pamiętać, że funkcje toJava i toJSON tworzą pliki, których ścieżka
zaczyna się w folderze robson, co może "zaśmiecić" rozwiązanie. Dlatego
zalecam korzystanie z folderów pliki_toJava i pliki_toJSON,
przykładowo wywołując toJava(pliki_toJava/przykladowy_program.java).


Założenia języka Robson:

Treść zadania nie daje precyzyjnych informacji, co może się pojawić w języku
Robson. Dlatego przyjąłem kilka założeń, które uważam za rozsądne:

1. Rozróżniamy wyrażenia arytmetyczne i logiczne. Oznacza to na przykład,
że wartością przypisania musi być wyrażenie arytmetyczne, argumentami
istrukcji porównawczej "<" muszą być wyrażenia arytmetyczne oraz
argumentami instrukcji "And" muszą być wyrażenia logiczne. Ogólnie,
założenia są analogiczne do tych w javie.
2. Atrybuty blok_prawda, blok_falsz w instrukcji If oraz atrybut blok
w instrukcji While muszą być typu Blok.
3. Elementy języka Robson If, While, Blok traktujemy jako "inne". Oznacza
to, że nie mogą się pojawić tam, gdzie wymagamy wyrażenia arytmetycznego
lub logicznego.

Wszystkie powyższe założenia dobrze widać w strukturze klas.


Kod plików utworzonych przez toJava:

Myślę, że kod jest dość przejrzysty i jasno widać jego strukturę. Metody
statytyczne ustawWyn() służą do ustawiania końcowego wyniku rozwiązania.
Użyłem ich, a nie zwykłego przypisania do zmiennej wyn, bo w javie nie
mogę napisać na przykład wyn = true. Nie są wywoływane wszędzie, a tylko
tam, gdzie pojawiają się instrukcję kończące się średnikiem oraz
w miejscach takich jak po pętli while (wtedy wyn ustawiamy na 0). Nazwa
klasy utworzonej przez toJava to wartość filename z obciętym prefiksem
folderów i obciętym sufiksem ".java".
