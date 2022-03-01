package structures;

/**
 * A {@link BinaryTreeNode} represents a node in a binary tree. It is guaranteed
 * to store some data (cannot hold null) and may have a left child and a right child.
 *  
 * @author jcollard jddevaug
 * @see http://en.wikipedia.org/wiki/Binary_tree
 * @param <T> they type of data stored in this {@link BinaryTreeNode}
 */
public interface BinaryTreeNode<T> {

	/**
	 * Returns the data stored in this {@link BinaryTreeNode}
	 * @return the data stored in this {@link BinaryTreeNode}
	 */
	public T getData();
	
	/**
	 * Sets the data in this {@link BinaryTreeNode}.
	 * @param data the data to set
	 * @throws NullPointerException if {@code data} is {@code null}
	 */
	public void setData(T data);
	
	/**
	 * Returns {@code true} if this {@link BinaryTreeNode} has a left child and {@code false} otherwise
	 * @return {@code true} if this {@link BinaryTreeNode} has a left child and {@code false} otherwise
	 */
	public boolean hasLeftChild();
	
	
	/**
	 * Returns {@code true} if this {@link BinaryTreeNode} has a right child and {@code false} otherwise.
	 * @return {@code true} if this {@link BinaryTreeNode} has a right child and {@code false} otherwise.
	 */
	public boolean hasRightChild();
	
	/**
	 * Returns the left child of this {@link BinaryTreeNode}.
	 * @return the left child of this {@link BinaryTreeNode}.
	 * @throws {@code IllegalStateException} if there is no left child
	 * 
	 */
	public BinaryTreeNode<T> getLeftChild();
	
	/**
	 * Returns the right child of this {@link BinaryTreeNode}.
	 * @return the right child of this {@link BinaryTreeNode}
	 * @throws {@code IllegalStateException} if there is no right child
	 */
	public BinaryTreeNode<T> getRightChild();
	
	/**
	 * Sets the left child of this {@link BinaryTreeNode}. If {@code left}
	 * is {@code null} then this {@link BinaryTreeNode} will have no child.
	 * 
	 */
	public void setLeftChild(BinaryTreeNode<T> left);
	
	/**
	 * Sets the right child of this {@link BinaryTreeNode}. If {@code right}
	 * is {@code null} then this {@link BinaryTreeNode} will have no child.
	 * 
	 */
	public void setRightChild(BinaryTreeNode<T> right);
	
}
