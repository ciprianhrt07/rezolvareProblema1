public class Solve {

    public Calendar meet(Calendar bookedCalendarOne, Calendar bookedCalendarTwo, int meetingTime) {

        //Se considera ca toate valorile din intervalul orar sunt cuprinse intre 6:00 si 22:00

        Calendar calendarMeeting = new Calendar();


        int[] ap = new int[2201];

        for (Limit l : bookedCalendarOne.getLimits()) {

            int value1 = l.getOraStart() * 100 + l.getMinutStart();
            int value2 = l.getOraFinal() * 100 + l.getMinutFinal();

            for (int j = value1; j <= value2; j++)
                ap[j] = 1;

        }

        for (Limit l : bookedCalendarTwo.getLimits()) {

            int value1 = l.getOraStart() * 100 + l.getMinutStart();
            int value2 = l.getOraFinal() * 100 + l.getMinutFinal();

            for (int j = value1; j <= value2; j++)
                ap[j] = 2;

        }

        int leftLimit = Math.min(bookedCalendarOne.getOraLimitaStart() * 100 + bookedCalendarOne.getMinutStart(),
                bookedCalendarTwo.getOraLimitaStart() * 100 + bookedCalendarTwo.getMinutStart());

        int rightLimit = Math.min(bookedCalendarOne.getOraLimitaFinal() * 100 + bookedCalendarOne.getMinutFinal(),
                bookedCalendarTwo.getOraLimitaFinal() * 100 + bookedCalendarTwo.getMinutFinal()
        );
/*
        System.out.println(leftLimit + " " + rightLimit
        );*/

        int pozi = -1, i;

        if (ap[leftLimit] == 0)
            pozi = leftLimit;

        for (i = leftLimit; i <= rightLimit; i++)
            if (i + 1 <= rightLimit && (ap[i] != 0 && ap[i + 1] == 0)) {

                if (pozi == -1) {
                    pozi = i;

                }
            } else if (i + 1 <= rightLimit && (ap[i] == 0 && ap[i + 1] != 0)) {


                Interval aux1 = new Interval(pozi / 100, pozi % 100);
                Interval aux2 = new Interval((i + 1) / 100, (i + 1) % 100);

                Limit limit = new Limit(aux1, aux2);


              /*  System.out.println(limit);

                System.out.println(Limit.diferentaIntervale(aux2,aux1));*/

                if (Limit.diferentaIntervale(aux2, aux1) >= meetingTime)
                    calendarMeeting.addALimit(limit);

                pozi = -1;
            }

        if (pozi != -1) {

            Interval aux1 = new Interval(pozi / 100, pozi % 100);
            Interval aux2 = new Interval((i - 1) / 100, (i - 1) % 100);

            Limit limit = new Limit(aux1, aux2);

            if (Limit.diferentaIntervale(aux2, aux1) >= meetingTime)
                calendarMeeting.addALimit(limit);

            //  System.out.println(limit);

            //   System.out.println(Limit.diferentaIntervale(aux2, aux1));
        }

        return calendarMeeting;

    }


}
