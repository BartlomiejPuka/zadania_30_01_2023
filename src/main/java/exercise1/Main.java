package exercise1;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Napisz program, który dla wszystkich liczb całkowitych z zadanego zakresu, zwraca tylko te, które są podzielne przez 3.
 * Zwrócone liczby powinny zostać wyświetlone na ekran.
 *
 * Wskazówka: Do wygenerowania ciągu liczb z konkretnego zakresu użyj IntStream, metoda implementująca wymaganie powinna zwracać kolekcję liczb.
 * Do wyświetlenia wyniku użyj Java Stream API.
 */
public class Main {

    public static List<Long> generate(Long from, Long to) {
        return LongStream.rangeClosed(from, to)
                .filter(i -> i % 3 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Long> list = generate(0L, 100L);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
