package Problems;

public class Main {

    public static void main (String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 5};
        arr = removeDuplicates.removeDuplicates(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +  " ");
        }
        System.out.println();

        int[] arr1 = {1, 5, 1, 2, 4};

        new KnapsackProblem(arr1, 10);

        ClosestProduct closestProduct = new ClosestProduct();

        int[] result = closestProduct.findClosestProduct(new int[]{2, 8, 9, 5}, 15);
        System.out.println(result[0] + " " + result[1]);

    }
}