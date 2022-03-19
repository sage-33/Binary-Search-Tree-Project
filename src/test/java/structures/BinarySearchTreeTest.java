package structures;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import config.Configuration;

public class BinarySearchTreeTest {

	private BinarySearchTree<Integer> tree;
	private static final int SPEED_TEST = 1 << 12;

	@Before
	public void setUp() throws Exception {
		tree = Configuration.createBinarySearchTree();
		assertNotNull("It looks like you did not set createBinarySearchTree in your configuration file.", tree);
	}

// Logic test for Add and is empty
	@Test(timeout = 100)
	public void testAddAndIsEmpty2() {
		assertTrue("Fresh tree should be empty.", tree.isEmpty());
		assertEquals("Fresh tree should have size 0.", 0, tree.size());
		assertEquals("Add should return tree for convenience.", tree, tree.add(100));
		assertFalse("Tree should now be non-empty.", tree.isEmpty());
		assertEquals("Size should now be 1.", 1, tree.size());
		assertEquals("Add should return tree for convenience.", tree, tree.add(50));
		assertFalse("Tree should now be non-empty.", tree.isEmpty());
		assertEquals("Size should now be 2.", 2, tree.size());
	}

	@Test(timeout = 100)
	public void testSimpleAddSizeAndIsEmpty() {
		assertTrue("Fresh tree should be empty.", tree.isEmpty());
		assertEquals("Fresh tree should have size 0.", 0, tree.size());
		assertEquals("Add should return tree for convenience.", tree, tree.add(1));
		assertFalse("Tree should now be non-empty.", tree.isEmpty());
		assertEquals("Size should now be 1.", 1, tree.size());
		assertEquals("Add should return tree for convenience.", tree, tree.add(1));
		assertFalse("Tree should now be non-empty.", tree.isEmpty());
		assertEquals("Size should now be 2.", 2, tree.size());
		assertEquals("Add should return tree for convenience.", tree, tree.add(1));
		assertFalse("Tree should now be non-empty.", tree.isEmpty());
		assertEquals("Size should now be 3.", 3, tree.size());
		assertEquals("Add should return tree for convenience.", tree, tree.add(2));
		assertFalse("Tree should now be non-empty.", tree.isEmpty());
		assertEquals("Size should now be 4.", 4, tree.size());
	}

// Test Contains and add again
	@Test(timeout = 100)
	public void testAddAndContains2() {
		assertFalse("Tree should not contain anything.", tree.contains(400));
		assertEquals("Add should return tree for convenience.", tree, tree.add(2));
		assertTrue("After add, contains should return true.", tree.contains(2));

		assertFalse("Tree should not contain 5.", tree.contains(5));
		assertEquals("Add should return tree for convenience.", tree, tree.add(77));
		System.out.println(tree.toBinaryTreeNode().getData());
		System.out.println(tree.toBinaryTreeNode().getRightChild().getData());
		assertTrue("After add, contains should return true.", tree.contains(77));
		assertEquals("Add should return tree for convenience.", tree, tree.add(500));
		assertTrue("After add, contains should return true.", tree.contains(500));

	}

	@Test(timeout = 100)
	public void testSimpleAddAndContains() {
		assertFalse("Tree should not contain anything.", tree.contains(1));
		assertEquals("Add should return tree for convenience.", tree, tree.add(1));
		assertTrue("After add, contains should return true.", tree.contains(1));

		assertFalse("Tree should not contain 5.", tree.contains(5));
		assertEquals("Add should return tree for convenience.", tree, tree.add(5));
		System.out.println(tree.toBinaryTreeNode().getData());
		System.out.println(tree.toBinaryTreeNode().getRightChild().getData());
		assertTrue("After add, contains should return true.", tree.contains(5));

	}

	@Test(timeout = 1000)
	public void testRandomAddContains() {
		Random r = new Random(42);
		Set<Integer> valuesAdded = new HashSet<Integer>();
		for (int i = 0; i < SPEED_TEST; i++) {
			assertEquals("Tree should have i elements in it.", i, tree.size());
			int next = r.nextInt();

			if (!valuesAdded.contains(next)) {
				assertFalse("Tree should not contain this value yet.", tree.contains(next));
				valuesAdded.add(next);
			}

			assertEquals("Add should return tree for convenience.", tree, tree.add(next));
			assertTrue("After add, contains should return true.", tree.contains(next));
		}
	}

// Logic for random add + contains. idk how to make this different tbh
	@Test(timeout = 1000)
	public void testRandomAddContains2() {
		Random r = new Random(69);
		Set<Integer> valuesAdded = new HashSet<Integer>();
		for (int i = 0; i < SPEED_TEST; i++) {
			assertEquals("Tree should have i elements in it.", i, tree.size());
			int next = r.nextInt();

			if (!valuesAdded.contains(next)) {
				assertFalse("Tree should not contain this value yet.", tree.contains(next));
				valuesAdded.add(next);
			}

			assertEquals("Add should return tree for convenience.", tree, tree.add(next));
			assertTrue("After add, contains should return true.", tree.contains(next));
		}
	}

	@Test(timeout = 100, expected = NullPointerException.class)
	public void testAddNullPointer() {
		tree.add(null);
	}

	@Test(timeout = 100, expected = NullPointerException.class)
	public void testContainsNullPointer() {
		tree.contains(null);
	}

// Logic test for remove method
	@Test(timeout = 100)
	public void testRemove() {
		assertEquals("Add should return tree for convenience", tree, tree.add(69));
		assertEquals("Add should return tree for convenience", tree, tree.add(420));
		assertEquals("Add should return tree for convenience", tree, tree.add(7));

		assertEquals(3, tree.size());
		assertTrue(tree.remove(69));
		assertEquals(2, tree.size());
		assertTrue(tree.remove(420));
		assertEquals(1, tree.size());
		assertFalse(tree.isEmpty());
	}

