import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = { 3, 5, 1, 2, 4, 8, 6, 9, 7 };
		sort(numbers);
	}
	private static void sort(int[] numbers) {
		for (int index = 1; index < numbers.length; index++) {
			int temp = numbers[index];
			int aux = index - 1;
			while ((aux >= 0) && (numbers[aux] > temp)) {
				numbers[aux + 1] = numbers[aux];
				aux--;
			}
			numbers[aux + 1] = temp;
		}
		System.out.println(Arrays.toString(numbers));
	}
}
