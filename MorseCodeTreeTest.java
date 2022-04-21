/**
 * Test class for MorseCodeTree class
 * @author vanessa
 *
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MorseCodeTreeTest {
	
	private MorseCodeTree test;
	
	@BeforeEach
	void setUp() throws Exception{
		test = new MorseCodeTree();
	}
	
	@AfterEach
	void tearDown() throws Exception{
		test = null;
	}
	
	@Test
	void testGetRoot() {
		String result = "";
		String t = test.getRoot().getData();
		assertEquals(result,t);
	}
	
	@Test
	void testSetRoot() {
		String result = "'";
		TreeNode<String> newNode = new TreeNode<>("'");
		test.setRoot(newNode);
		assertEquals(result, test.getRoot().getData());
	}
	
	@Test
	void testInsert() {
		
		test.insert(".....", "0");
		test.insert("....-", "1");
		test.insert("...-.", "2");
		test.insert("...--", "3");
		test.insert("..-..", "4");
		test.insert("..-.-", "5");
		test.insert(".-...", "6");
		test.insert(".-..-", "7");
		test.insert(".--..", "8");
		test.insert(".--.-", "9");
		
		String correctResult = "0 h 1 s 2 v 3 i 4 f 5 u e 6 l 7 r a 8 p 9 w j  "
				+ "b d x n c k y t z g q m o";
		
		ArrayList<String> arrayTree = test.toArrayList();
		
		String outputTree = "";
		for(int i =0; i < arrayTree.size(); i++) {
			outputTree += arrayTree.get(i) + " ";
		}
		assertEquals(correctResult, outputTree.trim());
	}
	
	@Test
	void testFetch() {
		String expected1 = "h";
		String result = test.fetch("....");
		assertEquals(expected1, result);
		
		String expected2 = "v";
		String result2 = test.fetch("...-");
		assertEquals(expected2, result2);
		
		String expected3 = "j";
		String result3 = test.fetch(".---");
		assertEquals(expected3, result3);
	}
	
	@Test
	void testBuildTree() {
		String correctResult = "h s v i f u e l r a p w j  b d x n "
				+ "c k y t z g q m o";
		
		ArrayList<String> arrayTree = test.toArrayList();
		
		String outputTree = "";
		for(int i = 0; i < arrayTree.size(); i++) {
			outputTree += arrayTree.get(i) + " ";
		}
		assertEquals(correctResult, outputTree.trim());
	}
	
	@Test
	void testToArrayList() {
		
	
		ArrayList<String> expected = new ArrayList<>();;
		expected.add("h");
		expected.add("s");
		expected.add("v");
		expected.add("i");
		expected.add("f");
		expected.add("u");
		expected.add("e");
		expected.add("l");
		expected.add("r");
		expected.add("a");
		expected.add("p");
		expected.add("w");
		expected.add("j");
		expected.add("");
		expected.add("b");
		expected.add("d");
		expected.add("x");
		expected.add("n");
		expected.add("c");
		expected.add("k");
		expected.add("y");
		expected.add("t");
		expected.add("z");
		expected.add("g");
		expected.add("q");
		expected.add("m");
		expected.add("o");
		
		for(int i = 0; i < test.toArrayList().size(); i++) {
			assertEquals(expected.get(i), test.toArrayList().get(i));
		}
	}
		
	
}