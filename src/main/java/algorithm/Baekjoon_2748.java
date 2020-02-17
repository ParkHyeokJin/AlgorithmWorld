package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_2748 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(reader.readLine());
			memo = new long[n + 1];
			memo[1] = 1;
			System.out.println( fibonacci(n) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static long[] memo;
	public static long fibonacci(int n) {
		if(memo[n] > 0)
			return memo[n];
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return memo[n];
	}
}