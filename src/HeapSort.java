public class HeapSort {
    public void heapSort(int[] sortArr) {
        int n = sortArr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(sortArr, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = sortArr[0];
            sortArr[0] = sortArr[i];
            sortArr[i] = temp;

            heapify(sortArr, 0, i);
        }
    }

    public void heapify(int[] sortArr, int i, int n) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && sortArr[leftChild] > sortArr[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && sortArr[rightChild] > sortArr[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = sortArr[i];
            sortArr[i] = sortArr[largest];
            sortArr[largest] = temp;

            heapify(sortArr, largest, n);
        }
    }
}
