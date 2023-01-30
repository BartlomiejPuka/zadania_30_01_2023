package th1;

import java.util.Collections;
import java.util.List;

public class ThreadAvg extends Thread {

    List<Long> longList;


    public ThreadAvg(List<Long> longList) {
        this.longList = Collections.synchronizedList(longList);
    }


    @Override
    public void run() {
        Long sum = 0L;
        for (Long l: longList) {
            sum += l;
        }
        System.out.println("Srednia liczba: " + (sum / longList.size()));
    }
}
