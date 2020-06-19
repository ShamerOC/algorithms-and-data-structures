package Sort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[rand.nextInt(100) + 1000];
        populateWithRandomElements(arr);

        long start, end, timeElapsed;

        System.out.println("Bubble Sort");
        start = System.currentTimeMillis();
        bubbleSort(arr);
        end = System.currentTimeMillis();
        timeElapsed = end - start;
        System.out.println("Time elapsed: " + timeElapsed);
        System.out.println();


        System.out.println("Selection Sort");
        start = System.currentTimeMillis();
        selectionSort(arr);
        end = System.currentTimeMillis();
        timeElapsed = end - start;
        System.out.println("Time elapsed: " + timeElapsed);
        System.out.println();


        System.out.println("Insertion Sort");
        start = System.currentTimeMillis();
        insertionSort(arr);
        end = System.currentTimeMillis();
        timeElapsed = end - start;
        System.out.println("Time elapsed: " + timeElapsed);
        System.out.println();

        System.out.println("Advanced Sorting Methods");

        System.out.println("Merge Sort");
        start = System.currentTimeMillis();
        mergeSort(arr);
        end = System.currentTimeMillis();
        timeElapsed = end - start;
        System.out.println("Time elapsed: " + timeElapsed);
        System.out.println();


        System.out.println("Quick Sort");
        start = System.currentTimeMillis();
        quickSort(arr);
        end = System.currentTimeMillis();
        timeElapsed = end - start;
        System.out.println("Time elapsed: " + timeElapsed);
        System.out.println();

    }

    public static void bubbleSort (int[] arr) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arrCpy = new int[arr.length];
        copyArray(arr, arrCpy);

        bubbleSort.sort(arrCpy);
        print(arrCpy);
    }

    public static void selectionSort (int[] arr) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arrCpy = new int[arr.length];
        copyArray(arr, arrCpy);

        selectionSort.sort(arrCpy);
        print(arrCpy);
    }

    public static void insertionSort (int[] arr) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arrCpy = new int[arr.length];
        copyArray(arr, arrCpy);

        insertionSort.sort(arrCpy);
        print(arrCpy);
    }

    public static void mergeSort (int[] arr) {
        MergeSort mergeSort = new MergeSort();
        int[] arrCpy = new int[arr.length];
        copyArray(arr, arrCpy);

        mergeSort.sort(arrCpy);
        print(arrCpy);
    }

    public static void quickSort (int[] arr) {
        QuickSort quickSort = new QuickSort();
        int[] arrCpy = new int[arr.length];
        copyArray(arr, arrCpy);

        quickSort.sort(arrCpy);
        print(arrCpy);
    }

    private static void populateWithRandomElements (int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(5000);
        }
    }

    private static void copyArray (int[] arr, int[] arrCpy) {
        for (int i = 0; i < arr.length; i++) {
            arrCpy[i] = arr[i];
        }
    }

    private static void print (int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
