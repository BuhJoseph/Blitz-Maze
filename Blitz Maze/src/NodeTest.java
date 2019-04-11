import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.jupiter.api.Test;

class NodeTest {
	
	Node node1;
	Node node2;
	Node node3;
	
	@Test
	void test() {
		node1 = new Node(1);
		node2 = new Node(2);
		node3 = new Node(3);
		assertTrue(node1.getParent() == node1);
		assertFalse(node2.getParent() == node1);
		assertEquals(1, node1.getCell());
		assertEquals(node1, node1.find(node1));
		
		node2.setParent(node1);
		node3.setParent(node2);
		assertEquals(node1, node3.find(node3));
		assertEquals(node1, node2.getParent());
	}

}
