public class TimSort {
    private static final int RUN = 32;

    public void timSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i += RUN) {
            insert(sortArr, i, Math.min((i + RUN - 1), (sortArr.length - 1)));
        }

        for (int size = RUN; size < sortArr.length; size = 2 * size) {
            for (int left = 0; left < sortArr.length; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (sortArr.length - 1));
                merge(sortArr, left, mid, right);
            }
        }
    }

    public void insert(int[] sortArr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int number = sortArr[i];
            int j = i;
            while (j > left && number < sortArr[j - 1]) {
                sortArr[j] = sortArr[j - 1];
                j--;
            }
            sortArr[j] = number;
        }
    }

    public void merge(int[] sortArr, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        int[] leftArr = new int[lengthLeft];
        int[] rightArr = new int[lengthRight];

        for (int i = 0; i < lengthLeft; i++) {
            leftArr[i] = sortArr[left + i];
        }

        for (int j = 0; j < lengthRight; j++) {
            rightArr[j] = sortArr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < lengthLeft && j < lengthRight) {
            if (leftArr[i] <= rightArr[j]) {
                sortArr[k] = leftArr[i];
                i++;
            } else {
                sortArr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < lengthLeft) {
            sortArr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < lengthRight) {
            sortArr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
