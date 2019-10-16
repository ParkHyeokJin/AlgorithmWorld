package algorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1300 {
	
	private static int n = 0;
	private static int k = 0;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		
		makeArr();

		long left = 1;
		long right = k;
		
		System.out.println(bSearch(left, right));
	}

	private static void makeArr() {
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = (i + 1) * (j + 1);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		int[] b = new int[n*n];
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				b[idx++] = arr[i][j];
			}
		}
		
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
		
	}

	private static long result = 0 ;
	private static long bSearch(long left, long right) {
		int cnt = 0;
		long mid = (left + right) / 2;
		if(left > right) return result;
		for(int i = 1; i <= n; i++) {
			System.out.print(Math.min(mid/i, n));
			cnt += Math.min(mid/i, n);
		}
		System.out.println("mid > "+mid);
		System.out.println("----");
		if(k <= cnt) {
			result = mid;
			return bSearch(left, mid -1);
		}else{
			return bSearch(mid + 1, right);
		}
	}
}
