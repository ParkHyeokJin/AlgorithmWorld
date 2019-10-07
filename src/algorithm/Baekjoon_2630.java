package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2630 {
	
	private static int whiteCnt = 0;
	private static int blueCnt = 0;
	
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	int N = Integer.parseInt(reader.readLine());
        	int[][] paper = readData(reader, N);
        	cut(paper);
        	System.out.println(whiteCnt);
        	System.out.println(blueCnt);
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
	
	private static void cut(int[][] num){
		if(checkPaperColor(num)) {
			return;
		}else {
			int half = num.length / 2;
			cut(cutPaper(num, 0, half, 0, half));
			cut(cutPaper(num, 0, half, half, num.length));
			cut(cutPaper(num, half, num.length, 0, half));
			cut(cutPaper(num, half, num.length, half, num.length));
		}
	}

	private static int[][] cutPaper(int[][] num, int xS, int xE, int yS, int yE) {
		int i = 0;
		int j = 0;
		int[][] tmp = new int[num.length/2][num.length/2];
		for(int x = xS; x < xE; x++) {
			for (int y = yS; y < yE; y++) {
				tmp[i][j++] = num[x][y];
			}
			i++;
			j = 0;
		}
		return tmp;
	}
	
	private static boolean checkPaperColor(int[][] num) {
		int[] numCnt = new int[2];
		for(int i = 0; i < num.length; i++) {
    		for (int j = 0; j < num.length; j++) {
				numCnt[num[i][j]] += 1;
			}
    	}
		
		if(numCnt[0] > 0 && numCnt[1] > 0 ) {
			return false;
		}else {
			if(numCnt[0] > 0 && numCnt[1] == 0) {
				whiteCnt++;
			}else {
				blueCnt++;
			}
			return true;
		}
	}
}

