package config;

import structures.BinarySearchTree;
import structures.BinarySearchTreeImplementation;
import structures.BinaryTreeNode;
import structures.BinaryTreeNodeImplementation;
import structures.BinaryTreeUtility;
import structures.BinaryTreeUtilityImplementation;

/**
 * This class acts as a configuration file which tells the testing framework
 * which implementation you want us to use when we grade your assignment.
 * 
 * @author jcollard jddevaug
 * 
 */
public class Configuration {

	public static final String STUDENT_ID_NUMBER = "12345678";

	public static <T> BinaryTreeNode<T> createBinaryTreeNode(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right) {
		return new BinaryTreeNodeImplementation<T>(left, elem, right);
	}

	public static BinaryTreeUtility createBinaryTreeUtility() {
		return new BinaryTreeUtilityImplementation();
	}

	public static <T extends Comparable<? super T>> BinarySearchTree<T> createBinarySearchTree() {
		return new BinarySearchTreeImplementation<T>();
	}

}
