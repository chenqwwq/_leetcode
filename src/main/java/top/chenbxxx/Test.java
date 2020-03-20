package top.chenbxxx;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chen
 * @date 2020/3/17 下午12:05
 */
public class Test {
    public static volatile AtomicInteger i = new AtomicInteger(10);

    public static void main(String[] args) {
        Test.i.getAndIncrement();
    }
}
