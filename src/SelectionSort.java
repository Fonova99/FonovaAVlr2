public class SelectionSort {
    //Сортировка выбором.
    //Сначала проходимся по всему массиву, сравнивая элементы между собой.
    //Находим самый минимальный элемент.
    //Записываем индекс минимального элемента, и меняем местами элементы (минимальный элемент с элементом с нулевым индекс)
    //Повторяем процедуру
    public void selectionSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            int index = i;
            int min = sortArr[i]; //устанавливаем условный минимум
            //проходимся по массиву и находим самый минимальный элемент
            for (int j = i + 1; j < sortArr.length; j++) {
                if (sortArr[j] < min) {
                    index = j;
                    min = sortArr[j];
                }
            }
            //меняем местами элементы
            int temp = sortArr[i];
            sortArr[i] = sortArr[index];
            sortArr[index] = temp;
        }
    }
}
