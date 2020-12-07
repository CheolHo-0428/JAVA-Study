package sec02.verify.exam05;

public class Exercise05 {

	public static void main(String[] args) {
		int[][]array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		int count = 0;
		double avg = 0.0;
		
		for(int i=0; i<array.length; i=i+1) {
			for(int k=0; k<array[i].length; k=k+1) {
				sum = sum + array[i][k];
				count = count + 1;
			}
		}
		avg = (double) sum / count ; 
		
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);
			}
	}