	@Test(timeout = 100)
	public void testSimpleAddRemoveAndSize() {
		assertEquals("Add should return tree for convenience.", tree, tree.add(1));
		assertEquals("Add should return tree for convenience.", tree, tree.add(5));
		assertEquals("Add should return tree for convenience.", tree, tree.add(5));
		assertEquals("Add should return tree for convenience.", tree, tree.add(5));

		assertEquals(4, tree.size());
		assertTrue(tree.remove(1));
		assertEquals(3, tree.size());
		assertFalse(tree.remove(1));
		assertEquals(3, tree.size());

		assertTrue(tree.remove(5));
		assertEquals(2, tree.size());
		assertTrue(tree.remove(5));
		assertEquals(1, tree.size());
		assertTrue(tree.remove(5));
		assertEquals(0, tree.size());
		assertFalse(tree.remove(5));
		assertTrue(tree.isEmpty());
	}

	@Test(timeout = 1000)
	public void testRandomAddRemoveAndSize() {
		Random r = new Random(42);
		List<Integer> valuesAdded = new LinkedList<Integer>();

		for (int i = 0; i < SPEED_TEST; i++) {
			assertEquals("Tree should have i elements in it.", i, tree.size());
			int next = r.nextInt(SPEED_TEST);
			valuesAdded.add(next);
			assertEquals("Add should return tree for convenience.", tree, tree.add(next));
			assertTrue("After add, contains should return true.", tree.contains(next));
		}
		System.out.println(valuesAdded);

		assertEquals(SPEED_TEST, tree.size());
		for (Integer i : valuesAdded) {
			assertTrue("Could not remove previously added node.", tree.remove(i));

		}
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
	}

	@Test(timeout = 1000)
	public void testDumbTest() {
// 0, 3, 8, 4, 0, 5, 5, 8, 9, 3]
		List<Integer> valuesAdded = new LinkedList<Integer>();
		valuesAdded.add(0);
		valuesAdded.add(3);
		valuesAdded.add(8);
		valuesAdded.add(4);
		valuesAdded.add(0);
		tree.add(0);
		tree.add(3);
		tree.add(8);
		tree.add(4);
		tree.add(0);

// assertEquals(SPEED_TEST, tree.size());
		for (Integer i : valuesAdded) {
			assertTrue("Could not remove previously added node.", tree.remove(i));

		}
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
	}

// Logic Test for getmin + max
	@Test(timeout = 100)
	public void testGetMinAndMax() {
		tree.add(69).add(420).add(7).add(15).add(4).add(5);
		assertEquals(new Integer(4), tree.getMinimum());
		assertEquals(new Integer(420), tree.getMaximum());
	}

	@Test(timeout = 100)
	public void testSize() {
		tree.add(1).add(2).add(3);
		assertEquals(3, tree.size());
	}

	@Test(timeout = 100)
	public void testSimpleGetMinAndGetMax() {
		tree.add(4).add(2).add(1).add(3).add(5).add(6).add(7);
		assertEquals(new Integer(1), tree.getMinimum());
		assertEquals(new Integer(7), tree.getMaximum());
	}

	@Test(timeout = 1000)
	public void testRandomGetMinAndGetMax() {
		Random r = new Random(42);
		LinkedList<Integer> values = new LinkedList<Integer>();
		int currentMin = Integer.MAX_VALUE;
		int currentMax = Integer.MIN_VALUE;
		for (int i = 0; i < SPEED_TEST; i++) {
			int next = r.nextInt();
			currentMin = Math.min(currentMin, next);
			currentMax = Math.max(currentMax, next);
			values.add(next);
			tree.add(next);
		}

		assertEquals(new Integer(currentMin), tree.getMinimum());
		assertEquals(new Integer(currentMax), tree.getMaximum());

	}

	@Test(timeout = 100, expected = IllegalStateException.class)
	public void testIllegalStateGetMin() {
		tree.getMinimum();
	}

	@Test(timeout = 100, expected = IllegalStateException.class)
	public void testIllegalStateGetMax() {
		tree.getMaximum();
	}

// logic Test for simple iterable
	@Test(timeout = 100)
	public void testSimpleIterable2() {
		tree.add(2).add(4).add(6).add(9).add(4).add(2).add(1);
		LinkedList<Integer> values = new LinkedList<Integer>();
		values.add(1);
		values.add(2);
		values.add(2);
		values.add(4);
		values.add(4);
		values.add(6);
		values.add(9);
		for (Integer i : tree) {
			Integer toCheck = values.remove();
			assertEquals(toCheck, i);
		}

	}

	@Test(timeout = 100)
	public void testSimpleIterable() {
		tree.add(4).add(2).add(1).add(3).add(5).add(6).add(7);
		LinkedList<Integer> values = new LinkedList<Integer>();
		values.add(1);
		values.add(2);
		values.add(3);
		values.add(4);
		values.add(5);
		values.add(6);
		values.add(7);
		for (Integer i : tree) {
			Integer toCheck = values.remove();
			assertEquals(toCheck, i);
		}

	}

	@Test(timeout = 1000)
	public void testRandomIterator() {
		Random r = new Random(42);
		LinkedList<Integer> values = new LinkedList<Integer>();

		for (int i = 0; i < SPEED_TEST; i++) {
			int next = r.nextInt();
			values.add(next);
			tree.add(next);
		}

		Collections.sort(values);

		for (Integer i : tree) {
			Integer toCheck = values.remove();
			assertEquals(toCheck, i);
		}

	}

}
