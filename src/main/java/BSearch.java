package main.java;

import java.util.Arrays;

public class BSearch {
	static int[] arr = new int[] {9, 7, 2, 1, 5, 8, 3, 6, 4};
	
	public static void main(String[] args) {
		int[] findNum = new int[] {10, 2, 4, 11, 9};
		BSearch bSearch = new BSearch();
		//Á¤·Ä
		Arrays.sort(arr);
		//Å½»ö
		for (int i : findNum) {
			System.out.println(bSearch.find(0, arr.length - 1, i));
		}
	}
	
	private int find(int left, int right, int num) {
		int index = (left + right) / 2;
		if(left > right) {
			return 0 ;
		}
		if(arr[index] == num) {
			return 1;
		}
		if(arr[index] > num) {
			return find(left, index - 1, num);
		}else {
			return find(index + 1, right, num);
		}
	}
}
