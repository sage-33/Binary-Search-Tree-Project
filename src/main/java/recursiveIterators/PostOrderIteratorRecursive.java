package recursiveIterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import structures.BinaryTreeNode;

public class PostOrderIteratorRecursive<T> implements Iterator<T> {
	private final Queue<BinaryTreeNode<T>> queue;

	public PostOrderIteratorRecursive(BinaryTreeNode<T> root) {
		queue = new LinkedList<BinaryTreeNode<T>>();
		addNext(root);
	}

	private void addNext(BinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		// visit node
		if (!node.hasLeftChild() && !node.hasRightChild()) {
			queue.add(node);
		} else if (node.hasLeftChild() && node.hasRightChild()) {
			addNext(node.getLeftChild());
			addNext(node.getRightChild());
			queue.add(node);
		} else if (node.hasLeftChild()) {
			addNext(node.getLeftChild());
			queue.add(node);
		} else if (node.hasRightChild()) {
			addNext(node.getRightChild());
			queue.add(node);
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