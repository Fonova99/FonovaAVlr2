import java.util.Arrays;

public class IntroSort {
    HeapSort heapi = new HeapSort();
    private static final int INSERTION_SORT_THRESHOLD = 10;

    public void introSort(int[] arr) {
        int depthLimit = 2 * (int) Math.floor(Math.log(arr.length) / Math.log(2));
        sort(arr, depthLimit, 0, arr.length - 1);
    }

    private void sort(int[] arr, int depthLimit, int begin, int end) {
        int size = end - begin;

        if (size < INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, begin, end);
            return;
        }

        if (depthLimit == 0) {
            heapSort(arr, begin, end);
            return;
        }

        int pivotIndex = medianOfThree(arr, begin, begin + size / 2, end);
        pivotIndex = partition(arr, begin, end, pivotIndex);
        sort(arr, depthLimit - 1, begin, pivotIndex - 1);
        sort(arr, depthLimit - 1, pivotIndex + 1, end);
    }

    private void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= begin && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private void heapSort(int[] sortArr, int begin, int end) {
        int[] heap = Arrays.copyOfRange(sortArr, begin, end + 1);
        heapi.heapSort(heap);
        System.arraycopy(heap, 0, sortArr, begin, heap.length);
    }

    private int medianOfThree(int[] arr, int a, int b, int c) {
        return (arr[a] < arr[b] ?
                (arr[b] < arr[c] ? b : arr[a] < arr[c] ? c : a) :
                (arr[a] < arr[c] ? a : arr[b] < arr[c] ? c : b));
    }

    private int partition(int[] arr, int begin, int end, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int storeIndex = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, end, storeIndex);
        return storeIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
