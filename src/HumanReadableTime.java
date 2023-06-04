import java.util.Date;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int h = 0;
        int m = 0;
        int s;

        if (seconds >= 60 * 60) {
            h = seconds / 3600;
            m = seconds % 3600 / 60;
            s = seconds % 3600 % 60;
        } else if (seconds >= 60) {
            m = seconds / 60;
            s = seconds % 60;
        } else {
            s = seconds;
        }

        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static void main(String[] args) {
        System.out.println(makeReadable(86399));
    }
}
