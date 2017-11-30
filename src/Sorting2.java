import java.util.Arrays;

public class Sorting2 {

    public static void heapSort(int[] A) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(A, 0, i);
            heapify(A, i, 0);
        }
    }

    private static void heapify(int[] A, int size, int index) {
        int largest = index;
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        if (l < size && A[l] > A[largest]) largest = l;
        if (r < size && A[r] > A[largest]) largest = r;
        if (largest != index) {
            swap(A, largest, index);
            heapify(A, size, largest);
        }
    }

    public static void mergeSort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    private static void mergeSort(int[] A, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(A, l, m);
            mergeSort(A, m + 1, r);
            merge(A, l, m, r);
        }
    }

    private static void merge(int[] A, int l, int m, int r) {
        int[] temp1 = new int[m - l + 1];
        int[] temp2 = new int[r - m];
        for (int i = 0; i < temp1.length; i++) temp1[i] = A[l + i];
        for (int i = 0; i < temp2.length; i++) temp2[i] = A[m + 1 + i];

        int p1 = 0, p2 = 0;
        for (int i = l; i <= r; i++) {
            if (p1 < temp1.length && p2 < temp2.length) {
                A[i] = temp1[p1] > temp2[p2] ? temp2[p2++] : temp1[p1++];
            } else if (p1 < temp1.length) {
                A[i] = temp1[p1++];
            } else if (p2 < temp2.length) {
                A[i] = temp2[p2++];
            }
        }
    }

    /* Pick a pivot, partition, and sort two parts. */
    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private static void quickSort(int[] A, int l, int h) {
        if (l < h) {
            int pi = partition(A, l, h);

            quickSort(A, l, pi - 1);
            quickSort(A, pi + 1, h);
        }
    }

    /* Pick the last element as the pivot. */
    private static int partition(int[] A, int l, int h) {
        int pivot = A[h];
        int i = l - 1;
        for (int j = l; j < h; j++)
            if (A[j] < pivot) swap(A, ++i, j);
        swap(A, ++i, h);
        return i;
    }

    private static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
