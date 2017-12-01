package MyDeque;

public class LinkedListDeque<E> implements MyDeque<E> {

    /* Private static nested class. */
    private static class ListNode<E> {
        E data;
        ListNode next;
        ListNode prev;

        ListNode() { new ListNode(null, null, null); }
        ListNode(E data) { new ListNode(data, null, null); }

        ListNode(E data, ListNode next, ListNode prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNode sentinel;
    private int size;

    /* Constructs a new LinkedListDeque. */
    LinkedListDeque() {
        sentinel = new ListNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(E item) {
        size++;
        sentinel.next = new ListNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
    }

    @Override
    public void addLast(E item) {
        size++;
        sentinel.prev = new ListNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (ListNode curr = sentinel.next; curr != sentinel; curr = curr.next) {
            System.out.print(curr.data);
            if (curr.next != sentinel) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        size--;
        ListNode curr = sentinel.next;
        sentinel.next = curr.next;
        curr.next.prev = sentinel;
        return (E) curr.data;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        size--;
        ListNode curr = sentinel.prev;
        sentinel.prev = curr.prev;
        curr.prev.next = sentinel;
        return (E) curr.data;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        return getRecursion(index, sentinel.next);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public E getRecursion(int index, ListNode root) {
        if (index == 0) return (E) root.data;
        return getRecursion(index - 1, root.next);
    }

    public E getIteration(int index) {
        ListNode curr = sentinel;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return (E) curr.data;
    }
}

