package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_11729 {
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(reader.readLine());
			hanoi(n, 1, 2, 3);
			print();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void print() {
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	private static int cnt = 0;
	private static StringBuilder sb = new StringBuilder();
	public static void hanoi(int num, int from, int tmp, int to) {
		cnt++;
		if(num == 1) {
			sb.append(from +" "+ to + "\n");
			return;
		}else {
			hanoi(num - 1, from, to, tmp);
			sb.append(from +" "+ to + "\n");
			hanoi(num - 1, tmp, from, to);
		}
	}
}
