
public class ArraySumDriver {
	public static void main(String[]args) {
		ArraySum array_sum = new ArraySum();
		Integer[] a = {1,2,3};
		int x = array_sum.sumOfArray(a, 0);
		if (x == 6) {
			System.out.print("Works");
		}
	}

}
