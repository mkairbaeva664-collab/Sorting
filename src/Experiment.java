import org.w3c.dom.ls.LSOutput;

public class Experiment {
    private Sorter sorter = new Sorter();

    public long measureSortTime(int[] arr, String type) {
        long startTime = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(arr);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(arr);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {
        Searcher searcher = new Searcher();
        long startTime = System.nanoTime();

        searcher.search(arr, target);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public void runAllExperiments() {
        Sorter sorter = new Sorter();
        int[] sizes = {10, 100, 1000};
        String[] types = {"Random", "Sorted"};

        for (int size : sizes) {
            for (String dataType : types) {
                int[] array;

                if (dataType.equals("Random")) {
                    array = sorter.generateRandomArray(size);
                } else {
                    array = sorter.generateRandomArray(size);
                    sorter.advancedSort(array);
                }

                int[] copyForBasic = array.clone();
                int[] copyForAdvanced = array.clone();

                long basicTime = measureSortTime(copyForBasic, "basic");
                long advancedTime = measureSortTime(copyForAdvanced, "advanced");

                int target = copyForAdvanced[size - 1];
                long searchTime = measureSearchTime(copyForAdvanced, target);

                System.out.printf("%-10d | %-10s | %-15d | %-15d | %-15d%n",
                        size, dataType, basicTime, advancedTime, searchTime);
            }
        }
    }
}
