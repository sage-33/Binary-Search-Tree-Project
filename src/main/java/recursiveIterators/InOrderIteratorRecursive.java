package recursiveIterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import structures.BinaryTreeNode;

public class InOrderIteratorRecursive<T> implements Iterator<T> {

	private Queue<BinaryTreeNode<T>> queue;

	public InOrderIteratorRecursive(BinaryTreeNode<T> root) {
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
		// "visit" node (means add to queue)

		if (node.hasLeftChild()) {
			addNext(node.getLeftChild());
		}
		queue.add(node);

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
