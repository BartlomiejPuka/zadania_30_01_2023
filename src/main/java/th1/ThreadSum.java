package th1;

import java.util.Collections;
import java.util.List;

public class ThreadSum extends Thread{

    List<Long> longList;

    public ThreadSum(List<Long> longList) {
        this.longList = Collections.synchronizedList(longList);
    }

    @Override
    public void run() {
        Long sum = 0L;
        for (Long l: longList) {
            sum += l;
        }
        System.out.println("Suma liczb: " + sum);
    }
}
