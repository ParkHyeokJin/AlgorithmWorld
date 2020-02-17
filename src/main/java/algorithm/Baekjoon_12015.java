package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_12015 {
	
	static int[] numbers;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		numbers = new int[n];
		Arrays.fill(numbers, 1_000_001);
		
		int idx = 0;
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(scanner.next());
			if(numbers[idx] < num) {
				numbers[++idx] = num;
			}else {
				int a = bSearch(0, idx, num);
				numbers[a] = num;
			}
		}
		System.out.println(idx + 1);
	}
	
	private static int bSearch(int left, int right, int num) {
		int mid = (left + right) / 2;
		
		if(left >= right) return right;
		
		if(numbers[mid] < num) {
			return bSearch(mid + 1, right, num);
		}else {
			return bSearch(left, mid , num);
		}
	}
}
