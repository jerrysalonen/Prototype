package prototype;

/**
 * @author Jerry Salonen
 */
public abstract class AbstractClock {
    public abstract AbstractClock copy();
    public abstract void setHour(int h);
    public abstract void setMinute(int m);
}
