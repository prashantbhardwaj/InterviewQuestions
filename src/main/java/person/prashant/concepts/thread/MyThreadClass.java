package person.prashant.concepts.thread;

public class MyThreadClass implements Runnable{
    private Thread aThread;
    private String name;

    MyThreadClass(String name, Thread aT){
        this.aThread = aT;
        this.name = name;
    }

    @Override
    public void run() {
        for (int j = 0; j < 5; j++) {
            System.out.println("Thread " + name + " printing " + j);
            System.out.println("For Thread " + name + " thread " + aThread.getName() + " is in state " + aThread.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
