import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] numbers = {3,5,1,2,4,8,6,9,7};
		sort(numbers);
	}
	private static void sort(int[] numbers) {
		int min, tmp;
		for (int i = 0; i < numbers.length - 1; i++) {
			min = i;
			for(int j = i + 1; j < numbers.length; j++) {
				if(numbers[min] > numbers[j]) {
					min = j;
				}
			}
			tmp = numbers[min];
			numbers[min] = numbers[i];
			numbers[i] = tmp;
		}
		System.out.println(Arrays.toString(numbers));
	}
	
	
}