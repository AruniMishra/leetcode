public class p2187_MinimumTimeCompleteTrips {

    public static void main(String[] args) {
        int[] time = {2, 2, 3};
        int totalTrips = 5;

        System.out.println(new p2187_MinimumTimeCompleteTrips().minimumTime(time, totalTrips));
    }

    public long minimumTime(int[] time, int totalTrips) {


        int sumtime = 0;
        boolean iterate = true;
        int counterTime = 0;

        while (iterate) {
            ++counterTime;
            for (int n : time) {
                sumtime += (int) Math.floor(counterTime / n);
            }
            System.out.println(sumtime);
            if (sumtime >= totalTrips) {
                iterate = false;
            }
            sumtime = 0;
        }
        return counterTime;
    }
}
