package advanced_Programming;
import java.util.*;
public class Class1 {
	public int a;
	private int b;
	int c;
	protected int d;
	
	private void fillArray(int arr [] ) {
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
			 System.out.print("Enter a number: ");
		}
	}
	public int getmaxNumber(){
		int arr[] = new int[5]; 
		fillArray(arr);
		int max = 5;
		for (int i = 1; i < arr.length;i ++) {
			  if (arr[i] > max) {
	                max = arr[i];
			  }  
		}
		return max;
	}
	
}
