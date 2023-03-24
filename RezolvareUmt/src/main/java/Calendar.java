import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private ArrayList<Limit> limits;

    private Limit rangeLimit;

    public Calendar() {
        this.limits = new ArrayList<>();
    }

    public Calendar(ArrayList<Limit> limits) {
        this.limits = limits;
    }

    public int getOraLimitaStart() {

        return this.rangeLimit.getOraStart();

    }

    public int getOraLimitaFinal() {
        return this.rangeLimit.getOraFinal();
    }


    public int getMinutStart() {

        return this.rangeLimit.getMinutStart();
    }

    public int getMinutFinal() {
        return this.rangeLimit.getMinutFinal();
    }

    public Limit getRangeLimit() {
        return rangeLimit;
    }

    public void setRangeLimit(Limit rangeLimit) {
        this.rangeLimit = rangeLimit;
    }

    public void addALimit(Limit limit) {
        this.limits.add(limit);
    }

    public ArrayList<Limit> getLimits() {
        return limits;
    }

    public void setLimits(ArrayList<Limit> limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("List: ");

        limits.stream().forEach(l -> stringBuilder.append(l + " , "));

        int len = stringBuilder.length();

        stringBuilder.delete(len - 2, len);

        stringBuilder.append(".....range:..... ");

        stringBuilder.append(rangeLimit);

        return stringBuilder.toString();
    }


}
