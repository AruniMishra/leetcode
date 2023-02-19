/**
 * Search Insert Position
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */

public class SearchInsertPosition0035 {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 5, 6};
        SearchInsertPosition0035 searchInsertPosition0035 = new SearchInsertPosition0035();
        System.out.println(searchInsertPosition0035.searchInsert(numbers, 7));
    }

    public int searchInsert(int[] nums, int target) {

        int index = 0;
        for (int n : nums) {
            if (target <= n) {
                return index;
            } else if ((index + 1 < nums.length) && (target < nums[index + 1])) {
                return ++index;
            }
            index++;
        }
        return index;
    }

    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
