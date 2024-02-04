package person.prashant.concepts.thread;

public class TestNotifyForException {

    /*
        A thread becomes the owner of the object's monitor in one of three ways:

        By executing a synchronized instance method of that object.
        By executing the body of a synchronized statement that synchronizes on the object.
        For objects of type Class, by executing a synchronized static method of that class.
 */
    public static void main(String[] args) throws InterruptedException {
        String aStr = "";
        aStr.notify();

        System.out.println("Should throw java.lang.IllegalMonitorStateException");
        System.out.println("Because ");
        System.out.println("thread has attempted to notify other threads waiting on an object's monitor without owning the specified monitor.");
    }
}
