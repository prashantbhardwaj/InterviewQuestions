package person.prashant.concepts.thread;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private MessageTransfer messageTransfer;

    Sender(MessageTransfer mt){
        this.messageTransfer = mt;
    }

    // standard constructors

    public void run() {
        String messages[] = {
                "First msg",
                "Second msg",
                "Third msg",
                "Fourth msg",
                "End",
                "sorry forgot this message"
        };

        for (String msg : messages) {
            System.out.println("Sending message: " + msg);
            messageTransfer.send(msg);
            System.out.println("Sent message: " + msg);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted : " + e);
            }
        }
    }
}