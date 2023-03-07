/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 * <p>
 * Return the single element that appears only once.
 * <p>
 * Your solution must run in O(log n) time and O(1) space.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 */
public class p0540_SingleElementSortedArray {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 2, 3, 3, 4, 4};

        p0540_SingleElementSortedArray singleElementSortedArray0540 = new p0540_SingleElementSortedArray();

        System.out.println(singleElementSortedArray0540.singleNonDuplicate2(numbers));
    }


    /**
     * if nums[mid] is same as previous and it is at odd position then it's at correct position and;
     * if nums[mid] is same as it's next and it is at even position then it's at correct position;
     * so there must be our answer is in right of the mid otherwise it must be in left.
     */
    public int singleNonDuplicate(int[] nums) {

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1]))
                start = mid + 1;
            else end = mid;
        }
        return nums[start];
    }

    public int singleNonDuplicate2(int[] nums) {
        // if(nums.length==1) return nums[0];
        int ans = 0;


        /*
         * XOR
         */
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];

        }
        return ans;
    }
}


