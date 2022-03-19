package nonRecursiveIterators;

import java.util.Iterator;
import java.util.LinkedList;

import structures.BinaryTreeNode;

/**
 * Represents the traversal of elements contained in a binary tree where the
 * order is determined b the level of elements
 * 
 * @author sagesilberman
 *
 * @param <T> a node
 */
public class LevelOrderIterator<T> implements Iterator<T> {

	private final LinkedList<BinaryTreeNode<T>> stack; // a new linked list

	/**
	 * Constructs a new linked list
	 * 
	 * 
	 * @param root the first node in the stack
	 */
	public LevelOrderIterator(BinaryTreeNode<T> root) {
		stack = new LinkedList<BinaryTreeNode<T>>();
		stack.add(root);
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();

	}

	@Override
	public T next() {
		return nextNode().getData();
	}

	/**
	 * Returns the node thats being popped off the stack
	 * 
	 * @return the popped node
	 */
	public BinaryTreeNode<T> nextNode() {
		BinaryTreeNode<T> poppedNode = stack.pop();

		if (poppedNode.hasLeftChild()) {
			stack.add(poppedNode.getLeftChild());
		}

		if (poppedNode.hasRightChild()) {
			stack.add(poppedNode.getRightChild());
		}

		return poppedNode;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}