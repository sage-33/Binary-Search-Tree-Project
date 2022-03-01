package structures;

import java.util.LinkedList;
import java.util.Queue;

import config.Configuration;

public class TreeViewer {

	public static <T> String toDotFormat(BinaryTreeNode<T> root) {
		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		queue.add(root);
		BinaryTreeNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.hasLeftChild()) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getLeftChild().getData().toString() + ";\n";
				queue.add(cursor.getLeftChild());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}
			if (cursor.hasRightChild()) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getRightChild().getData().toString() + ";\n";
				queue.add(cursor.getRightChild());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}

	private static final <T> BinaryTreeNode<T> node(BinaryTreeNode<T> left,
			T elem, BinaryTreeNode<T> right) {
		return Configuration.createBinaryTreeNode(left, elem, right);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> tree = node(
				node(node(null, 6, null), 3, node(null, 7, null)), 5,
				node(node(node(null, 4, null), 1, null), 19, null));
		System.out.println(toDotFormat(tree));
	}

}
