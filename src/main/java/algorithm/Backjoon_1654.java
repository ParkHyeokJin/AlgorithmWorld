package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon_1654 {
	
	private static int n = 0; //필요한 랜선의 갯수
	private static int[] lines;
	private static long maxLen = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputA = reader.readLine().split(" ");
		
		//랜선의 개수
		int k = Integer.parseInt(inputA[0]);
		//필요한 랜선의 개수
		n = Integer.parseInt(inputA[1]);
		
		lines = new int[k];
		long sumLen = 0;
		for(int i = 0; i < k; i++) {
			int len = Integer.parseInt(reader.readLine());
			lines[i] = len;
			sumLen += len;
		}
		Arrays.sort(lines);
		System.out.println(Bsearch(1, sumLen / n));
	}
	public static long Bsearch(long left, long right) {
		int cnt = 0;
		long mid = (left + right) / 2;
		if(left > right) return maxLen;
		for (int i : lines) {
			cnt += i / mid;
		}
		if( cnt >= n) {
			if(mid > maxLen) {
				maxLen = mid;
			}
			return Bsearch(mid + 1, right);
		} else {
			return Bsearch(left, mid -1);
		}
	}
}
