public class Sorter {

    public void basicSort(int[] arr) {
        //Selection Sort
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int indexOfMin = i;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    indexOfMin = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[indexOfMin];
            arr[indexOfMin] = temp;
        }
    }

    public void advancedSort(int[] arr) {
        if(arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}
