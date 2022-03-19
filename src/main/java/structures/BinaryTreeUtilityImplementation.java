package structures;

import java.util.Iterator;

import nonRecursiveIterators.InOrderIterator;
import nonRecursiveIterators.LevelOrderIterator;
import nonRecursiveIterators.PostOrderIterator;
import nonRecursiveIterators.PreOrderIterator;
import recursiveIterators.PreOrderIteratorRecursive;

/**
 * BinaryTreeUtility represents the basic functions for working with a Binary
 * Tree.
 * 
 * @author sagesilberman
 * 
 */
public class BinaryTreeUtilityImplementation implements BinaryTreeUtility {

	@Override
	public <T> Iterator<T> getPreOrderIterator(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new NullPointerException("Root is null");
		}

		return new PreOrderIteratorRecursive<T>(root);
	}

	@Override
	public <T> Iterator<T> getInOrderIterator(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new NullPointerException("root is null");
		}
		return new InOrderIterator<T>(root);
	}

	@Override
	public <T> Iterator<T> getPostOrderIterator(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new NullPointerException("root is null");
		}
		return new PostOrderIterator<T>(root);
	}

	@Override
	public <T> Iterator<T> getLevelOrderIterator(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new NullPointerException("Root cannot be null");
		}

		return new LevelOrderIterator<T>(root);
	}

	@Override
	public <T> int getDepth(BinaryTreeNode<T> root) {
		// 1 + the depth of my deepest child
		if (root == null) {
			throw new NullPointerException("Trying to find if a null BinaryTree is balanced");
		}
		if (!(root.hasLeftChild() || root.hasRightChild())) {
			return 0;
		}
		int leftDepth = root.hasLeftChild() ? getDepth(root.getLeftChild()) : -1;
		int rightDepth = root.hasRightChild() ? getDepth(root.getRightChild()) : -1;

		int deepestChild = Math.max(leftDepth, rightDepth);
		return deepestChild + 1;
	}

	@Override
	public <T> boolean isBalanced(BinaryTreeNode<T> root, int tolerance) {
		if (root == null) {
			throw new NullPointerException("Trying to find if a null BinaryTree is balanced");
		}
		if (tolerance < 0) {
			throw new IllegalArgumentException("Tolerance cannot be less than 0");
		}

		int leftDepth, rightDepth;
		if (!root.hasLeftChild()) {
			leftDepth = -1;
		} else {
			leftDepth = getDepth(root.getLeftChild());
		}

		if (!root.hasRightChild()) {
			rightDepth = -1;
		} else {
			rightDepth = getDepth(root.getRightChild());
		}
		int diff = Math.abs(leftDepth - rightDepth);

		if (diff > tolerance) {
			return false;
		}
		// similar to isBST
		boolean isLeftBalanced = true;
		boolean isRightBalanced = true;

		// go left
		if (root.hasLeftChild()) {
			isLeftBalanced = isBalanced(root.getLeftChild(), tolerance);
		}
		// go right
		if (root.hasRightChild()) {
			isRightBalanced = isBalanced(root.getRightChild(), tolerance);
		}
		return isLeftBalanced && isRightBalanced;

	}

	@Override
	public <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T> root) {
		if (root == null) {
			throw new NullPointerException();
		}
		return isBST(root, null, null);
	}

	/**
	 * Returns <code>true</code> if it's a single binary tree node
	 * 
	 * @param <T>     a node
	 * @param current the current node
	 * @param max     the maximum value
	 * @param min     the minimum value
	 * @return the left and right binary search trees
	 * 
	 * @return <code>true</code> if its a single binary tree <code>false</code>
	 *         otherwise, return <code>false</code>
	 */

	private <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T> current, T max, T min) {
		// check if there is a root
		if (current == null) {
			throw new NullPointerException("Trying to find if a null BinaryTree is a BinaryTree");
		}

		boolean isLeftBST = true;
		boolean isRightBST = true;

		// make sure current is valid (if it's not valid, return false)
		if ((max != null && current.getData().compareTo(max) >= 0)
				|| (min != null && current.getData().compareTo(min) < 0)) {
			return false;
		}

		// if its a single BTN
		if (!current.hasLeftChild() && !current.hasRightChild()) {
			return true;
		}

		// go left
		if (current.hasLeftChild()) {
			isLeftBST = isBST(current.getLeftChild(), current.getData(), min);

		}
		// go right
		if (current.hasRightChild()) {
			isRightBST = isBST(current.getRightChild(), max, current.getData());

		}
		return isLeftBST && isRightBST;
	}

}
