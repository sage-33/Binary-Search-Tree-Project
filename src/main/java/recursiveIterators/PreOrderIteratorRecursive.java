package recursiveIterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import structures.BinaryTreeNode;

/**
 * Represents the recursive traversal of elements contained in a binary tree by
 * which the order is the root, left, and right.
 * 
 * @author sagesilberman
 * 
 * @param <T> a node
 */
public class PreOrderIteratorRecursive<T> implements Iterator<T> {

	private final Queue<BinaryTreeNode<T>> queue; // a new Binary queue

	/**
	 * Constructs a new linked list
	 * 
	 * @param root the first most element in the cue that is passed in
	 */
	public PreOrderIteratorRecursive(BinaryTreeNode<T> root) {
		queue = new LinkedList<BinaryTreeNode<T>>();
		addNext(root);
	}

	/**
	 * Check to see if there is a left child, visit the left child if there is one,
	 * and then check for a right child
	 * 
	 * @param node for the node we are returning
	 */
	private void addNext(BinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		// visit node (means add to queue)
		queue.add(node);
		if (node.hasLeftChild()) {
			addNext(node.getLeftChild());
		}
		if (node.hasRightChild()) {
			addNext(node.getRightChild());
		}
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public T next() {
		return queue.remove().getData();
	}

}
