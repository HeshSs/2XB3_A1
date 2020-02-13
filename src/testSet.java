/* Student Information
* -------------------
* Student Name: Salehi, Hishmat
* Student Number: 400172262
* Course Code: CS 2XB3
* Lab Section: 03
*
* I attest that the following code being submitted is my own individual work.
*/

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class testSet {

	private Set s1;
	private Set s2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String[] a1 = {"a", "b", "c"};
		String[] a2 = {"d", "e", "f"};
		s1 = new Set(a1, 3);
		s2 = new Set(a2, 3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(s1.contains("a"));
		assertTrue(s2.contains("d"));
	}
}
