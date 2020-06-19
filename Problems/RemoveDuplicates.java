package Problems;

public class RemoveDuplicates { // works only on sorted array

    public int[] removeDuplicates (int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[arr.length - 1];
        int[] res = new int[j];
        for (int i = 0; i < j; i++) {
            res[i] = arr[i];
        }

        return res;
    }


}
