/* Student Information
* -------------------
* Student Name: Salehi, Hishmat
* Student Number: 400172262
* Course Code: CS 2XB3
* Lab Section: 03
*
* I attest that the following code being submitted is my own individual work.
*/

final public class Set {
	// The array that holds the content of the set
	private final String[] array;
	
	// The current index of the array; For adding new elements to the array
	private final int index;
	
	// Getter for array
	public String[] getArray() {
		return array;
	}
	
	// Getter for array index
	public int getIndex() {
		return index;
	}
	
	//Constructor for when there is no arguments
	Set() {
		array = new String[100];
		index = 0;
	}
	
	//Constructor for when there is 2 arguments
	Set(String[] arr, int size) {
		String[] new_array = new String[100];
		for (int i = 0; i < arr.length; i++) {
			new_array[i] = arr[i];
		}
		array = new_array;
		index = size;
	}
	
	// Method for adding elements to the Set
	public Set add(String str) throws Exception {
		if (contains(str)) {
			throw new Exception("The Set already contains: " + str);
		} else if (getIndex() == 100) {
			throw new Exception("The Set is full.");
		}
		
		String[] new_array = getArray();
		new_array[index] = str;
		
		return new Set(new_array, getIndex() + 1);
	}
	
	// Method for removing elements to the Set
	public Set remove(String str) throws Exception {
		if (!contains(str)) {
			throw new Exception("The Set doesn't contain: " + str);
		}
		
		String[] new_array = getArray();
		
		for (int i = 0; i < getIndex(); i++) {
			if (new_array[i].equals(str)) {
				for (int j = i; j < getIndex() - 1; j++) {
					new_array[j] = new_array[j+1];
				}
			}
		}
		new_array[getIndex() - 1] = null;
		return new Set(new_array, getIndex() - 1);
	}
	
	public boolean contains(String str) {
		for (int i = 0; i < getIndex(); i++) {
			if (getArray()[i].equals(str)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Set union(Set S) {
		String[] new_array = getArray();
		int new_index = getIndex();
		
		for (int i = 0; i < S.getIndex(); i++) {
			if (!contains(S.getArray()[i])) {
				new_array[new_index] = S.getArray()[i];
				new_index++;
			}
		}
		
		return new Set(new_array, new_index);
	}
	
	public Set intersection(Set S) throws Exception {
		Set new_set = new Set();
		
		for (int i = 0; i < S.getIndex(); i++) {
			if (contains(S.getArray()[i])) {
				new_set = new_set.add(S.getArray()[i]);
			}
		}
		
		return new_set;
	}
	
	public Set difference(Set S) {
		//TODO
	}
	
	public Set product(Set S) {
		//TODO

	}
	
	public boolean isEqual(Set S) {
		//TODO
	}
	
	public boolean isSubset(Set S) {
		//TODO
	}
	
	public int getCount() {
		return getIndex();
	}
	
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
