# Robson

My solution for the second project of the [Object-oriented programming (pol. Programowanie obiektowe)](https://usosweb.mimuw.edu.pl/kontroler.php?_action=katalog2/przedmioty/pokazPrzedmiot&prz_kod=1000-212cPO) course taken in the 2021/2022 summer semester.

## Task

Write an interpreter of a simple programming language called ROBSON.

## Usage

To run the program go to `src` directory and execute:
```
  javac -cp lib/gson-2.8.7.jar:. Robson.java  
  java -cp lib/gson-2.8.7.jar:. Robson  
```

To make program do something interesting follow instructions (in polish) given in comments of `main` function of `src/Robson.java`.

# Full description in polish

Celem zadania będzie stworzenie interpretera pewnego prostego języka programowania o nazwie ROBSON.

Twój program powinien umożliwiać:
- wczytanie programu w języku ROBSON zapisanego w formacie JSON
- uruchomienie programu w języku ROBSON
- konwersję programu w języku ROBSON do kompilowalnego programu w Javie
- zapis wczytanego programu do pliku w formacie JSON.

W języku ROBSON Program w składa się z następujących elementów:
- instrukcji bloku; wykonanie bloku instrukcji polega na wywołaniu funkcji `wykonaj` dla
każdej instrukcji z bloku
- wyrażeń logicznych - stałe: `True`, `False`, operacje: `And`, `Not`, `Or`, a także operacje
porównujące wyrażenie arytmetyczne: `>`, `<`, `==`
- wyrażeń arytmetycznych - `stałej liczbowej`, `Plus`, `Minus`, `Razy`, `Dzielenie`
- instrukcji warunkowej `If` składającą się z wyrażenia logicznego oraz bloku
instrukcji wykonywanego w przypadku, gdy obliczenie wyrażenia da wartość true oraz
bloku instrukcji wykonywanej w przeciwnym przypadku
- instrukcji pętli `While` składającej się z wyrażenia logicznego oraz bloku instrukcji;
wykonanie instrukcji pętli polega na cyklicznym wykonywaniu następujących operacji
obliczenia wartości wyrażenia logicznego, jeśli to obliczenie da wartość True to
wykonujemy blok instrukcji, w przeciwnym wypadku kończymy wykonanie instrukcji
- w programie dostępne są zmienne globalne (początkowo zainicjalizowane na 0) i
instrukcje przypisania.

Programy w naszym języku będą zapisywane w plikach JSON.

## Wymagania techniczne
- Główna klasa rozwiązania powinna mieć nazwę Robson
- Klasa Robson powinna udostępniać następujące metody
  - `void fromJSON(String filename) throws NieprawidlowyProgram` - wczytanie programu z pliku JSON
  (wyjątek jest zadeklarowany na potrzeby przyszłych rozszerzeń, w zadaniu
  możesz założyć, że programy będą poprawne składniowo)
  - `void toJSON(String filename)` - zapisanie programu do pliku JSON
  - `void toJava(String filename)` - zapisanie programu do pliku Java
  - `double wykonaj() throws BladWykonania` - wykonanie programu i
  zwrócenie wartości liczbowej (lub wyjątku w przypadku błędu)
- Przy zapisie programu do języka Java, należy zapewnić żeby wynikowy program się
kompilował i wypisywał na standardowe wyjście wynik wyrażenia które zawiera
- Należy także dostarczyć przykładowy program testujący działanie języka ROBSON:
  - program może być dostarczony jako JUnitTest
  - albo własna klasa testująca
  - może to być np przykład implementacja algorytmu Euklidesa w języku
  Robson lub program sterujący robami w niestandardowy sposób w przypadku
  implementacji zadania bonusowego
- Program powinien zawierać kompletną instrukcję kompilacji i uruchomienia (łącznie z
podaniem wszystkich niezbędnych bibliotek). Innym sposobem jest przygotowanie
projektu Maven zawierającego wszystkie reguły i zależności.

## Instrukcje

W formacie JSON każda instrukcja będzie odpowiadać słownikowi, który będzie zawierał
obowiązkowe pole “typ” oraz dodatkowe argumenty wg następującej tabeli

| Typ | Dodatkowe atrybuty |
| ----------- | ----------- |
| Blok | `instrukcje` - lista instrukcji lub wyrażeń |
| If | `warunek` - wyrażenie opisujące warunek logiczny<br/>`blok_prawda` - wyrażenie które ma być wyliczone, gdy warunek jest prawdziwy<br/>`blok_falsz` - (atrybut opcjonalny) wyrażenie które ma być wykonane, gdy warunek jest fałszywy |
| While | `warunek` - wyrażenie opisujące warunek logiczny<br/>`blok` - wyrażenie, które ma być wykonane w pojedynczej iteracji pętli |
| Przypisanie | `nazwa` - nazwa zmiennej do przypisania (string)<br/>`wartosc` - wyrażenie opisujące prawą stronę przypisania |
| Plus, Minus, Razy, Dzielenie | `argument1` - wyrażenie opisujące pierwszy argument<br/>`argument2` - wyrażenie opisujące drugi argument |
| And, Or | `argument1` - wyrażenie opisujące pierwszy argument<br/>`argument2` - wyrażenie opisujące drugi argument |
| $<$, $>$, $\leq$, $\geq$, $==$ | `argument1` - wyrażenie opisujące pierwszy argument<br/>`argument2` - wyrażenie opisujące drugi argument |
| Not | `argument` - wyrażenie opisujące argument |
| Liczba | `wartosc` - wartość stałej liczbowej (double) |
| True, False | - |
| Zmienna | `nazwa` - nazwa zmiennej (string) |

Każda instrukcja wylicza wartość wyniką używając następujących reguł

| Typ         | Wartość wynikowa |
| ----------- | ----------- |
| Blok | Wartość ostatniej instrukcji lub 0 w przypadku pustego bloku |
| If | Wartość `blok_prawda`, jeśli warunek jest prawdziwy, lub wartość `blok_falsz` w przeciwnym przypadku |
| While | 0 |
| Przypisanie |  Wartość zmiennej (po przypisaniu) |
| Plus, Minus, Razy, Dzielenie | Wartość wyniku wykonania operacji (liczbowa) |
| And, Or | Wartość wyniku wykonania operacji (0 - fałsz, 1 - true) |
| $<$, $>$, $\leq$, $\geq$, $==$ | Wartość wyniku wykonania operacji (0 - fałsz, 1 - true) |
| Not | Wartość wyniku wykonania operacji (0 - fałsz, 1 - true) |
| Liczba | Wartość liczby |
| True, False | 0 - fałsz, 1 - prawda |
| Zmienna | Wartość zmiennej |

## Przykłady programu w formacie JSON

[**Przykład 1**](https://github.com/patjed41/PO-2-Robson/blob/master/src/pliki_robson/przyklad1.JSON) - oczekiwaną wartością wyrażenia powinno być 15

[**Przykład 2**](https://github.com/patjed41/PO-2-Robson/blob/master/src/pliki_robson/przyklad2.JSON) - ciąg Fibonacciego

## Ocenianie
- wykonywania programu: do 7 punktów
- export i import programu Javy do plików JSON: 1 punkty
- export wczytanego programu do kodu w Javie: 2 punkty

Przewidziany jest także bonus 2 punkty za implementacje rozszerzenia języka o instrukcje
sterujące Robem z zadania 1. Bonus działa w ten sposób, że punkty z niego uzyskane
uzupełniają ewentualnie utracone punkty.

---
Copyright of the task's description: MIM UW.
