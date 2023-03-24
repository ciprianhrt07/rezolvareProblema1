import java.util.Objects;

public class Interval {

    private int hour;
    private int minute;

    public Interval(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }



    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return hour == interval.hour && minute == interval.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }

    @Override
    public String toString() {
        if (minute != 0)
            return hour + ":" + minute;
        else
            return hour + ":" + "00";
    }
}
