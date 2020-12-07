package sec02.exam08;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
		int[] oldArray = {1,2,3};
		
		int[] newArray = new int[5];
		
		for(int i=0; i<oldArray.length; i=i+1) {
			newArray[i] = oldArray[i];
		}
		for(int i=0; i<newArray.length; i=i+1) {
			System.out.println(newArray[i] + ",");
		}
	}
}
