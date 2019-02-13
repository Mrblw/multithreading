
/**
 *  【并发技术01】传统线程技术中创建线程的两种方式
 */
public class CreateThread {

    public static void main(String[] args) {

        /********** 第一种方法：继承Thread类，覆写run()方法 **************/
        //由于只要实现一个 run() 方法即可，所以我们可以使用 Java 中的匿名内部类来实现，如下：
        Thread threadEx = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("继承Thread类开启线程："+ Thread.currentThread().getName());
            }
        };
        threadEx.start();

        /********** 第二种方法：实现Runnable接口，扔给Thread **************/
        Thread threadIm = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("实现Runnable接口开启线程："+ Thread.currentThread().getName());
            }
        });
        threadIm.start();
    }
}
