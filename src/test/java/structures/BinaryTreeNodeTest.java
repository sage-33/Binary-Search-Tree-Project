package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import config.Configuration;

public class BinaryTreeNodeTest {

	private BinaryTreeNode<Integer> root, root2, root3;
	private static final <T> BinaryTreeNode<T> node(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right){
		return Configuration.createBinaryTreeNode(left, elem, right);
	}
	
	@Before
	public void setUp() throws Exception {
		root = initRoot();
		root2 = initRoot2();
		root3 = initRoot3();
		assertNotNull("It looks like your configuration file isn't set for BinaryTreeNode.", root);
		assertNotNull("It looks like your configuration fil isn't set for BinaryTreeNode.", root2);
		assertNotNull("It looks like your configuration file isn't set for BinaryTreeNode.", root3);
	}

	private BinaryTreeNode<Integer> initRoot(){
		return node(null, 5, null);
	}
	
	private BinaryTreeNode<Integer> initRoot2(){
		//       5
		//        \
		//         7
		return node(null, 5, node(null, 7, null));
	}
	
	private BinaryTreeNode<Integer> initRoot3(){
		//                    5
		//              /            \
		//             3             19
		//            / \           /
		//           6   7         1
		//                        /
		//                       4
		return 
		node(
			node(
				node(null, 6, null), 3, node(null, 7, null)),
			5,
			node(
				node(
					node(null, 4, null), 1, null), 19, null));
	}
	
	@Test (timeout = 100)
	public void testRoot() {
		assertEquals("Root should have a single node with 5 stored.", new Integer(5), root.getData());
		assertFalse("Root should have no children.", root.hasLeftChild());
		assertFalse("Root should have no children.", root.hasRightChild());
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRootException1() {
		root.getLeftChild();
	}

	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRootException2() {
		root.getRightChild();
	}
	
	@Test (timeout = 100)
	public void testRoot2() {
		assertEquals("The root of root2 should hold 5.", new Integer(5), root2.getData());
		assertFalse("Root 2 should have only a right child.", root2.hasLeftChild());
		assertTrue("Root 2 should have a right child.", root2.hasRightChild());
		assertEquals("The right child of root2 should hold 7.", new Integer(7), root2.getRightChild().getData());
		assertFalse("The right child of root2 should have no children.", root2.getRightChild().hasRightChild());
		assertFalse("The left child of root2 should have no children.", root2.getRightChild().hasLeftChild());
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot2Exception1(){
		root2.getLeftChild();
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot2Exception2(){
		root2.getRightChild().getLeftChild();
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot2Exception3(){
		root2.getRightChild().getRightChild();
	}
	
	@Test (timeout = 100)
	public void testRoot3() {
		//                    5
		//              /            \
		//             3             19
		//            / \           /
		//           6   7         1
		//                        /
		//                       4
		assertEquals("The root of root3 should hold 5.", new Integer(5), root3.getData());
		assertEquals("The left child of root3 should hold 3.", new Integer(3), root3.getLeftChild().getData());
		assertEquals("The left-left child of root3 should hold 6.", new Integer(6), root3.getLeftChild().getLeftChild().getData());
		assertEquals("The left-right child of root3 should hold 7.", new Integer(7), root3.getLeftChild().getRightChild().getData());
		assertEquals("The right child of root3 should hold 19.", new Integer(19), root3.getRightChild().getData());
		assertEquals("The right-left child of root3 should hold 1.", new Integer(1), root3.getRightChild().getLeftChild().getData());
		assertEquals("The right-left-left child of root3 should hold 4.", new Integer(4), root3.getRightChild().getLeftChild().getLeftChild().getData());		
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot3Exception1(){
		assertFalse(root3.getLeftChild().getLeftChild().hasLeftChild());
		root3.getLeftChild().getLeftChild().getLeftChild();
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot3Exception2(){
		assertFalse(root3.getLeftChild().getLeftChild().hasRightChild());
		root3.getLeftChild().getRightChild().getRightChild();
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot3Exception3(){
		assertFalse(root3.getRightChild().hasRightChild());
		root3.getRightChild().getRightChild();
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot3Exception4(){
		assertFalse(root3.getRightChild().getLeftChild().hasRightChild());
		root3.getRightChild().getLeftChild().getRightChild();
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot3Exception5(){
		assertFalse(root3.getRightChild().getLeftChild().getLeftChild().hasLeftChild());
		root3.getRightChild().getLeftChild().getLeftChild().getLeftChild();
	}
	
	@Test (timeout = 100, expected=IllegalStateException.class)
	public void testRoot3Exception6(){
		assertFalse(root3.getRightChild().getLeftChild().getLeftChild().hasRightChild());
		root3.getRightChild().getLeftChild().getLeftChild().getRightChild();
	}
}
