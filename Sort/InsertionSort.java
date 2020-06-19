package Sort;

public class InsertionSort {

    public void sort (int[] arr) {
        insertionSort(arr);
    }

    private void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j = i - 1;
            while (j >= 0 && v < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = v;
        }
    }
}
