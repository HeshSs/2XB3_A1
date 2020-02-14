/* Student Information
*---------
* Student Name: Salehi, Hishmat
* Student Number: 400172262
* Course Code: CS 2XB3
* Lab Section: 03
*
* I attest that the following code being submitted is my own individual work.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class testSet {
	private static FileOutputStream outFile;
	private static PrintStream fileOut;
	private Set setR;
	private Set setS;
	
	@BeforeClass
	public static void init() throws FileNotFoundException{
		outFile = new FileOutputStream("output.txt");
		fileOut = new PrintStream(outFile);
		System.setOut(fileOut);
	}
	
	@Before
	public void setUp() throws Exception {
		Scanner input = new Scanner(new File("input.txt"));
		int counter = 1;
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] elements = line.split(",");
			
			if (counter == 1) {
				setR = new Set(elements, elements.length);
			} else if (counter == 2) {
				setS = new Set(elements, elements.length);
			} 
			counter++;
		}
		
		input.close();
	}

	@After
	public void tearDown() throws Exception {
		setR = setS = null;
	}
	
	@Test
	public void testLocalMethods() throws Exception {
		String[] arrayR = setR.getArray();
		
		System.out.println("Entering testLocalMethods");
		assert setR.getIndex() == setR.getCount();
		System.out.println("Test case 1 passed.");
		assert setR.add("new").isEqual(new Set(arrayR, 7).add("new"));
		System.out.println("Test case 2 passed.");
		assert setR.remove("a").isEqual(new Set(arrayR, 7).remove("a"));
		System.out.println("Test case 3 passed.");
		assert setR.contains("a");
		System.out.println("Test case 4 passed.");
		assert setS.contains("f");
		System.out.println("Test case 5 passed.");
		try {
			setR.add("a");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("Test case 6 passed.");
		System.out.println("-------------------- testLocalMethods Complete");
	}
	
	@Test
	public void testUnion() {
		String[] union = {"a","b","c","d","e","f","g","h","i","j","k","l"};
		Set unionSet = new Set(union, union.length);

		System.out.println("Entering testUnion");
		assert setR.union(setS).isEqual(unionSet);
		System.out.println("Test case 1 passed.");
		assert setR.union(setS).isEqual(setS.union(setR));
		System.out.println("Test case 2 passed.");
		System.out.println("-------------------- testUnion Complete");
	}
	
	@Test
	public void testIntersection() throws Exception {
		String[] intersection = {"f", "g"};
		Set intersectionSet = new Set(intersection, intersection.length);

		System.out.println("Entering testIntersection");
		assert setR.intersection(setS).isEqual(intersectionSet);
		System.out.println("Test case 1 passed.");
		assert setR.intersection(setS).isEqual(setS.intersection(setR));
		System.out.println("Test case 2 passed.");
		System.out.println("-------------------- testIntersection Complete");

	}
	
	@Test
	public void testDifference() throws Exception {
		String[] difference = {"a","b","c","d","e"};
		Set differenceSet = new Set(difference, difference.length);

		System.out.println("Entering testDifference");
		assert setR.difference(setS).isEqual(differenceSet);
		System.out.println("Test case 1 passed.");
		assert !setR.difference(setS).isEqual(setS.difference(setR));
		System.out.println("Test case 2 passed.");
		System.out.println("-------------------- testDifference Complete");

	}
	
	@Test
	public void testProduct() throws Exception {		
		String[] product = {"af", "ag", "ah", "ai", "aj", "ak", "al",
							"bf", "bg", "bh", "bi", "bj", "bk", "bl",
							"cf", "cg", "ch", "ci", "cj", "ck", "cl",
							"df", "dg", "dh", "di", "dj", "dk", "dl",
							"ef", "eg", "eh", "ei", "ej", "ek", "el",
							"ff", "fg", "fh", "fi", "fj", "fk", "fl",
							"gf", "gg", "gh", "gi", "gj", "gk", "gl"};
		Set productSet = new Set(product, product.length);
		
		System.out.println("Entering testProduct");
		assert setR.product(setS).isEqual(productSet);
		System.out.println("Test case 1 passed.");
		if (!setR.isEqual(setS)) {
			assert !setR.product(setS).isEqual(setS.product(setR));
			System.out.println("Test case 2 passed.");
		}
		System.out.println("-------------------- testProduct Complete");
		
	}
	
	@Test
	public void testIsEqual() {
		System.out.println("Entering testIsEqual");
		assert setR.isEqual(setS) == setS.isEqual(setR);
		System.out.println("Test case 1 passed.");
		assert setR.isEqual(setR);
		System.out.println("Test case 2 passed.");
		System.out.println("-------------------- testIsEqual Complete");

	}
	
	@Test
	public void testIsSubset() throws Exception {		
		String[] subS = {"a", "b", "c"};
		String[] subR = {"f", "g", "h"};
		String[] subBoth = {"f"};
		Set subsetS = new Set(subS, subS.length);
		Set subsetR = new Set(subR, subR.length);
		Set subsetBoth = new Set(subBoth, subBoth.length);
		Set emptySet = new Set();
		
		System.out.println("Entering testIsSubset");
		assert subsetS.isSubset(setS);
		System.out.println("Test case 1 passed.");
		assert subsetR.isSubset(setR);
		System.out.println("Test case 2 passed.");
		assert subsetBoth.isSubset(setR.intersection(setS));
		System.out.println("Test case 3 passed.");
		assert emptySet.isSubset(setR) && emptySet.isSubset(setR);
		System.out.println("Test case 4 passed.");
		System.out.println("-------------------- testIsSubset Complete");
		
	}
	
	@Test
	public void testGetCount() throws Exception {
		System.out.println("Entering testGetCount");
		assert setS.getCount() == setR.getCount();
		System.out.println("Test case 1 passed.");
		assert setS.intersection(setR).getCount() == 2;
		System.out.println("Test case 2 passed.");
		System.out.println("-------------------- testGetCount Complete");

	}
	
	@Test
	public void testToString() {
		System.out.println("Entering testToString");
		assert setR.toString().equals("{a, b, c, d, e, f, g}");
		System.out.println("Test case 1 passed.");
		assert setS.toString().equals("{f, g, h, i, j, k, l}");
		System.out.println("Test case 2 passed.");
		System.out.println("-------------------- testToString Complete");

	}
	
	@AfterClass
	public static void tearDownAll() throws IOException{
		outFile.close();
		fileOut.close();
	}
	
}
