public class SortingTester {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};
        Sorting1.bubbleSort(A);
        System.out.println("Bubble sorting ==> Is sorted? " + isSorted(A));

        int[] B = {3, 2, 1, 4, 5};
        Sorting1.selectionSort(B);
        System.out.println("Selection sorting ==> Is sorted? " + isSorted(B));

        int[] C = {3, 2, 1, 4, 5};
        Sorting1.insertionSort(C);
        System.out.println("Insertion sorting ==> Is sorted? " + isSorted(C));

        int[] D = {3, 2, 1, 4, 5};
        Sorting2.heapSort(D);
        System.out.println("Heap sorting ==> Is sorted? " + isSorted(D));

        int[] E = {3, 2, 1, 4, 5};
        Sorting2.mergeSort(E);
        System.out.println("Merge sorting ==> Is sorted? " + isSorted(E));

        int[] F = {3, 2, 1, 4, 5};
        Sorting2.quickSort(F);
        System.out.println("Quick sorting ==> Is sorted? " + isSorted(F));
    }

    public static boolean isSorted(int[] A) {
        for (int i = 0; i < A.length - 1; i++)
            if (A[i] > A[i + 1]) return false;
        return true;
    }
}
