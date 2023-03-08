import java.util.Arrays;

public class p2187_MinimumTimeCompleteTrips {

    public static void main(String[] args) {
        int[] time = {10000};
        int totalTrips = 10000000;

        System.out.println(new p2187_MinimumTimeCompleteTrips().minimumTime(time, totalTrips));
    }


    /**
     * BFS
     * <p>
     * The range of time will be lowest value of the time array and highest value will be
     * minimum value in the time array multiplied by totalTrips
     * because at worst case the bus with min time will do all trips
     * which will be minimum time taken to do all trips or you can take maximum value in time array
     * multiplied by totalTrips if you are thinking in this way that at worstcase the bus with highest time
     * will do all the trips. As the question is asking for minimum time so first one makes more sense than later one.
     * But both are correct because obviously it will be eliminating right half if it gets totalTrips done with that
     * particular time.
     *
     * @param time
     * @param totalTrips
     * @return
     */
    public long minimumTime(int[] time, int totalTrips) {

        long low = Arrays.stream(time).min().getAsInt();
        //casting required, to prevent overflow
        long high = (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        System.out.println(low);
        System.out.println(high);

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (blackbox(mid, totalTrips, time)) {
                high = mid;
            } else
                low = mid + 1;
        }

        return low;
    }


    public boolean blackbox(long isvalidtime, int totalTrips, int[] time) {
        long trips = 0;
        for (int it : time) {
            trips += isvalidtime / it;
        }
        if (trips >= totalTrips)
            return true;
        return false;
    }


    /**
     * working logic, however it is not optimized(TLE)
     *
     * @param time
     * @param totalTrips
     * @return
     */
    public long minimumTime2(int[] time, int totalTrips) {

        int curr_trips = 0;
        boolean iterate = true;
        int counterTime = 0;

        while (iterate) {
            ++counterTime;
            for (int n : time) {
                curr_trips += (int) Math.floor(counterTime / n);
            }
            System.out.println(curr_trips);
            if (curr_trips >= totalTrips) {
                iterate = false;
            }
            curr_trips = 0;
        }
        return counterTime;
    }
}
