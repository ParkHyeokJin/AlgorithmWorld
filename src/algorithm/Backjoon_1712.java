package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStr = reader.readLine().split(" ");
		int a = Integer.parseInt(inputStr[0]);	//고정비
		int b = Integer.parseInt(inputStr[1]);	//가변비용
		int c = Integer.parseInt(inputStr[2]);	//노트북 가격
		System.out.println(breakEvenPoint(a, b, c));
		
	}

	private static int breakEvenPoint(int a, int b, int c) {
		//가변비용이 판매가격보다 클경우 이익이 남지 않는다.
		if(b >= c) return -1;
		int cost = a / (c - b);
		return cost +  1;
	}
}
