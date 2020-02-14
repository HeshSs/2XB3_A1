/* Student Information
* -------------------
* Student Name: Salehi, Hishmat
* Student Number: 400172262
* Course Code: CS 2XB3
* Lab Section: 03
*
* I attest that the following code being submitted is my own individual work.
*/

/**
 * 	Assumptions: <ul>
 * 		<li> All the elements of the Set must be Strings </li>
 * 	</ul>
 *	Design: <ul>
 * 		<li> The Set can't contain more than 100 elements, this is because in Java the length of arrays is final </li>
 *  so would I have to create new array every time I added or removed an element.
 *  	<li> We probably won't need more than 100 elements. </li>
 *  	<li> If the Set reaches the 100th element and we try to add another element it will throw an exception that the Set is full. </li>
 *  	<li> Only the first 2 Sets from the input.txt are accepted, since we can test all methods with only 2 Sets. </li>
 *  	<li> Most tests will only run successfully with the my input.txt, since it's hard to test methods with arbitrary results.
 *  </ul>
 * @author Hishmat Salehi - MacID: Salehh6
 */
final public class Set {
	/**
	 * The array that holds the content of the set
	 */
	private final String[] array;
	
	/**
	 * The current index of the array; For adding new elements to the array
	 */
	private final int index;
	
	/**
	 * Getter that returns the array of elements
	 * @return Array of elements of type String
	 */
	public String[] getArray() {
		String[] newArray = new String[100];
		for (int i = 0; i < getIndex(); i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * Getter that returns the current index of the array.
	 * @return Current index of the array
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Constructor for when there is no arguments
	 */
	Set() {
		array = new String[100];
		index = 0;
	}
	
	/**
	 * Constructor for when there is 2 arguments
	 * @param arr Array of Strings
	 * @param size is the length of the array
	 */
	Set(String[] arr, int size) {
		String[] newArray = new String[100];
		for (int i = 0; i < arr.length; i++) {
			newArray[i] = arr[i];
		}
		array = newArray;
		index = size;
	}
	
	/**
	 * Method for adding an element to the Set
	 * @param str is the element that you want to add to the Set
	 * @return A new Set with the added element
	 * @throws An Exception when the element is already in the Set
	 */
	public Set add(String str) throws Exception {
		if (contains(str)) {
			throw new Exception("The Set already contains: " + str);
		} else if (getIndex() == 100) {
			throw new Exception("The Set is full.");
		}
		
		String[] newArray = getArray();
		newArray[index] = str;
		
		return new Set(newArray, getIndex() + 1);
	}
	
	/**
	 * Method for removing an element from the Set
	 * @param str is the element that you want to remove form the Set
	 * @return A new Set with the element removed
	 * @throws An Exception when the element is not in the Set
	 */
	public Set remove(String str) throws Exception {
		if (!contains(str)) {
			throw new Exception("The Set doesn't contain: " + str);
		}
		
		String[] newArray = getArray();
		
		for (int i = 0; i < getIndex(); i++) {
			if (newArray[i].equals(str)) {
				for (int j = i; j < getIndex() - 1; j++) {
					newArray[j] = newArray[j+1];
				}
			}
		}
		newArray[getIndex() - 1] = null;
		return new Set(newArray, getIndex() - 1);
	}
	
	/**
	 * Method for checking if a string is an element of the set.
	 * @param str is the Element that you want to check if it's in the Set
	 * @return true if the element is in the Set, false otherwise
	 */
	public boolean contains(String str) {
		for (int i = 0; i < getIndex(); i++) {
			if (getArray()[i] == null) {
				break;
			} else if (getArray()[i].equals(str)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Method that creates a new Set of union of the current Set and the Set S
	 * @param S is the Set that you want the union of with the current Set
	 * @return A new Set that contains all the elements of the current Set and Set S
	 */
	public Set union(Set S) {
		String[] newArray = getArray();
		int newIndex = getIndex();
		
		for (int i = 0; i < S.getIndex(); i++) {
			if (!contains(S.getArray()[i])) {
				newArray[newIndex] = S.getArray()[i];
				newIndex++;
			}
		}
		
		return new Set(newArray, newIndex);
	}
	
	/**
	 * Method that creates a new Set of intersection of the current Set and the Set S
	 * @param S is the Set that you want the intersection of with the current Set
	 * @return A new Set that contains mutual elements between the current Set and Set S
	 */
	public Set intersection(Set S) throws Exception {
		Set newSet = new Set();
		
		for (int i = 0; i < S.getIndex(); i++) {
			if (contains(S.getArray()[i])) {
				newSet = newSet.add(S.getArray()[i]);
			}
		}
		
		return newSet;
	}
	
	/**
	 * Method that creates a new Set of difference of the current Set from the Set S
	 * @param S is the Set that you want the difference of with the current Set
	 * @return A new Set that contains all the elements of the current Set, except the ones that are in the intersection of Set S
	 * @throws Exception
	 */
	public Set difference(Set S) throws Exception {
		Set newSet = new Set();
		
		for (int i = 0; i < getIndex(); i++) {
			if (S.contains(getArray()[i])) {
				continue;
			} else {
				newSet = newSet.add(getArray()[i]);
			}
		}
		
		return newSet;
	}
	
	/**
	 * Method that creates a new Set of Cartesian Product of the current Set with the Set S
	 * @param S is the Set that you want the Cartesian Product of with the current Set
	 * @return A new Set of all possible pairs of concatenated elements of the form rs, where r is in Set R and s is in Set S.
	 * @throws An Exception when the element is already in the Set
	 */
	public Set product(Set S) throws Exception {
		Set newSet = new Set();
		
		for (int i = 0; i < getIndex(); i++) {
			for (int j = 0; j < S.getIndex(); j++) {
				newSet = newSet.add(getArray()[i] + S.getArray()[j]);
			}
		}
		
		return newSet;
	}
	
	/**
	 * Method that checks if the current Set is equal to Set S
	 * @param S is the Set that you are comparing the current Set with
	 * @return true if the current S is equal to Set S, false otherwise
	 */
	public boolean isEqual(Set S) {
		boolean result = getCount() == S.getCount();
		
		for (int i = 0; i < S.getIndex(); i++) {
			if (!contains(S.getArray()[i])) {
				result = false;
			}
		}
		
		return result;
	}
	
	/**
	 * Method that checks if the current Set is a subset of Set S
	 * @param S is the Set that you are comparing the current Set with
	 * @return true if the current Set is a subset of Set S, false otherwise
	 */
	public boolean isSubset(Set S) {
		boolean result = getCount() <= S.getCount();
		
		for (int i = 0; i < getIndex(); i++) {
			if (!S.contains(S.getArray()[i])) {
				result = false;
			}
		}
		
		return result;
	}
	
	/**
	 * Method that returns the size of the Set
	 * @return The size of the Set
	 */
	public int getCount() {
		return getIndex();
	}
	
	/**
	 * Returns the string representation of the current Set.
	 * @return The string representation with the format "{e_1, e_2, e_3, ... , e_n}"
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		
		for (int i = 0; i < getIndex(); i++) {
			sb.append(getArray()[i]);
			if (i != getIndex() - 1) {
				sb.append(", ");
			}
		}
		
		sb.append("}");		
		return sb.toString();
	}
	
}
