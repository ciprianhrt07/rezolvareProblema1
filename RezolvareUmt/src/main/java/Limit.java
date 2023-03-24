import java.util.Objects;

public class Limit {

    private Interval start;
    private Interval stop;

    public Limit(Interval start, Interval stop) {
        this.start = start;
        this.stop = stop;
    }

    public int getOraStart() {

        return start.getHour();
    }

    public static int diferentaIntervale(Interval interval1 , Interval interval2){

        int transformareInterval1 = interval1.getHour()*60+interval1.getMinute();
        int transformareInterval2 = interval2.getHour()*60+interval2.getMinute();

        return transformareInterval1 - transformareInterval2;
    }


    public int getOraFinal() {
        return stop.getHour();
    }

    public int getMinutStart() {

        return start.getMinute();
    }

    public int getMinutFinal() {
        return stop.getMinute();
    }

    public Interval getStart() {
        return start;
    }

    public void setStart(Interval start) {
        this.start = start;
    }

    public Interval getStop() {
        return stop;
    }

    public void setStop(Interval stop) {
        this.stop = stop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Limit limit = (Limit) o;
        return Objects.equals(start, limit.start) && Objects.equals(stop, limit.stop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, stop);
    }

    @Override
    public String toString() {
        return "[" + start + " , " + stop + "]";
    }
}
