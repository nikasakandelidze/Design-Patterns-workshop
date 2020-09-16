package ReadWriteLock;

public class ReadWriteLock {
    /*
    Number of active readers at the moment.
     */
    private int readers;

    /*
        Number of active writers at the moment.
     */
    private int writers;

    /*
        Number of WriteRequests made by writer threads.
     */
    private int writeRequests;

    /*
    Monitor/Lock to wait/notify on.
     */
    private Object lock = new Object();

    /*
        Whenever you are Reader thread and want to acquire lock
        See if anyone is writing at the moment or anyone is going to write( writeRequests > 0 )
        if so, wait for them to finish till someone doesn't notify you that you can wake up and recheck.
     */
    public synchronized void lockRead() throws InterruptedException {
        while (writers > 0 || writeRequests > 0) {
            lock.wait();
        }
        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        /*
            Notify all writers who were waiting for me that i am done reading.
         */
        lock.notifyAll();
    }

    /*
        If you are a thread and want to write, at first make your write request visible to everyone( writeRequests++ ),
        then see if anyone is writing or reading, if so, wait till someone doesn't notify you that you can recheck again.
     */
    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        while (writers > 0 || readers > 0) {
            lock.wait();
        }
        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() {
        writers--;
        lock.notifyAll();
    }
}
