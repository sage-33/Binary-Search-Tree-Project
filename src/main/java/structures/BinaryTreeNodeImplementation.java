package structures;

/**
 * BinaryTreeNode represents a node in a binary tree with a left and right
 * child.
 * 
 * @author sagesilberman
 *
 * @param <T> a node
 */
public class BinaryTreeNodeImplementation<T> implements BinaryTreeNode<T> {

	private BinaryTreeNode<T> left; // the left element in a tree
	private BinaryTreeNode<T> right; // the right element in a tree
	private T data; // the data in a tree

	/**
	 * 
	 * Creates a new tree node with the specified data.
	 * 
	 * @param left  the left most element that will become a part of the new tree
	 *              node
	 * @param elem  the element that will become a part of the new tree node
	 * @param right the left most element that will become a part of the new tree
	 *              node
	 */
	public BinaryTreeNodeImplementation(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right) {
		this.left = left; // required to use "this" if both variable names are the same
		this.right = right;
		this.data = elem; // not required to use "this" but consistency
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T data) {
		if (data == null) {
			throw new NullPointerException("data is null");
		}
		this.data = data;
	}

	@Override
	public boolean hasLeftChild() {
		return left != null;
	}

	@Override
	public boolean hasRightChild() {
		return right != null;
	}

	@Override
	public BinaryTreeNode<T> getLeftChild() {
		if (left == null) {
			throw new IllegalStateException("there is no left child");
		}
		return left;
	}

	@Override
	public BinaryTreeNode<T> getRightChild() {
		if (right == null) {
			throw new IllegalStateException("there is no right child");
		}
		return right;
	}

	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		if (left != null) {
			this.left = left;
		}
	}

	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		if (right != null) {
			this.right = right;
		}
	}

}
