import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] numbers = {3,5,1,2,4,8,6,9,7};
		sort(numbers);
	}
	
	private static void sort(int[] numbers) {
		int i, j;
		int tmp = 0;
		for (i = 0; i < numbers.length; i++) {
			for(j = 0; j < numbers.length - 1 - i; j++) {
				if(numbers[j] > numbers[j + 1]) {
					tmp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(numbers));
	}
}
