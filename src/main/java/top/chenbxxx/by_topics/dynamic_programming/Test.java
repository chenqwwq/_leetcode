package top.chenbxxx.by_topics.dynamic_programming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.CountDownLatch;

/**
 * @author bingxin.chen
 * @date 2019/9/24 17:15
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new MyRunnable(countDownLatch)).start();
        }

        countDownLatch.await();

        System.out.println(test.INT.getI());
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    enum test {
        INT(1);
        private int i;

        public int incr() {
            return INT.i++;
        }
    }

    static class MyRunnable implements Runnable {
        CountDownLatch countDownLatch;

        MyRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                test.INT.incr();
            }
            countDownLatch.countDown();
        }
    }
}
