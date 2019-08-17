import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create with LeetCode
 * User: 许清远
 * Date: 2019/8/17
 * Time: 22:54
 * Description:
 */
public class Test {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    private volatile static int state = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                while (true) {
                    lock.lock();
                    while (state != 0) {
                        conditionA.await();
                    }
                    System.out.print("A");
                    Thread.sleep(200);
                    state = 1;
                    conditionB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    lock.lock();
                    while (state != 1) {
                        conditionB.await();
                    }
                    System.out.print("B");
                    Thread.sleep(200);
                    state = 2;
                    conditionC.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    lock.lock();
                    while (state != 2) {
                        conditionC.await();
                    }
                    System.out.print("C");
                    Thread.sleep(200);
                    state = 0;
                    conditionA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }

}
