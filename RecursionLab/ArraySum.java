
public class ArraySum {
	public int sumOfArray(Integer[]a,int index) {
		if (index == a.length-1) {
			return a[index];
		}
		else {
			return a[index] + sumOfArray(a,index+1);
		}
		
	}
	
}
