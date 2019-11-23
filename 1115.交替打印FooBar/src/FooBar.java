import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create with LeetCode
 * User: XFour
 * Date: 2019/11/22
 * Time: 16:46
 * Description:
 */
class FooBar {

    private int n;
    private ReentrantLock lock;
    private Condition condition;
    private volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (!flag) {
                    condition.await();
                }
                printFoo.run();
                flag = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (flag) {
                    condition.await();
                }
                printBar.run();
                flag = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
