package main.java;

public class CountingSort {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,3,2,5,6,2,2,1,4,5,1,2,3,1,1,2,2,2,2,1,4,5,1,2};
		Sort(arr, 7);
	}

	private static void Sort(int[] arr, int size) {
		int[] count = new int[size];
		//Counting
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] += 1;
		}
		
		//정렬(출력)
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				System.out.print(i);
			}
		}
	}
}
