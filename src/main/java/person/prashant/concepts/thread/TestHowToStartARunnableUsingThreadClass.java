package person.prashant.concepts.thread;

public class TestHowToStartARunnableUsingThreadClass {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++ ) {
            final int m = i;
            Thread aT = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println("Thread " + m + " printing " + j);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, m + ""
            );
            aT.start();

            System.out.println(aT.getName() + " is in state = " + aT.getState());
            System.out.println(Thread.currentThread().getName() + " is in state = " + Thread.currentThread().getState());
            if(m == 2) {
                aT.join();
            }
            System.out.println(Thread.currentThread().getName() + " is in state = " + Thread.currentThread().getState());
        }
    }
}
