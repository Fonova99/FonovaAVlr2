public class MergeSort {
    public void mergeSort(int[] sortArr) {
        if (sortArr.length == 1) return;
        int middle = sortArr.length / 2;
        int[] left = new int[middle];
        int[] right = new int[sortArr.length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = sortArr[i];
        }

        for (int i = middle; i < sortArr.length; i++) {
            right[i - middle] = sortArr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(sortArr, left, right);
    }

    public void merge(int[] sortArr, int[] arrLeft, int[] arrRight) {
        int indexLeft = 0;
        int indexRight = 0;
        int indexArr = 0;

        while (indexLeft < arrLeft.length && indexRight < arrRight.length) {
            if (arrLeft[indexLeft] < arrRight[indexRight]) {
                sortArr[indexArr] = arrLeft[indexLeft];
                indexLeft++;
                indexArr++;
            } else {
                sortArr[indexArr] = arrRight[indexRight];
                indexRight++;
                indexArr++;
            }
        }

        for (int i = indexLeft; i < arrLeft.length; i++) {
            sortArr[indexArr] = arrLeft[i];
            indexArr++;
        }

        for (int j = indexRight; j < arrRight.length; j++) {
            sortArr[indexArr] = arrRight[j];
            indexArr++;
        }
    }
}
