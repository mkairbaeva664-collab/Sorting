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
        int[] sizes = {10, 100, 1000}; // Размеры из задания [cite: 1, 55]
        String[] types = {"Random", "Sorted"};

        for (int size : sizes) {
            for (String dataType : types) {
                System.out.println("\n--- Experiment: Size " + size + ", Data: " + dataType + " ---");

                // 1. Генерация исходного массива [cite: 1, 30]
                int[] originalArray = sorter.generateRandomArray(size);
                if (dataType.equals("Sorted")) {
                    sorter.advancedSort(originalArray);
                }

                // Выводим неотсортированный список (только для небольших размеров для чистоты вывода )
                if (size <= 10) {
                    System.out.print("Original Array: ");
                    sorter.printArray(originalArray);
                }

                // 2. Подготовка копий для честного сравнения
                int[] copyForBasic = originalArray.clone();
                int[] copyForAdvanced = originalArray.clone();

                // 3. Замер времени и сортировка [cite: 1, 37, 70]
                long basicTime = measureSortTime(copyForBasic, "basic");
                long advancedTime = measureSortTime(copyForAdvanced, "advanced");

                // Выводим отсортированный список (для Small размера)
                if (size <= 10) {
                    System.out.print("Sorted Array (Basic): ");
                    sorter.printArray(copyForBasic);
                    System.out.print("Sorted Array (Advanced): ");
                    sorter.printArray(copyForAdvanced);
                }

                // 4. Поиск (Binary Search требует отсортированного массива [cite: 1, 82])
                int target = copyForAdvanced[size - 1]; // Ищем последний элемент
                long searchTime = measureSearchTime(copyForAdvanced, target);

                // 5. Вывод времени [cite: 1, 72]
                System.out.println("Time Basic Sort: " + basicTime + " ns");
                System.out.println("Time Advanced Sort: " + advancedTime + " ns");
                System.out.println("Time Search: " + searchTime + " ns");
            }
        }
    }
}
