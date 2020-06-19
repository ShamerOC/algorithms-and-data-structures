package Problems;

public class KnapsackProblem {
    int capacity;
    int n;
    static int[] tab;
    static boolean found;
    static String out = "";

    public KnapsackProblem(int[] tab, int capacity) {
        KnapsackProblem.tab = tab;

        System.out.println(problem(tab.length - 1, capacity));
        System.out.println(out);

    }


    static boolean problem (int k, int capacity) {
        boolean result;
        if (found) {
            result = false;
        } else if (capacity == 0) {
            result = true;
            if (k >= 0 ) {
                out += tab[k] + " ";
            }
            found = true;
        } else if (k < 0) {
            result = false;
        } else if (tab[k] > capacity) {
            result = problem(k - 1, capacity);
        } else {
            boolean one = problem(k - 1, capacity);
            boolean two = problem(k - 1, capacity - tab[k]);
            result = one || two;
            if (two) {
                out += tab[k] + " ";
            }
        }

        return result;
    }
}
