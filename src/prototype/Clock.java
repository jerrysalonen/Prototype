package prototype;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Jerry Salonen
 */
public class Clock extends AbstractClock implements Runnable {

    MinuteHand mh;
    HourHand hh;

    public Clock (int hour, int min) {
        this.mh = new MinuteHand(min);
        this.hh = new HourHand(hour);
    }

    public void setHour(int h) {
        hh.setTime(h);
    }

    public void setMinute(int m) {
        mh.setTime(m);
    }

    @Override
    public AbstractClock copy() {
        Clock clone = new Clock(mh.getTime(), hh.getTime());
        return clone;
    }

    public void run() {
        TimerTask tickMinute = new TimerTask() {
            public void run() {
                if (mh.getTime() == 60) {
                    mh.setTime(0);
                    hh.setTime(hh.getTime() + 1);
                } else {
                    mh.setTime(mh.getTime() + 1);
                }

                if (hh.getTime() == 24 && mh.getTime() == 0)
                    hh.setTime(0);

                System.out.println(hh.getTime() + ":" + mh.getTime());
            }
        };

        Timer timer = new Timer("Timer");

        long delay  = 0L;
        long periodMinute = 1000L; // a second for testing purposes

        timer.scheduleAtFixedRate(tickMinute, delay, periodMinute);
    }
}
