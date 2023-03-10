import java.util.Arrays;

/**
 * A conveyor belt has packages that must be shipped from one port to another
 * within days days.
 * <p>
 * The ith package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt (in the order
 * given by weights).
 * We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the
 * packages on the conveyor belt
 * being shipped within days.
 *
 * <p>
 * </p>
 * <p>
 * Example 1:
 * </p>
 * <p>
 * <p>
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * <p>
 * </p>
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in
 * 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * <p>
 * Note that the cargo must be shipped in the order given, so using a ship of
 * capacity 14 and splitting the packages
 * into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 *
 * <p>
 * <code>
 *     public static void main(String[] args) {
 *         int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
 *         int days = 5;
 *
 *         CapacityShipPackageWithinDDays1011 capacity = new CapacityShipPackageWithinDDays1011();
 *         System.out.println(capacity.shipWithinDays(weights, days));
 *     }
 * </code>
 */

public class p1011_CapacityShipPackageWithinDDays {
    public static void main(String[] args) {
        int[] weights = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        p1011_CapacityShipPackageWithinDDays capacity = new p1011_CapacityShipPackageWithinDDays();
        System.out.println(capacity.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0; // minimum quantity is the maximum weight
        int right = 0; // max weight(sum of all weights in case needs to deliver in 1 day)
        // for (int i : weights) {
        // left = Math.max(left, i);
        // right += i;
        // }

        left = Arrays.stream(weights).max().getAsInt();
        right = Arrays.stream(weights).sum();

        int mid;

        int ans = right;

        while (left <= right) {
            mid = (left + right) / 2;
            if (check(weights, days, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean check(int[] weights, int days, int capacity) {
        int requiredDays = 1;
        int currWeight = 0;
        for (int i : weights) {
            if (currWeight + i > capacity) {
                requiredDays++;
                currWeight = 0;
            }
            currWeight += i;
        }
        if (requiredDays > days)
            return false;
        return true;
    }
}
