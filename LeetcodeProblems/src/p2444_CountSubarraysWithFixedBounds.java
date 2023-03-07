/**
 * You are given an integer array nums and two integers minK and maxK.
 * <p>
 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
 * <p>
 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * Output: 2
 * Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1], minK = 1, maxK = 1
 * Output: 10
 * Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 */

public class p2444_CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;
        System.out.println(new p2444_CountSubarraysWithFixedBounds().countSubarrays(nums, minK, maxK));
    }

    /**
     * @param nums
     * @param minK
     * @param maxK
     * @return
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // minPosition, maxPosition: the MOST RECENT positions of minK and maxK.
        // leftBound: the MOST RECENT value outside the range [minK, maxK].
        long answer = 0;
        int minPosition = -1, maxPosition = -1, leftBound = -1;

        // Iterate over nums, for each number at index i:
        for (int i = 0; i < nums.length; ++i) {
            // If the number is outside the range [minK, maxK], update the most recent leftBound.
            if (nums[i] < minK || nums[i] > maxK)
                leftBound = i;

            // If the number is minK or maxK, update the most recent position.
            if (nums[i] == minK)
                minPosition = i;
            if (nums[i] == maxK)
                maxPosition = i;

            // The number of valid subarrays equals the number of elements between leftBound and
            // the smaller of the two most recent positions (minPosition and maxPosition).
            answer += Math.max(0, Math.min(maxPosition, minPosition) - leftBound);
        }
        return answer;
    }
}
