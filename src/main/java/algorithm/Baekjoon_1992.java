package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1992 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	int N = Integer.parseInt(reader.readLine());
        	int[][] movie = readData(reader, N);
        	cut(movie);
        	System.out.println(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	private static int[][] readData(BufferedReader reader, int N) throws IOException {
		int[][] movie = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] readStr = reader.readLine().split("");
			for(int j = 0; j < N; j++) {
				movie[i][j] = Integer.parseInt(readStr[j]);
			}
		}
		return movie;
	}
	
	private static void cut(int[][] num){
		if(compression(num)) {
			return;
		}else {
			sb.append("(");
			int half = num.length / 2;
			cut(cutMovie(num, 0, half, 0, half));
			cut(cutMovie(num, 0, half, half, num.length));
			cut(cutMovie(num, half, num.length, 0, half));
			cut(cutMovie(num, half, num.length, half, num.length));
			sb.append(")");
		}
	}

	private static int[][] cutMovie(int[][] num, int xS, int xE, int yS, int yE) {
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
	
	private static boolean compression(int[][] num) {
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
				sb.append(0);
			}else {
				sb.append(1);
			}
			return true;
		}
	}
}

