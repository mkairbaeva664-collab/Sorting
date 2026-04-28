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
}
