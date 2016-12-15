/**
 *
 */
package basic.ds.ll;

/**
 * A list or sequence is an abstract data type that implements an ordered
 * collection of values, where the same value may occur more than once.
 *
 * @author dandujaipalreddy@gmail.com
 */
public interface IMyList<T> {

    /*
     * Adds the Element to the list
     *
     * @param element to be added to the list
     *
     * @return True if element is added successfully to the list
     */
    boolean add(T element);

	/*
     * Removes the Element to the list
	 *
	 * @param element to be removed from the list
	 *
	 * @return True if element is removed successfully from the list
	 */

    boolean remove(T element);

	/*
	 * Clears the given list
	 */

    void clear();
	/*
	 * Does the list contain the given element
	 *
	 * @param element
	 *
	 * @return True if element is present in the list
	 */

    boolean contains(T element);
	/*
	 * Size of the list
	 *
	 * @return size of the list
	 */

    int size();

}
