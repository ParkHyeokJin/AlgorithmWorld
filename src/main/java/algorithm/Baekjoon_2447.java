package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_2447 {
	
	private static String[][] tmp;
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(reader.readLine());
			tmp = new String[n][n];
			star(n, 0, 0);
			print();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < tmp.length; i++) {
			for(int j = 0; j < tmp[i].length; j++) {
				sb.append((tmp[i][j] == null ? " " : "*"));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void star(int n, int x, int y) {
		if(n == 1) {
			tmp[x][y] = "*";
			print();
			return;
		}
		int idx = n / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				star(idx, x + (idx * i), y + (idx * j));
			}
		}
	}
}
