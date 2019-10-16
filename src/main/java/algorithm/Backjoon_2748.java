package algorithm;

import java.util.Scanner;

public class Backjoon_2748 {
	private static int inputNum = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		inputNum = scanner.nextInt();
		System.out.println(fibonacci(0, 1));
	}

	static int cnt = 1;
	private static int fibonacci(int a, int b) {
		cnt++;
		if(inputNum == cnt) return a + b;
		return fibonacci(b, a + b);
	}
}
