import java.util.Calendar;
import java.util.Date;

public class Try {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,48);
        calendar.add(Calendar.DATE,-7);
        calendar.set(Calendar.DAY_OF_WEEK,5);
        System.out.println((Date)calendar.getTime());
    }
}
