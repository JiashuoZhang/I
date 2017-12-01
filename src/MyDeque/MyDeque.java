package MyDeque;

/*  MyDeque interface contains behaviors that LinkedListDeque and ArrayDeque implement.
 *  Author: Jiashuo Zhang
 *  Dec 1, 2017
 */

/*  An interface is implicitly abstract. Each method is implicitly abstract and public.
 *  An interface does not contain any constructors.
 *  An interface cannot contain instance fields.
 *  Fields that appear should be declared both static and final.
 *  An interface can extend multiple interfaces.
 */

public interface MyDeque<E> {

    /* Adds an item to the front of the Deque. */
    void addFirst(E item);

    /* Adds an item to the back of the Deque. */
    void addLast(E item);

    /* Returns true if deque is empty, false otherwise. */
    boolean isEmpty();

    /* Returns the number of items in the Deque. */
    int size();

    /* Prints the items in the Deque from first to last, separated by a space. */
    void printDeque();

    /* Removes and returns the item at the front of the Deque. If no such item exists, returns null. */
    E removeFirst();

    /* Removes and returns the item at the back of the Deque. If no such item exists, returns null. */
    E removeLast();

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null.*/
    E get(int index);

}
