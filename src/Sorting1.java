public class Sorting1 {

    public static void insertionSort(int[] A) {
        if (A == null || A.length == 0) return;
        for (int i = 0; i < A.length; i++) {
            int j = i;
            while (j >= 1 && A[j] < A[j - 1]) {
                swap(A, j, j - 1);
                j--;
            }
        }
    }

    /* Put the min number to the front. */
    public static void selectionSort(int[] A) {
        if (A == null || A.length == 0) return;
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i; j < A.length; j++)
                if (A[j] < A[minIndex]) minIndex = j;
            swap(A, i, minIndex);
        }
    }

    /* Swap pairs until all numbers sorted. */
    public static void bubbleSort(int[] A) {
        if (A == null || A.length == 0) return;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    private static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
