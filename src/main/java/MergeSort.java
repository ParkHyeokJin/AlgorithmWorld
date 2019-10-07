package main.java;

import java.util.Arrays;

public class MergeSort {
	private static int[] sorted = new int[9];
	
	public static void main(String[] args) {
		int[] numbers = { 3, 5, 1, 2, 4, 8, 6, 9, 7 };
		mergeSort(numbers, 0, numbers.length - 1);
		System.out.println(Arrays.toString(numbers));
	}
	
	//정복
	public static void merge(int arr[], int left, int middle, int right) {
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while(i <= middle && j <= right) {
			if(arr[i] <= arr[j]) {
				sorted[k] = arr[i];
				i++;
			}else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		
		if(i > middle) {
			for(int t = j; t <= right; t++) {
				sorted[k] = arr[t];
				k++;
			}
		} else {
			for(int t = i; t <= middle; t++) {
				sorted[k] = arr[t];
				k++;
			}
		}
		
		for(int t = left; t <= right; t++) {
			arr[t] = sorted[t];
		}
	}
	
	//분할(재귀함수)
	public static void mergeSort(int arr[], int left, int right) {
		if(left < right) {
			int middle = (left + right) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}
}
