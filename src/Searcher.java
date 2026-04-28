public class Searcher {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;     //check in the left side
            } else {
                start = mid + 1;   //check in the right side
            }
        }
        return -1;
    }
}
