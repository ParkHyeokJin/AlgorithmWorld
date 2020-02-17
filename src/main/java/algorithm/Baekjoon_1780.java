package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1780 {
	private static int minus = 0;
	private static int zero = 0;
	private static int one = 0;
	
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	int N = Integer.parseInt(reader.readLine());
        	int[][] paper = readData(reader, N);
        	cut(paper);
        	System.out.println(minus);
        	System.out.println(zero);
        	System.out.println(one);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	private static int[][] readData(BufferedReader reader, int N) throws IOException {
		int[][] movie = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] readStr = reader.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				movie[i][j] = Integer.parseInt(readStr[j]);
			}
		}
		return movie;
	}
	
	private static void cut(int[][] num){
		if(checkPaper(num)) {
			return;
		}else {
			for (int i = 0; i < 3; i++) {
				int xS = i * num.length / 3;
				int xE = (i + 1) * num.length / 3;
				
				for (int j = 0; j < 3; j++) {
					int yS = j * num.length / 3;
					int yE = (j + 1) * num.length / 3;
					
					cut(cutPaper(num, xS, xE, yS, yE));
				}
			}
		}
	}

	private static int[][] cutPaper(int[][] num, int xS, int xE, int yS, int yE) {
		int i = 0;
		int j = 0;
		int[][] tmp = new int[num.length/3][num.length/3];
		for(int x = xS; x < xE; x++) {
			for (int y = yS; y < yE; y++) {
				tmp[i][j++] = num[x][y];
			}
			i++;
			j = 0;
		}
		return tmp;
	}
	
	private static boolean checkPaper(int[][] num) {
		int[] numCnt = new int[3];
		for(int i = 0; i < num.length; i++) {
    		for (int j = 0; j < num.length; j++) {
    			if(num[i][j] == -1) {
    				numCnt[0] += 1;
    			}else if(num[i][j] == 0) {
    				numCnt[1] += 1;
    			}else {
    				numCnt[2] += 1;
    			}
			}
    	}
		if(isNotSameNumber(numCnt)) {
			return false;
		}else {
			countNumbers(numCnt);
			return true;
		}
	}

	private static boolean isNotSameNumber(int[] numCnt) {
		if(!isMinus(numCnt) && !isZero(numCnt) && !isOne(numCnt)) {
			return true;
		}
		return false;
	}

	private static void countNumbers(int[] numCnt) {
		if(isMinus(numCnt)) {
			minus += 1;
		}
		if(isZero(numCnt)) {
			zero += 1;
		}
		if(isOne(numCnt)) {
			one += 1;
		}
	}

	private static boolean isOne(int[] numCnt) {
		return numCnt[0] == 0 && numCnt[1] == 0 && numCnt[2] > 0;
	}

	private static boolean isZero(int[] numCnt) {
		return numCnt[0] == 0 && numCnt[1] > 0 && numCnt[2] == 0;
	}

	private static boolean isMinus(int[] numCnt) {
		return numCnt[0] > 0 && numCnt[1] == 0 && numCnt[2] == 0;
	}
}

