package Sort;

public class QuickSort {

    public void sort (int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int partition (int[] arr, int left, int right) { // hoare
        int pivot = arr[right];
        int i = left - 1;
        int j = right;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot && j > left);

            if (i >= j) {
                break;
            } else {
                swap (arr, i , j);
            }
        }
        swap (arr, i, right);

        return i;
    }

    private int partition2 (int[] arr, int left, int right) { // lomuto
        return 0;
    }


    private void swap (int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
