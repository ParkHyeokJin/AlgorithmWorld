package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1780 {
	static int A = 0;
	static int B = 0;
	static int C = 0;
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	int N = Integer.parseInt(reader.readLine());
        	int[][] paper = readData(reader, N);
        	cut(paper, N);
        	System.out.println(A);
        	System.out.println(B);
        	System.out.println(C);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	private static int[][] readData(BufferedReader reader, int N) throws IOException {
		int[][] paper = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] readStr = reader.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(readStr[j]);
			}
		}
		return paper;
	}
	
	private static void cut(int[][] num, int pageCnt){
		if(checkNum(num)) {
			return;
		}else {
			int[][] tmp = new int[pageCnt / 3][pageCnt / 3];
			int idx = 1;
			int x = 0;
			int y = 0;
			while(idx <= 9) {
				for (int i = x; i < x + (pageCnt / 3); i++) {
					for (int j = y; j < y + (pageCnt / 3); j++) {
						tmp[i - x][j - y] = num[i][j];
					}
				}
				cut(tmp, pageCnt / 3);
				if(idx % 3 == 0) {
					x += pageCnt / 3;
					y = 0;
				}else {
					y += pageCnt / 3;
				}
				idx++;
			}
		}
	}

	private static boolean checkNum(int[][] num) {
		int tmp = 0;
		if(num.length > 0) {
			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < num.length - 1; j++) {
					tmp = num[i][j];
					if(tmp != num[i][j+1]) {
						return false;
					}
				}
			}
		}
		addCnt(num[0][0]);
		return true;
	}

	private static void addCnt(int num) {
		if(num == -1) {
			A++;
		}else if(num == 0) {
			B++;
		}else if(num == 1) {
			C++;
		}
	}
}

