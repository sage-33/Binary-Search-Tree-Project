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
public class PostOrderIterator<T> implements Iterator<T> {

	private final LinkedList<BinaryTreeNode<T>> stack; // a new linked list

	/**
	 * Constructs a new linked list
	 * 
	 * @param root the first most node in the stack
	 */
	public PostOrderIterator(BinaryTreeNode<T> root) {
		stack = new LinkedList<BinaryTreeNode<T>>();

		makeStack(root);
	}

	/**
	 * Creates a stack that has a right and left child
	 * 
	 * @param root current node
	 */
	private void makeStack(BinaryTreeNode<T> root) {
		BinaryTreeNode<T> currentNode = root;
		while (true) {
			if (currentNode.hasRightChild()) {
				stack.push(currentNode.getRightChild());
			}

			stack.push(currentNode);

			if (!currentNode.hasLeftChild()) {
				return;
			}

			currentNode = currentNode.getLeftChild();
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
	 * @return the popped node
	 */
	public BinaryTreeNode<T> nextNode() {
		BinaryTreeNode<T> poppedNode = stack.pop();

		if (poppedNode.hasRightChild() && !stack.isEmpty() && stack.peek().equals(poppedNode.getRightChild())) {
			stack.pop();
			stack.push(poppedNode);

			if (poppedNode.hasRightChild()) {
				makeStack(poppedNode.getRightChild());
			}

			return nextNode();
		}

		return poppedNode;
	}
}