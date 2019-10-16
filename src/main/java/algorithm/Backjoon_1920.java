package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon_1920 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int aLen = Integer.parseInt(reader.readLine());
		String[] inputArrA = reader.readLine().split(" ");
		int bLen = Integer.parseInt(reader.readLine());
		String[] inputArrB = reader.readLine().split(" ");
		
		int[] arr = new int[aLen];
		int[] findNums = new int[bLen];
		
		for (int i = 0; i < inputArrA.length; i++) {
			arr[i] = Integer.parseInt(inputArrA[i]);
		}
		for (int i = 0; i < inputArrB.length; i++) {
			findNums[i] = Integer.parseInt(inputArrB[i]);
		}
		
		Arrays.sort(arr);
		for (int num : findNums) {
			System.out.println(find(arr, 0, arr.length - 1, num));
		}
	}
	
	private static int find(int[] arr, int left, int right, int num) {
		int index = (left + right) / 2;
		if(left > right) {
			return 0 ;
		}
		if(arr[index] == num) {
			return 1;
		}
		if(arr[index] > num) {
			return find(arr, left, index - 1, num);
		}else {
			return find(arr, index + 1, right, num);
		}
	}
}
