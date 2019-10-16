package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon_10816 {
	
	private static int[] cards;
	private static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력 처리
		bufferedRead();
		//카드 목록 정렬
		Arrays.sort(cards);
		//탐색
		StringBuilder sb = new StringBuilder();
		for (int num : numbers) {
			sb.append(find(num)).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	private static int find(int num) {
		int left = findLeft(cards, 0, cards.length, num);
		int right = findRight(cards, 0, cards.length, num);
		return right - left;
	}
	
	//찾고자 하는 숫자의 왼쪽 시작 점 검색
	private static int findLeft(int[] arr, int left, int right, int num) {
		int index = (left + right) / 2;
		if(left >= right) {
			return index;
		}
		if( arr[index] >= num ) {
			return findLeft(arr, left, index, num);
		}else {
			return findLeft(arr, index + 1, right, num);
		}
	}
	
	//찾고자 하는 숫자의 오른쪽 종료 점 검색
	private static int findRight(int[] arr, int left, int right, int num) {
		int index = (left + right) / 2;
		if(left >= right) {
			return index;
		}
		if( arr[index] <= num ) {
			return findRight(arr, index + 1, right, num);
		}else {
			return findRight(arr, left, index, num);
		}
	}
	
	private static void bufferedRead()  throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//숫자 카드의 개수
		int n = Integer.parseInt(reader.readLine());
		//숫자 카드
		String[] inputCards = reader.readLine().split(" ");
		
		//정수의 개수
		int m = Integer.parseInt(reader.readLine());
		//정수
		String[] inputNums = reader.readLine().split(" ");
		
		cards = new int[n];
		numbers = new int[m];
		
		for (int i = 0; i < inputCards.length; i++) {
			cards[i] = Integer.parseInt(inputCards[i]);
		}
		for (int i = 0; i < inputNums.length; i++) {
			numbers[i] = Integer.parseInt(inputNums[i]);
		}
	}
}
