import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 【并发技术02】传统线程技术中的定时器技术
 */
public class TraditionalTimer {

    public static void main(String[] args) {
        TraditionalTimer timerTest = new TraditionalTimer();
        //timerTest.printBoomPeriod3Delay2();
        //timerTest.userDefined();
        timerTest.period2OrPeriod4Boom();
        while (true){
            System.out.println(LocalDateTime.now().getSecond());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printBoomPeriod3Delay2(){
        //延迟2秒执行，每隔3秒打印一次 boom!
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("---- boom! ----");
            }
        },2000,3000);
    }

    /**
     * 用户自定义实现 printBoomPeriod3Delay2 的功能
     */
    public void userDefined(){
        class MyTimerTask extends TimerTask{
            @Override
            public void run() {
                System.out.println("---- boom! ---- MyTimerTask");
                new Timer().schedule(new MyTimerTask(),3000);
            }
        }
        new Timer().schedule(new MyTimerTask(),2000);
    }

    private static int count = 0;

    /**
     * 隔2秒执行一次，再隔4秒执行一次
     */
    public void period2OrPeriod4Boom(){
        class MyTimerTask extends TimerTask{
            @Override
            public void run() {
                //结果只有 0 和 1
                count = (count + 1) % 2;
                System.out.println("---- boom! ---- 2 or 4 second boom , count is " + count);
                new Timer().schedule(new MyTimerTask(),2000 + 2000 * count);
            }
        }
        new Timer().schedule(new MyTimerTask(),2000);
    }
}
