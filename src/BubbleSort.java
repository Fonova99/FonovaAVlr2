public class BubbleSort {
    //Сортировка пузырьком.
    //Элементы поочередно сравниваются друг с другом во вложенном цикле
    public void bubbleSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            for (int j = 0; j < sortArr.length - 1; j++) {
                if (sortArr[j] > sortArr[j + 1]) {
                    int temp = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = temp;
                }
            }
        }
    }
}
