import java.util.Arrays;

public class Tortoise {
    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) {
            return new int[]{-1, -1, -1};
        }

        double v1s = v1 / 60.0 / 60.0;
        double v2s = v2 / 60.0 / 60.0;

        double s1 = g;
        double s2 = 0;
        double s = 0;

        while (s1 > s2) {
            s++;
            s1 += v1s;
            s2 += v2s;
        }

        s -= (s2 - s1) / v2;
        int h = (int) Math.nextDown(s / 60 / 60);
        int m = (int) Math.nextDown(s / 60 % 60) ;
        int sec = (int) Math.nextDown(s % 60 % 60);

        return new int[]{h, m, sec};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(race(720, 850, 70)));
    }
}