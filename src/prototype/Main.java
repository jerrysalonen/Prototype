package prototype;

public class Main {

    public static void main(String[] args) {
        AbstractClock clock1 = new Clock(0, 15);
        AbstractClock clock2 = clock1.copy();

        clock2.setHour(5);
        clock2.setMinute(30);

        new Thread((Runnable)clock1).start();
        new Thread((Runnable)clock2).start();
    }
}
