public class p1539_KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;


        System.out.println(new p1539_KthMissingPositiveNumber().findKthPositive(arr, k));
    }


    /**
     * We increase k everytime until with we get an element on the array greater than it
     *
     * @param arr
     * @param k
     * @return
     */
    public int findKthPositive2(int[] arr, int k) {
        for (int i : arr) {
            // System.out.println(i + "<=" + k);
            if (i <= k) {
                System.out.println(i + "<=" + k);
                k++;
            } else break;
        }


        return k;
    }

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int missing = compute(arr[n - 1], n);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            missing = compute(arr[mid], mid + 1);

            if (missing >= k) right = mid - 1;
            else left = mid + 1;
        }

        // Right -> -1;
        if (right == -1) return k;
        return arr[right] + k - compute(arr[right], right + 1);

    }

    int compute(int actual, int expected) {
        return actual - expected;
    }
}
