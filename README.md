# Assignment 3: Sorting and Searching Algorithms

## Student Information
* **Name:** Kairbayeva Madina
* **Group:** IT-2504

---

## A. Project Overview
**Description of selected algorithms:** This project implements three fundamental algorithms in Java: Selection Sort (as the Basic algorithm), Quick Sort (as the Advanced algorithm), and Binary Search. 

**Purpose of the experiment:** The primary purpose is to empirically test and compare the performance of algorithms with different theoretical time complexities. By measuring execution times in nanoseconds across different array sizes and data states (random vs. sorted), the experiment aims to demonstrate the real-world impact of algorithmic efficiency.

---

## B. Algorithm Descriptions

### 1. Selection Sort (Basic Sort)
* **How it works:** It divides the array into a sorted and an unsorted region. It repeatedly iterates through the unsorted region to find the minimum element and swaps it with the first element of the unsorted part.
* **Time complexity:** $O(n^2)$ in all cases (Best, Average, Worst).

### 2. Quick Sort (Advanced Sort)
* **How it works:** A "Divide and Conquer" algorithm. It selects a 'pivot' element (in this case, the last element) and partitions the array so that all smaller elements are to the left of the pivot and all larger elements are to the right. It then recursively applies this process to the sub-arrays.
* **Time complexity:** $O(n \log n)$ on average, but degrades to $O(n^2)$ in the worst case (e.g., when the array is already sorted and the last element is picked as the pivot).

### 3. Binary Search
* **How it works:** It efficiently finds a target value within a sorted array by repeatedly dividing the search interval in half. If the target is less than the middle element, it narrows the interval to the lower half, otherwise to the upper half.
* **Time complexity:** $O(\log n)$.

---

## C. Experimental Results

### Execution Times Table
| Size | Data Type | Basic Sort (ns) | Advanced Sort (ns) | Binary Search (ns) |
| :--- | :--- | :--- | :--- | :--- |
| 10 | Random | 12300 ns | 11800 ns | 3400 ns |
| 10 | Sorted | 4400 ns | 6700 ns | 1100 ns |
| 100 | Random | 108600 ns | 32800 ns | 1400 ns |
| 1000 | Random | 3293000 ns | 165300 ns | 2200 ns |

### Comparisons
* **Different input sizes:** Different input sizes: As the data size increased from 10 to 1000 elements, Basic Sort (Selection Sort) showed an exponential increase in time, jumping from ~12k ns to over 3.2 million ns. In contrast, Advanced Sort (Quick Sort) scaled much better, reaching only ~165k ns for 1000 elements. This clearly demonstrates the practical difference between $O(n^2)$ and $O(n \log n)$ complexities.
* **Sorted vs unsorted arrays:** For a small size of 10, Selection Sort was surprisingly faster on sorted data (4400 ns) compared to random data (12300 ns). Quick Sort also performed better on sorted data (6700 ns) than on random data (11800 ns) at this small scale.
---

## D. Screenshots

**Program Output and Test Runs:**

<img width="547" height="196" alt="Снимок экрана 2026-05-07 232932" src="https://github.com/user-attachments/assets/71fece4d-0e1b-4bd5-ac7b-17d0440ac5bb" />

<img width="523" height="186" alt="Снимок экрана 2026-05-07 233008" src="https://github.com/user-attachments/assets/176181e8-09de-41ff-8d32-2e41e3696756" />

<img width="317" height="127" alt="Снимок экрана 2026-05-07 233038" src="https://github.com/user-attachments/assets/743b50bc-497c-4c46-96a1-341594c69283" />

<img width="328" height="137" alt="Снимок экрана 2026-05-07 233104" src="https://github.com/user-attachments/assets/c1fb2dcb-34b6-4319-bfad-f99143dfa271" />

<img width="337" height="126" alt="Снимок экрана 2026-05-07 233124" src="https://github.com/user-attachments/assets/d385f6bd-5f62-4eeb-9141-ab8bdd4b69ec" />

<img width="366" height="120" alt="Снимок экрана 2026-05-07 233144" src="https://github.com/user-attachments/assets/3d7cda23-3f5b-4bb5-8d53-7008d5c6589c" />

<img width="321" height="112" alt="Снимок экрана 2026-05-07 233206" src="https://github.com/user-attachments/assets/34bfde18-f15e-45f1-a1fc-a6ff67f8dc51" />

---

## E. Reflection Section

Through this project, I learned how crucial the choice of an algorithm is when dealing with scaling data. Theoretical concepts became highly visible in practical execution: the transition from $O(n^2)$ to $O(n \log n)$ complexity is not just mathematical theory, but a massive difference in real CPU time, especially noticeable when moving from 100 to 1000 elements. I also clearly observed how specific data states (like pre-sorted arrays) can unexpectedly bottleneck advanced algorithms if they are not optimized for it.

One of the main challenges during implementation was a logical error at the beginning, where I incorrectly defined the conditions for the Basic Sort, leading to incorrect results. It took time to debug the code and ensure that the algorithm was following the $O(n^2)$ logic properly. Additionally, it was quite difficult to organize the methods within the Experiment class; managing the flow between generating arrays, measuring time, and printing results required careful structuring to avoid confusion. Overcoming these challenges helped me improve my debugging skills and my ability to organize complex Java projects.
