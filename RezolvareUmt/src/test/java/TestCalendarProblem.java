import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestCalendarProblem {

    @Test
    public void testCalendar1(){
        Calendar bookedCalendarOne = new Calendar();
        Calendar bookedCalendarTwo = new Calendar();

        bookedCalendarOne.addALimit(new Limit(new Interval(9, 0), new Interval(10, 30)));
        bookedCalendarOne.addALimit(new Limit(new Interval(12, 0), new Interval(13, 0)));
        bookedCalendarOne.addALimit(new Limit(new Interval(16, 0), new Interval(18, 0)));


        bookedCalendarTwo.addALimit(new Limit(new Interval(10, 0), new Interval(11, 30)));
        bookedCalendarTwo.addALimit(new Limit(new Interval(12, 30), new Interval(14, 30)));
        bookedCalendarTwo.addALimit(new Limit(new Interval(14, 30), new Interval(15, 0)));
        bookedCalendarTwo.addALimit(new Limit(new Interval(16, 0), new Interval(17, 0)));

        bookedCalendarOne.setRangeLimit(new Limit(new Interval(8, 0), new Interval(20, 0)));
        bookedCalendarTwo.setRangeLimit(new Limit(new Interval(8, 30), new Interval(18, 30)));

        System.out.println();
        System.out.println(bookedCalendarOne);
        System.out.println(bookedCalendarTwo);


        System.out.println();

        int nb = 30;

        Solve solve = new Solve();

        ArrayList<Limit> expectedLimits = new ArrayList<>();

        expectedLimits.add(new Limit(new Interval(8,0) , new Interval(9,0)));
        expectedLimits.add(new Limit(new Interval(11,30) , new Interval(12,0)));
        expectedLimits.add(new Limit(new Interval(15,0) , new Interval(16,0)));
        expectedLimits.add(new Limit(new Interval(18,0) , new Interval(18,30)));

        Assert.assertTrue(solve.meet(bookedCalendarOne , bookedCalendarTwo,nb).getLimits().equals(expectedLimits));


    }

    @Test
    public void testCalendar2() {
        Calendar bookedCalendarOne = new Calendar();
        Calendar bookedCalendarTwo = new Calendar();

        bookedCalendarOne.addALimit(new Limit(new Interval(9, 0), new Interval(10, 30)));
        bookedCalendarOne.addALimit(new Limit(new Interval(12, 0), new Interval(13, 0)));
        bookedCalendarOne.addALimit(new Limit(new Interval(16, 0), new Interval(18, 0)));


        bookedCalendarTwo.addALimit(new Limit(new Interval(10, 0), new Interval(11, 30)));
        bookedCalendarTwo.addALimit(new Limit(new Interval(12, 30), new Interval(14, 30)));
        bookedCalendarTwo.addALimit(new Limit(new Interval(14, 30), new Interval(15, 0)));
        bookedCalendarTwo.addALimit(new Limit(new Interval(16, 0), new Interval(17, 0)));

        bookedCalendarOne.setRangeLimit(new Limit(new Interval(8, 0), new Interval(20, 0)));
        bookedCalendarTwo.setRangeLimit(new Limit(new Interval(8, 30), new Interval(18, 30)));

        System.out.println(bookedCalendarOne);
        System.out.println(bookedCalendarTwo);

        int nb = 60;

        Solve solve = new Solve();

        ArrayList<Limit> expectedLimits = new ArrayList<>();

        expectedLimits.add(new Limit(new Interval(8,0) , new Interval(9,0)));
       // expectedLimits.add(new Limit(new Interval(11,30) , new Interval(12,0)));
        expectedLimits.add(new Limit(new Interval(15,0) , new Interval(16,0)));
       // expectedLimits.add(new Limit(new Interval(18,0) , new Interval(18,30)));

        Assert.assertTrue(solve.meet(bookedCalendarOne , bookedCalendarTwo,nb).getLimits().equals(expectedLimits));
    }
}
