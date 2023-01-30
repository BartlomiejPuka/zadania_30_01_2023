package th1;

import java.util.ArrayList;
import java.util.List;

/**
 * Zaimplementuj program, który będzie przyjmował listę liczb całkowitych i w osobnych wątkach policzy:
 *
 *
 *
 * średnią wszystkich liczb
 * sumę wszystkich liczb
 *
 *
 * Rezultat obliczeń należy wyświetlić na konsolę.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);


        ThreadAvg threadAvg = new ThreadAvg(list);
        threadAvg.start();
        threadAvg.join();

        ThreadSum threadSum = new ThreadSum(list);
        threadSum.start();
        threadSum.join();

    }
}
