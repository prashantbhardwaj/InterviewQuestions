package person.prashant.concepts.thread;

public class TestHowToJoinThreadAndVariousStates {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++ ) {
            final int m = i;
            Thread aT = new Thread(new MyThreadClass(m + "", Thread.currentThread()));
            aT.start();

            System.out.println(aT.getName() + " is in state = " + aT.getState());
            if(m == 2) {
                aT.join();
            }
            System.out.println(Thread.currentThread().getName() + " is in state = " + Thread.currentThread().getState());
        }
    }
}
