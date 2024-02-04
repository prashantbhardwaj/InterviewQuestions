package person.prashant.concepts.thread;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private MessageTransfer messageTransfer;

    Receiver(MessageTransfer mt){
        this.messageTransfer = mt;
    }

    // standard constructors

    public void run() {
        for(String receivedMessage = messageTransfer.receive();
            !"End".equals(receivedMessage);
            receivedMessage = messageTransfer.receive()) {

            System.out.println("Received message: " + receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted : " + e);
            }
        }
    }
}