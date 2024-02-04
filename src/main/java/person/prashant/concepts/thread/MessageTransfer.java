package person.prashant.concepts.thread;

public class MessageTransfer {
    private String body;

    // True if receiver should wait
    // False if sender should wait
    private boolean isSending = true;

    public synchronized String receive() {
        while (isSending) {
            try {
                System.out.println("Receiver going into wait mode");
                wait();
                System.out.println("Receiver coming out from wait mode");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        isSending = true;

        String returnPacket = body;
        notifyAll();
        return returnPacket;
    }

    public synchronized void send(String text) {
        while (!isSending) {
            try {
                System.out.println("Sender going into wait mode");
                wait();
                System.out.println("Sender coming out from wait mode");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        isSending = false;

        this.body = text;
        notifyAll();
    }
}