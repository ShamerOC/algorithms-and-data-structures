package Sort;

public class MergeSort {

    public void sort (int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort (int[] arr, int left, int right) {
        if (left >= right) return;

        int middle = (left + right) / 2;

        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);

        merge(arr, left, middle, right);

    }

    private void merge (int[] arr, int left, int middle, int right) {
        int[] temp = new int[arr.length];

        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int leftStart = left;

        int rightStart = middle + 1;
        int i = left;

        while (leftStart <= middle && rightStart <= right) {
            if (temp[leftStart] <= temp[rightStart]) arr[i++] = temp[leftStart++];
            else arr[i++] = temp[rightStart++];
        }

        while (leftStart <= middle) arr[i++] = temp[leftStart++];
        while (rightStart <= right) arr[i++] = temp[rightStart++];

    }
}
