package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_2110 {
	
	private static int c = 0; //공유기의 갯수
	private static int[] location;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputA = reader.readLine().split(" ");
		
		//집의 갯수
		int n = Integer.parseInt(inputA[0]);
		//공유기의 갯수
		c = Integer.parseInt(inputA[1]);
		
		location = new int[n];
		
		for (int i = 0; i < n; i++) {
			location[i] = Integer.parseInt(reader.readLine());
		}
		Arrays.sort(location);
		System.out.println(Bsearch(1, location[location.length - 1]));
	}
	
	private static long maxMid = 0;
	public static long Bsearch(long left, long right) {
		long tmp = 0;
		int cnt = 0;

		long mid = (left + right) / 2;	//집간의 거리
		if(left > right) return maxMid;
		
		for (int i : location) {
			if( tmp == 0 ) { tmp = i; cnt++; continue; }
			
			if( i - tmp >= mid ) {
				cnt++;
				tmp = i;
			}
		}
		if(cnt >= c) {
			if(mid > maxMid) {
				maxMid = mid;
			}
			return Bsearch(mid + 1, right);
		}else {
			return Bsearch(left, mid - 1);
		}
	}
}
