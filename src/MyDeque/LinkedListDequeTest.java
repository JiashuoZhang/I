package MyDeque;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    /* Utility method for compare two ints. */
    public static boolean checkGet(int expected, int actual) {
        if (expected != actual) {
            System.out.println("get() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void getTest() {
        System.out.println("Running add/remove/get test.");

        MyDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        passed = checkSize(0, lld1.size()) && passed;

        lld1.addFirst(0);
        lld1.addLast(1);
        lld1.addLast(2);
        passed = checkSize(3, lld1.size()) && passed;

        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addLast(10);
        lld1.addLast(11);
        Integer deletedInt = lld1.removeLast();
        passed = checkGet(11, deletedInt) && passed;
        passed = checkGet(1, lld1.get(1)) && passed;
        passed = checkGet(10, lld1.get(5)) && passed;

        lld1.printDeque();

        printTestStatus(passed);
    }

    public static void getIerationTest() {
        System.out.println("Running getRecursive test.");
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        boolean passed = checkEmpty(true, lld1.isEmpty());
        passed = lld1.get(0) == null && passed;
        lld1.addLast(0);
        lld1.addLast(1);
        lld1.addLast(2);
        passed = checkGet(2, lld1.get(2)) && passed;

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        getTest();
        getIerationTest();
    }
}