package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_1003 {
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int t = Integer.parseInt(reader.readLine());
			memo = new int[40+1][2];
			for(int i = 0; i < t; i++) {
				int n = Integer.parseInt(reader.readLine());
				cntArr = new int[2];
				fibonacci(n);
				sb.append(cntArr[0] + " " + cntArr[1] + "\n");
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int[] cntArr;
	private static int[][] memo;
	public static int fibonacci(int n) {
		if(memo[n][0] > 0 || memo[n][1] > 0 ){
			cntArr[0] += memo[n][0];
			cntArr[1] += memo[n][1];
			return n;
		}
		if (n == 0) {
			cntArr[0]++;
			return 0;
		}else if (n == 1) {
			cntArr[1]++;
			return 1;
		}else {
			int num = fibonacci(n - 1) + fibonacci(n - 2);
			memo[n][0] = cntArr[0];
			memo[n][1] = cntArr[1];
			return num;
		}
	}
}
