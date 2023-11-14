public class QuickSort {
    //Быстрая сортировка.
    //Сначала выбирается опорный элемент, в нашем случае это середина массива
    //Далее элементы меньше опорно переносим влево, а больше - вправо
    //Потом массив разделенный на две части, делится еще раз, и так далее
    public void quickSort(int[] sortArr, int from, int to) {
        int middle = from + (to - from) / 2; //выбираем средний элемент
        int posMiddle = sortArr[middle];

        int i = from;
        int j = to;
        while (i <= j) {
            while (sortArr[i] < posMiddle) {
                i++;
            }
            while (sortArr[j] > posMiddle) {
                j--;
            }
            if (i <= j) {
                int temp = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = temp;
                i++;
                j--;
            }
        }

        if (from < j) {
            quickSort(sortArr, from, j);
        }
        if (to > i) {
            quickSort(sortArr, i, to);
        }
    }
}
