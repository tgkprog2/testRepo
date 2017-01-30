package samples.arrayCompare;

/**
 * Find sequence of array ints in another array of int. ignore repeats if not in find array. Order should match.
 */
public class FindSeq1 {

	/**
	 * Function to check if an array 'data' has all the elements that are in another array 'find', and in the same order as they appear in
	 * the 'find' array.
	 * Test 1.
	 */
	public boolean isArray2FoundInSeq(int[] data, int[] find) {
		if (data == null || find == null || find.length == 0 || data.length == 0) {
			return false;// or exception
		}
		int f = 0;
		for (int i = 0; i < data.length; i++) {
			if (find[f] == data[i]) {
				f++;
				if (f == find.length) {
					// all found
					return true;
				}
			}
		}
		return false;
	}

	/** Test harness */

	public static void main(String[] args) {
		FindSeq1 ap = new FindSeq1();
		ap.doTests();

	}

	private void doTests() {
		{
			int[] data = { 422, 5, 5, 900, 334, 7, 55 };
			int[] find = { 5, 334, 7 };
			do1Test(data, find, true, "5 repeated but still okay");
		}
		{
			int[] data = { 12, 11, 5, 3, 10033, 2323, 7, 33 };
			int[] find = { 5, 334, 33 };
			do1Test(data, find, false, "first & third there only");
		}
		{
			int[] data = { 12, 11, 5, 3, 10033, 2323, 7, 33 };
			int[] find = { 5, 334, 7, 4454, 45454, 4545, 34, 5 };
			do1Test(data, find, false, "find bigger");
		}

		System.out.println("Total " + index + " Success " + succ + ", Is okay :" + (index == succ));

	}

	int index = 0;
	int succ = 0;

	private void do1Test(int[] data, int[] find, boolean ex, String comment) {
		boolean actual = false;
		index++;
		try {
			actual = isArray2FoundInSeq(data, find);
			if (actual == ex) {
				succ++;
			} else {
				System.out.println("For " + index + " got " + actual + ", expecting " + ex + " " + comment + ".");
			}
		} catch (Exception e) {
			// count as  unexpected in this case
			System.out.println("Unexpected exception :" + e + ". For " + index + ", expecting " + ex + " " + comment + ".");

		}
	}

}
