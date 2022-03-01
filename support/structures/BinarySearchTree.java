package structures;

import java.util.Iterator;

/**
 * <p>
 * A {@link BinarySearchTree} is a container that maintains an internal state
 * consistent with a Binary Search Tree.
 * </p>
 * 
 * 
 * @author jcollard jddevaug
 * @see http://en.wikipedia.org/wiki/Binary_search_tree
 * @see http://en.wikipedia.org/wiki/Tree_traversal#In-order_.28symmetric.29
 * 
 * @param <T>
 *            the type of data stored in this {@link BinarySearchTree}
 */
public interface BinarySearchTree<T extends Comparable<? super T>> extends
		Iterable<T> {

	/**
	 * Adds {@code toAdd} to this {@link BinarySearchTree}. For convenience,
	 * this method returns the modified {@link BinarySearchTree}. This method
	 * runs in O(size) time. However, if this {@link BinarySearchTree} is
	 * balanced, this method runs in O(log(size)) time.
	 * 
	 * A successful call to this method will always result in size increasing by
	 * one.
	 * 
	 * @param toAdd
	 *            the element to add to this {@link BinarySearchTree}
	 * @return For convenience, this method returns the modified
	 *         {@link BinarySearchTree}.
	 * @throws NullPointerException
	 *             if {@code toAdd} is {@code null}
	 */
	public BinarySearchTree<T> add(T toAdd);

/**
	 * Searches this {@link BinarySearchTree} for {@code toFind} and returns
	 * {@code true} if there is at least one instance of {@code toFind} in this
	 * {@link BinarySearchTree} and {@code false} otherwise.  This method
	 * runs in O(size) time. However, if this {@link BinarySearchTree} is balanced,
	 * this method runs in O(log(size)) time.
	 * 
	 * @param toFind
	 *            the element to search for
	 * @return {@code true} if there is an instance of {@code toFind} in this
	 *         {@link BinarySearchTree} and {@code false otherwise.
	 * @throws NullPointerException if {@code toFind} is {@code null}
	 */
	public boolean contains(T toFind);

	/**
	 * Removes {@code toRemove} from this {@link BinarySearchTree} if at least
	 * one element is considered comparably equivalent (compareTo(toRemove) ==
	 * 0). Returns {@code true} if this {@link BinarySearchTree} was modified
	 * and {@code false} otherwise. This method runs in O(size) time. However,
	 * if this {@link BinarySearchTree} is balanced, this method runs in
	 * O(log(size)) time.
	 * 
	 * @param toRemove
	 *            the element to be removed
	 * @return {@code true} if this {@link BinarySearchTree} was modified and
	 *         {@code false} otherwise
	 */
	public boolean remove(T toRemove);

	/**
	 * Returns the number of elements in this {@link BinarySearchTree}
	 * 
	 * @return the number of elements in this {@link BinarySearchTree}
	 */
	public int size();

	/**
	 * Returns {@code true} if this {@link BinarySearchTree} contains no
	 * elements and {@code false} otherwise.
	 * 
	 * @return {@code true} if this {@link BinarySearchTree} contains no
	 *         elements and {@code false} otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Returns the minimum value in this {@link BinarySearchTree}.
	 * 
	 * @return the minimum value in this {@link BinarySearchTree}.
	 * @throws IllegalStateException
	 *             if this {@link BinarySearchTree} is empty.
	 */
	public T getMinimum();

	/**
	 * Returns the maximum value in this {@link BinarySearchTree}.
	 * 
	 * @return the maximum value in this {@link BinarySearchTree}.
	 * @throws IllegalStateException
	 *             if this {@link BinarySearchTree} is empty.
	 */
	public T getMaximum();

	/**
	 * Returns a {@link BinaryTreeNode} that is consistent with the internal
	 * shape of this {@link BinarySearchTree}. If changes to the this {@link BinarySearchTree}
	 * are made after a call to this method, using the returned {@link BinaryTreeNode} is
	 * undefined.
	 * 
	 * @return a {@link BinaryTreeNode} that is consistent with the shape of
	 *         this {@link BinarySearchTree}.
	 * 
	 * @throws IllegalStateException
	 *             if this {@link BinarySearchTree} is empty.
	 */
	public BinaryTreeNode<T> toBinaryTreeNode();

	/**
	 * <p>
	 * Returns a new {@link Iterator} that will traverse this tree in-order.
	 * </p>
	 * <p>
	 * The remove method of the returned {@link Iterator} is not supported and
	 * any call to it will result in an {@link UnsupportedOperationException}.
	 * </p>
	 * <p>
	 * This method is guaranteed to return in O(1) time. That is, it should not
	 * compute the entire order of traversal ahead of time.
	 * </p>
	 * <p>
	 * If the data in the underlying {@link BinaryTreeNode} or its children is
	 * modified, using the {@link Iterator} is unknown.
	 * </p>
	 * 
	 * @return a new {@link Iterator} that will traverse this tree in-order.
	 */
	public Iterator<T> iterator();

}
