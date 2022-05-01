package interview.preparation.lesson_3;

public class PingPong {
    private final static String PING = "Ping ";
    private final static String PONG = "Pong ";
    private volatile String currentString = PING;

    private final Object monitor = new Object();

    public static void main(String[] args) {
        PingPong waitNotifyApp = new PingPong();
        new Thread(waitNotifyApp::printPing).start();
        new Thread(waitNotifyApp::printPong).start();
    }

    public void printPing() {
        printString(PING, PONG);
    }

    public void printPong() {
        printString(PONG, PING);
    }

    private void printString(String toBePrintedString, String nextString) {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                try {
                    while (! currentString.equals(toBePrintedString)) {
                        monitor.wait(5000);
                    }
                    System.out.print(toBePrintedString);
                    currentString = nextString;
                    monitor.notify();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
