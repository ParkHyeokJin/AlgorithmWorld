package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2588 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int a = Integer.parseInt(reader.readLine());
			String b = reader.readLine();
			
			char[] c = b.toCharArray();
			
			for (int i = c.length -1; i >= 0 ; i--) {
				System.out.println(a * Integer.parseInt(String.valueOf(c[i])));
			}
			System.out.println(a * Integer.parseInt(b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
