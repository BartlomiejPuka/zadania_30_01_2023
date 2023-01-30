package excersise2;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Zaimplementuj książkę telefoniczną, która będzie przechowywać poniższe dane osób:
 *
 * ●      Imię i Nazwisko
 *
 * ●      Numer telefonu
 *
 * ●      Adres
 *
 * Program powinien udostępniać możliwość przeszukiwania wpisów po polu “Imię i Nazwisko”. Pola adres, imię i nazwisko są polami obowiązkowymi.
 * W przypadku, gdy wpis nie został znaleziony, powinien zostać rzucony wyjątek.
 * Program powinien zostać zasilony przykładowymi danymi z pliku (należy zdefiniować własny sposób przechowywania danych w pliku).
 *
 * Wskazówka: Dane odczytane z pliku powinny być przechowywane w pamięci, w jednej z poznanych kolekcji.
 *
 */
public class Main {

    public static List<Person> phoneList;

    public static void loadData() throws IOException {
        Path path = Paths.get("src/main/resources/phones.txt");
        List<String> strings = Files.readAllLines(path);
        phoneList = strings.stream()
                .map(Person::of)
                .collect(Collectors.toList());
    }

   /* public static List<Person> searchPerson(SearchParams params) {

        return phoneList.stream()
                .filter()
                .collect(Collectors.toList());
    }*/

    public static void main(String[] args) throws IOException {
        loadData();

        for (int i = 0; i < phoneList.size(); i++) {
            Person person = phoneList.get(i);
            System.out.println(person);
        }
    }
}
