package nonRecursiveIterators;

import java.util.Iterator;
import java.util.LinkedList;

import structures.BinaryTreeNode;

/**
 * Represents the traversal of elements contained in a binary tree by which the
 * order is the left, right, and right.
 * 
 * @author sagesilberman
 * 
 * @param <T> a node
 */
public class InOrderIterator<T> implements Iterator<T> {

	private final LinkedList<BinaryTreeNode<T>> stack; // a new linked list

	/**
	 * Constructs a new linked list
	 * 
	 * @param root the first most node in the stack
	 */
	public InOrderIterator(BinaryTreeNode<T> root) {
		stack = new LinkedList<BinaryTreeNode<T>>();
		makeStack(root);
	}

	/**
	 * Creates a stack that has a left child
	 * 
	 * @param root the current node
	 */
	private void makeStack(BinaryTreeNode<T> root) {
		stack.push(root);

		BinaryTreeNode<T> currentNode = root;
		while (currentNode.hasLeftChild()) {
			currentNode = currentNode.getLeftChild();
			stack.push(currentNode);
		}
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
	 * 
	 * @return the node that has been popped off the stack
	 */
	public BinaryTreeNode<T> nextNode() {
		BinaryTreeNode<T> poppedNode = stack.pop();

		if (poppedNode.hasRightChild()) {
			makeStack(poppedNode.getRightChild());
		}

		return poppedNode;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}