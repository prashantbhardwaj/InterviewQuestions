package person.prashant.concepts.thread;

public class TestWaitAndNotify {

    /*
    A thread becomes the owner of the object's monitor in one of three ways:

    By executing a synchronized instance method of that object.
    By executing the body of a synchronized statement that synchronizes on the object.
    For objects of type Class, by executing a synchronized static method of that class.
     */
    public static void main(String[] args) {
        MessageTransfer data = new MessageTransfer();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        receiver.start();
        sender.start();

        // no matter whether you start receiver first or sender first

    }
}
