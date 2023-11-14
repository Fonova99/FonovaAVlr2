import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int choice;

        System.out.print("Введите размерность массива: ");
        int size = scanner.nextInt();

        int[] sortArr = new int[size];
        int start = 0;
        int end = sortArr.length - 1;

        for (int i = 0; i < size; i++) {
            sortArr[i] = random.nextInt(100);
        }

        System.out.println("\nСгенерированный массив: ");
        for (int i = 0; i < size; i++) {
            System.out.print(sortArr[i] + " ");
        }

        while (true) {
            System.out.println("\n\n1.Сортировка выбором");
            System.out.println("2.Сортировка вставками");
            System.out.println("3.Сортировка пузырьком");
            System.out.println("4.Сортировка слиянием");
            System.out.println("5.Быстрая сортировка");
            System.out.println("6.Сортировка Шелла");
            System.out.println("7.Пирамидальная сортировка");
            System.out.println("8.TimSort");
            System.out.println("9.IntroSort");
            System.out.println("10.Выйти из программы");
            System.out.println("\nВыберите номер действия:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Выполнена сортировка выбором:");
                    SelectionSort select = new SelectionSort();
                    select.selectionSort(sortArr);
                    printArray(sortArr);
                    break;
                case 2:
                    System.out.println("Выполнена сортировка вставками:");
                    InsertSort insert = new InsertSort();
                    insert.insertionSort(sortArr);
                    printArray(sortArr);
                    break;
                case 3:
                    System.out.println("Выполнена сортировка пузырьком:");
                    BubbleSort bubble = new BubbleSort();
                    bubble.bubbleSort(sortArr);
                    printArray(sortArr);
                    break;
                case 4:
                    System.out.println("Выполнена сортировка слиянием:");
                    MergeSort merge = new MergeSort();
                    merge.mergeSort(sortArr);
                    printArray(sortArr);
                    break;
                case 5:
                    System.out.println("Выполнена быстрая сортировка:");
                    QuickSort quick = new QuickSort();
                    quick.quickSort(sortArr, start, end);
                    printArray(sortArr);
                    break;
                case 6:
                    System.out.println("Выполнена сортировка Шелла:");
                    ShellSort shell = new ShellSort();
                    shell.shellSort(sortArr);
                    printArray(sortArr);
                    break;
                case 7:
                    System.out.println("Выполнена пирамидальная сортировка:");
                    HeapSort heapi = new HeapSort();
                    heapi.heapSort(sortArr);
                    printArray(sortArr);
                    break;
                case 8:
                    System.out.println("Выполнена сортировка TimSort:");
                    TimSort tim = new TimSort();
                    tim.timSort(sortArr);
                    printArray(sortArr);
                    break;
                case 9:
                    System.out.println("Выполнена сортировка IntroSort:");
                    IntroSort intro = new IntroSort();
                    intro.introSort(sortArr);
                    printArray(sortArr);
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Неправильный выбор");
            }
        }
    }
}
