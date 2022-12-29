package proFun.Lab7o;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Lab7Q2_65426 {
    public static void main(String[] args) {
        LocalDate nov1yr21 = LocalDate.of(2003, 9, 16);
        LocalDate jan2yr22 = LocalDate.of(2022, 1, 2);

        long dayBetween;
        dayBetween = ChronoUnit.DAYS.between(nov1yr21, jan2yr22);
        System.out.println(
                nov1yr21 + "was" + nov1yr21.getDayOfWeek() + ". It is " + dayBetween + " days to Saturday 2022-01-02");

        numDaysFromDate(16, 9, 2003, 2);
    }
    
    static void numDaysFromDate(int date, int month, int year, int myBD) {
        int daysBornTil31Dec2021 = 0;
        int allYearDay = 365 * (2021 - (year-1));
        int daysTilBirth = 0;
        int leapDay = 0;
        int[] lDateofMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = year; i <= 2021; ++i) {
            if (i % 4 == 0) {
                leapDay += 1;
                System.out.println("     " +leapDay);
                System.out.println(i);
            }
        }
        int yearWithLeap = allYearDay + leapDay;
        System.out.println(yearWithLeap);
        for (int j = month-2; j >= 0 ; --j) {
            int a = lDateofMonth[j];
            System.out.println(a);
            daysTilBirth += a;
        }
        System.out.println("after: "+daysTilBirth);
        daysBornTil31Dec2021 = yearWithLeap - daysTilBirth -date;
        int daysBornTil2Jan2022 = daysBornTil31Dec2021 + 2; // shift to Sunday Jan 02 2022
        System.out.println(daysBornTil2Jan2022);
        String str = showResult(date, month, year, myBD, daysBornTil2Jan2022);
        System.out.print(str);
    }

    static String showResult(int date, int month, int year, int myBD, int fromNumDaysFromDate) {
        String[] dayName = { "Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday" };
        int dayFromSun = 0;
        int modResult = fromNumDaysFromDate % 7;
        dayFromSun = 7 - modResult;
        String str = String.format(
                "You were born on %s and have been born for %d days (2 Jan 2022).Your program says %s", dayName[myBD],
                fromNumDaysFromDate, dayName[dayFromSun]);
        return str;
    }
}