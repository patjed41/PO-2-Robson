# Robson

### Kompilacja:

Proszę kompilować rozwiązanie będąc w folderze robson linijkami:  

```
  javac -cp lib/gson-2.8.7.jar:. Robson.java  
  java -cp lib/gson-2.8.7.jar:. Robson  
```

Rozwiązanie może nie kompilować się na innych systemach niż linuks i nie
jest to tylko kwestia zmiany linijek kompilacji. Nie gwarantuję, że nie
korzystam w rozwiązaniu z czegoś, co jest charakterystyczne wyłącznie
dla linuksa. Jak widać, korzystam z biblioteki gson, jednak jest już ona
umieszczona w folderze lib i nic więcej nie trzeba robić, aby działała.  


### Uruchamianie i testowanie:  

W funkcji main w klasie Robson jest opisane jak skorzystać z przykładowej
klasy TestNWD testującej język Robson. Są tam również przykłady uruchomień
wszystkich metod z polecania na teście przykładowym z treści. Proponuję
korzystać z nich jak z szablonów. Wystarczy bowiem zmienić nazwy plików
i można uruchamiać/testować program na innych plikach, nie wgłębiając się
w strukture rozwiązania, dzięki czemu unikniemy potencjalnych problemów
związanych z hierarchią plików. Proponuję również korzystać
z następujących folderów:
 - pliki_robson, do trzymania plików używanych przez fromJSON (są już tam
   3 pliki)
 - pliki_toJava, do trzymania plików utworzonych przez toJava
 - pliki_toJSON, do trzymania plików utworzonych przez toJSON
Z tych folderów korzystają przykładowe wywołania metod w main, więc
korzystając z nich, wystarczy tylko zmieniać nazwy plików w tych
wywołaniach. W ten sposób zachowamy zarówno prostotę testowania jak
i porządek.

Uruchomić program przykladowy_program.java utworzony przez wywołanie
toJava(przykladowy_program.java) można w najzwyklejszy sposób:  

```
  javac przykladowy_program.java  
  java przykladowy_program  
```

Należy pamiętać, że funkcje toJava i toJSON tworzą pliki, których ścieżka
zaczyna się w folderze robson, co może "zaśmiecić" rozwiązanie. Dlatego
zalecam korzystanie z folderów pliki_toJava i pliki_toJSON,
przykładowo wywołując toJava(pliki_toJava/przykladowy_program.java).


### Założenia języka Robson:

W treści wyrażenia są podzielone na arytmetyczne i logiczne, jednak nie
ma precyzyjnej informacji, co dokładnie może wystąpić w atrybutach
różnych elementów języka. Przyjąłem sztywne rozróżnianie wyrażeń
logicznych i arytmetycznych. Oznacza to na przykład, że wartością
przypisania musi być wyrażenie arytmetyczne, argumentami instrukcji
porównawczej "<" muszą być wyrażenia arytmetyczne oraz argumentami
instrukcji "And" muszą być wyrażenia logiczne. Ogólnie, założenia są
podobne do tych w javie. Elementy języka Robson If, While, Blok
traktujemy jako "inne". Oznacza to, że nie mogą się pojawić tam, gdzie
wymagamy wyrażenia arytmetycznego lub logicznego. Powyższe założenia
dobrze widać w strukturze klas. Mogłem przyjąć, że wszystko może być
atrybutem wszystkiego i w przypadku wykonywania języka Robson nie
stanowiłoby to problemu, bo i tak każdy element języka zwraca liczbę.
Aby Robson działał na każdym możliwym programie, wystarczyłoby zmienić
typy wszystkich argumentów we wszystkich klasach na ElementJezyka.
Zdecydowałem się jednak korzystać z typów takich jak WyrAryt, żeby
wyraźniej pokazać, z jakich założeń korzystam na potrzeby toJava,
bo napisanie toJava przy "zezwalaniu na wszystko" jest bardzo trudne,
a może nawet niemożliwe, jeśli chcemy, żeby kod zwracany przez toJava
był przyzwoity.


### Kod plików utworzonych przez toJava:

Myślę, że kod jest dość przejrzysty i jasno widać jego strukturę. Metody
statytyczne ustawWyn() służą do ustawiania końcowego wyniku rozwiązania.
Użyłem ich, a nie zwykłego przypisania do zmiennej wyn, bo w javie nie
mogę napisać na przykład wyn = true. Nie są wywoływane wszędzie, a tylko
tam, gdzie pojawiają się instrukcję kończące się średnikiem oraz
w miejscach takich jak po pętli while (wtedy wyn ustawiamy na 0). Nazwa
klasy utworzonej przez toJava to wartość filename z obciętym prefiksem
folderów i obciętym sufiksem ".java".
