public class ShellSort {
    public void shellSort(int[] sortArr) {
        int step = 1;
//      Сокращение интервалов.
//	    Для массивов большего размера сортировка должна начинаться с намного большего интервала,
//	    который затем последовательно сокращается вплоть до 1. Согласно Кнуту, значение интервала генерируется по формуле
//	    h = 3*h + 1
        while (step <= sortArr.length / 3) {
            step = step * 3 + 1;
        }

        while (step > 0) {
            for (int i = step; i < sortArr.length; i++) {
                for (int j = i; j >= step && sortArr[j] < sortArr[j - step]; j = j - step) {
                    int temp = sortArr[j];
                    sortArr[j] = sortArr[j - step];
                    sortArr[j - step] = temp;
                }
            }
            step = (step - 1) / 3;
        }

    }
}
