package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_10872 {
	
	private static int result = 1;
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int num = Integer.parseInt(reader.readLine());
			factorial(num);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void factorial(int num) {
		if(num == 0) return;
		result = result * num;
		num--;
		factorial(num);
	}
}
