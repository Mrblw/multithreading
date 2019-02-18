import java.util.concurrent.atomic.AtomicReference;

/**
 * @author buliwen
 * @description 不可重入锁
 * @date 2019/2/18
 */
public class UnreentrantLock {

    private AtomicReference<Thread> owner = new AtomicReference<Thread>();
    //去掉注释即改为可重入锁
    //private int state = 0;

    public void lock() {
        Thread current = Thread.currentThread();
        //去掉注释即改为可重入锁
//        if (current == owner.get()) {
//            state++;
//            return;
//        }

        //这句是很经典的“自旋”语法，AtomicInteger中也有
        for (;;) {
            if (!owner.compareAndSet(null, current)) {
                return;
            }
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        //去掉注释即改为可重入锁
//        if (current == owner.get()) {
//            if (state != 0) {
//                state--;
//            } else {
                owner.compareAndSet(current, null);
//            }
//        }
    }
}
