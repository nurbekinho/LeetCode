package leetcode.YY20.MM07;

public class DD14_AngleBetweenHandsOfClock {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(4, 50));
        System.out.println(angleClock(12, 0));
        System.out.println(angleClock(12, 0));
        System.out.println(angleClock(12, 45));
    }

    public static double angleClock(int hour, int minutes) {
        double ha = (hour == 12 ? 0d : 360.0 / 12 * hour) + (minutes > 0 ? minutes / 2.0 : 0d);
        double ma = (minutes == 0) ? 0d : 360.0 / 60 * minutes;
        double angle = Math.max(ha, ma) - Math.min(ha, ma);

        return angle < 180 ? angle : 360 - angle;
    }
}
