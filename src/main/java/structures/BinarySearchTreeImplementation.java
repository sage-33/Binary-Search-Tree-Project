package structures;

import java.util.Iterator;

import recursiveIterators.InOrderIteratorRecursive;

/**
 * Represents a Binary Search Tree structure
 * 
 * @author sagesilberman
 *
 * @param <T> a node
 */
public class BinarySearchTreeImplementation<T extends Comparable<? super T>> implements BinarySearchTree<T> {

	private BinaryTreeNode<T> root; // The root of the tree
	private int count; // the count

	/**
	 * Constructs the root and count of the tree
	 */
	public BinarySearchTreeImplementation() {
		root = null;
		count = 0;
	}

	@Override
	public BinarySearchTree<T> add(T toAdd) {
		if (toAdd == null) {
			throw new NullPointerException("Cannot add a null element");
		}
		// create a binary tree node
		BinaryTreeNode<T> nodeToAdd = new BinaryTreeNodeImplementation<T>(null, toAdd, null);
		if (isEmpty()) {
			System.out.println("Root added:" + nodeToAdd.getData());
			root = nodeToAdd;
			count++;
			return this;
		} else {
			if (nodeToAdd.getData().compareTo(root.getData()) <= 0) {
				if (!root.hasLeftChild()) {
					root.setLeftChild(nodeToAdd);
				} else {
					addElement(nodeToAdd.getData(), root.getLeftChild());
				}
			} else {
				if (!root.hasRightChild()) {
					System.out.println("adding " + nodeToAdd.getData());
					root.setRightChild(nodeToAdd);
				} else {
					addElement(nodeToAdd.getData(), root.getRightChild());
				}
			}
			count++;
		}
		return this;
	}

	/**
	 * @param element
	 * @param node
	 */
	private void addElement(T element, BinaryTreeNode<T> node) {
		if (element.compareTo(node.getData()) <= 0) {
			if (!node.hasLeftChild()) {
				node.setLeftChild(new BinaryTreeNodeImplementation<T>(null, element, null));
			} else {
				addElement(element, node.getLeftChild());
			}
		} else {
			if (!node.hasRightChild()) {
				node.setRightChild(new BinaryTreeNodeImplementation<T>(null, element, null));
			} else {
				addElement(element, node.getRightChild());
			}
		}
	}

	@Override
	public boolean contains(T toFind) {
		if (toFind == null) {
			throw new NullPointerException("Cannot search for a null element");
		}
		for (T el : this) {
			if (el.equals(toFind)) {
				return true;
			}

		}
		return false;
	}

	@Override
	public boolean remove(T toRemove) {
		T result = null;

		if (!contains(toRemove)) {
			System.out.println("Does not contain " + toRemove);
			return false;
		}

		if (isEmpty()) {
			return false;
		} else {
			// toRemove is the root
			BinaryTreeNode<T> parent = null;

			if (toRemove.equals(root.getData())) {
				System.out.println("Removing root: " + root.getData());
				result = root.getData();
				BinaryTreeNode<T> temp = replacement(root);
				if (temp == null) {
					root = null;
				} else {
					root.setData(temp.getData());
					if (temp.hasRightChild()) {
						root.setRightChild(temp.getRightChild());
					} else {
						root.setRightChild(null);
					}
					if (temp.hasLeftChild()) {
						root.setLeftChild(temp.getLeftChild());
					} else {
						root.setLeftChild(null);
					}
				}
				count--;
				return true;
			} else {
				// go find the node
				parent = root;
				System.out.println("root is " + root.getData());
				if (toRemove.compareTo(root.getData()) <= 0) {
					if (root.hasLeftChild()) {
						result = removeElement(toRemove, root.getLeftChild(), parent);
					}
				} else {
					if (root.hasRightChild()) {
						result = removeElement(toRemove, root.getRightChild(), parent);
					}
				}
			}
		}
//	if (result == null) {
//	return false;
//	}
		return true;
	}

	/**
	 * @param toRemove
	 * @param node
	 * @param parent
	 * @return
	 */
	private T removeElement(T toRemove, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) {
		T result = null;

		if (toRemove.equals(node.getData())) {
			result = node.getData();
			BinaryTreeNode<T> temp = replacement(node);
			if (parent.hasRightChild() && parent.getRightChild() == node) {
				parent.setRightChild(temp);
			} else {
				parent.setLeftChild(temp);
			}
			count--;
		} else {
			parent = node;
			if (toRemove.compareTo(node.getData()) <= 0) {
				if (node.hasLeftChild()) {
					result = removeElement(toRemove, node.getLeftChild(), parent);
				}
			} else {
				if (node.hasRightChild()) {
					result = removeElement(toRemove, node.getRightChild(), parent);
				}
			}
		}
		return result;
	}

	/**
	 * @param node
	 * @return
	 */
	private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
		if (!node.hasLeftChild() && !node.hasRightChild()) {
			return null;
		} else if (node.hasLeftChild() && !node.hasRightChild()) {
			return node.getLeftChild();
		} else if (!node.hasLeftChild() && node.hasRightChild()) {
			return node.getRightChild();
		} else { // node has left and right child
			BinaryTreeNode<T> current = node.getRightChild();
			BinaryTreeNode<T> parent = node;

			while (current.hasLeftChild()) {
				parent = current;
				current = current.getLeftChild();
			}
			current.setLeftChild(node.getLeftChild());

			BinaryTreeNode<T> rightChild = null;
			if (current.hasRightChild()) {
				rightChild = current.getRightChild();
			}

			if (node.getRightChild() != current) {
				parent.setLeftChild(rightChild);
				current.setRightChild(node.getRightChild());
			}
			return current;
		}
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		if (size() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public T getMinimum() {
		return getMinimum(root);
	}

	/**
	 * @param currentNode
	 * @return
	 */
	private T getMinimum(BinaryTreeNode<T> currentNode) {
		if (isEmpty()) {
			throw new IllegalStateException("Tree is empty");
		}
		if (!currentNode.hasLeftChild()) {
			return currentNode.getData();
		}
		return getMinimum(currentNode.getLeftChild());

	}

	@Override
	public T getMaximum() {
		return getMaximum(root);
	}

	/**
	 * @param currentNode
	 * @return
	 */
	private T getMaximum(BinaryTreeNode<T> currentNode) {
		if (isEmpty()) {
			throw new IllegalStateException("Tree is empty");
		}
		if (!currentNode.hasRightChild()) {
			return currentNode.getData();
		}
		return getMaximum(currentNode.getRightChild());
	}

	@Override
	public BinaryTreeNode<T> toBinaryTreeNode() {
		return root;
	}

	@Override
	public Iterator<T> iterator() {
		return new InOrderIteratorRecursive<T>(root);
	}
}
