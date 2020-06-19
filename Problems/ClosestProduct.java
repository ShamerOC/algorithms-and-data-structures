package Problems;

public class ClosestProduct {

    int[] findClosestProduct (int[] arr, int val) {

        quickSort(arr, 0, arr.length - 1);

        int bestResult = val - (arr[0] * arr[1]);
        int bestFirst = 0;
        int bestSecond = 1;

        for (int i = 0; i < arr.length; i++) {
            int l = 0;
            int r = arr.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;

                int result = arr[i] * arr[mid];

                if (result == val && mid != i) {
                    return new int[]{arr[i], arr[mid]};
                }
                if (result < val) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

                result = val - result;

                if (result < 0) {
                    result *= -1;
                }

                if (result < bestResult) {
                    bestResult = result;
                    bestFirst = i;
                    bestSecond = mid;
                }
            }
        }

        return new int[]{arr[bestFirst], arr[bestSecond]};

    }

    private void quickSort (int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int partition (int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        int j = right;


        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (j > left && arr[j] > pivot);

            if (i >= j) {
                break;
            } else {
                swap (arr, i, j);
            }
        }
        swap (arr, right, i);

        return i;
    }

    private void swap (int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
