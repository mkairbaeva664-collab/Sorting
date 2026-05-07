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
        int[] sizes = {10, 100, 1000};
        String[] types = {"Random", "Sorted"};

        for (int size : sizes) {
            for (String dataType : types) {
                System.out.println("\nSize " + size + ", Data: " + dataType);

                int[] arr = sorter.generateRandomArray(size);
                if (dataType.equals("Sorted")) {
                    sorter.advancedSort(arr);
                }

                if (size <= 10) {
                    System.out.print("Original: ");
                    sorter.printArray(arr);
                }

                long basicTime = measureSortTime(arr.clone(), "basic");
                long advancedTime = measureSortTime(arr.clone(), "advanced");

                sorter.advancedSort(arr);
                long searchTime = measureSearchTime(arr, arr[size - 1]);

                if (size <= 10) {
                    System.out.print("Sorted: ");
                    sorter.printArray(arr);
                }

                System.out.println("Time Basic Sort: " + basicTime + " ns");
                System.out.println("Time Advanced Sort: " + advancedTime + " ns");
                System.out.println("Time Search: " + searchTime + " ns");
            }
        }
    }
}
