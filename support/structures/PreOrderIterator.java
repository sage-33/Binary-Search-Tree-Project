package structures;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class PreOrderIterator<T> implements Iterator<T> {
	
	private final Deque<BinaryTreeNode<T>> stack; 
	
	public PreOrderIterator(BinaryTreeNode<T> root){
		stack = new LinkedList<BinaryTreeNode<T>>();
		stack.push(root);
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public T next() {
		BinaryTreeNode<T> toVisit = stack.pop();
		if(toVisit.hasRightChild()) stack.push(toVisit.getRightChild());
		if(toVisit.hasLeftChild()) stack.push(toVisit.getLeftChild());
		return toVisit.getData();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
