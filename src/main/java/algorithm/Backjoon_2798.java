package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_2798 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] inputStr = reader.readLine().split(" ");
			String[] card = reader.readLine().split(" ");
			//카드의 개수
			int N = Integer.parseInt(inputStr[0]);
			//블랙잭 요구 수
			int M = Integer.parseInt(inputStr[1]);
			blackJack(card, M, N);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void blackJack(String[] card, int M, int N) {
		int tmp = 0;
		int A = 0;
		int B = 0;
		int C = 0;
		for(int i = 0; i < N - 1; i++) {
			A = Integer.parseInt(card[i]);
			for(int j = i + 1; j < N - 1 ; j++) {
				B = Integer.parseInt(card[j]);
				for(int k = j + 1; k < N; k++) {
					C = Integer.parseInt(card[k]);
					int sum = A + B + C;
					if(sum == M) {
						System.out.println(sum);
						return;
					}else if(M > sum) {
						if(M - tmp >= M - sum) {
							tmp = sum;
						}
					}
				}
			}
		}
		System.out.println(tmp);
	}
}
