import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GregorianCalendarTest {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat format = new SimpleDateFormat("-yyyy-MM-dd-hh-mm-ss");
        String time = format.format(calendar.getTime());
        System.out.printf(time);
    }
}
