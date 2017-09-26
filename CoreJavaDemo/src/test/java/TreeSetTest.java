import org.junit.Test;

import java.util.TreeSet;

public class TreeSetTest {
	@Test
	public void testTreeSet() {
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("A1");
		treeSet.add("Q2");
		treeSet.add("A1");
		treeSet.add("A1");
		treeSet.add("A2");
		treeSet.add("A5");
		treeSet.add("A3");

		treeSet.forEach(System.out::println);
	}
}
