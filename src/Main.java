/* Student Information
* -------------------
* Student Name: Salehi, Hishmat
* Student Number: 400172262
* Course Code: CS 2XB3
* Lab Section: 03
*
* I attest that the following code being submitted is my own individual work.
*/

public class Main {

	public static void main(String[] args) throws Exception {

		Set set = new Set();
		set = set.add("a");
		
		String[] a = {"a", "b", "f"};
		String[] b = {"c", "d", "e", "f"};

		Set set1 = new Set(a, 3);
		Set set2 = new Set(b, 4);
		
		System.out.println("set1 = " + set1 + ", size = " + set1.getCount());
		System.out.println("set2 = " + set2 + ", size = " + set2.getCount());
		System.out.println("set1 contains b is " + set1.contains("b"));
		System.out.println("set2 contains b is " + set2.contains("d"));
		System.out.println("Union of set1 and set2: " + set1.union(set2));
		System.out.println("Intersection of set1 and set2: " + set1.intersection(set2));
		
	}
	
}
