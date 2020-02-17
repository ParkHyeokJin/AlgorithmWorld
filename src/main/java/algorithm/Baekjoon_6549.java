package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_6549 {
	
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	String input = "";
        	while(!(input = reader.readLine()).equals("0")) {
        		String[] inputArr = input.split(" ");
        		
        		//사각형 개수 
        		int squareCnt = Integer.parseInt(inputArr[0]);
        		
        		//사각형의 높이 입력 처리
        		int[] inputSquare = makeInputSquare(inputArr, squareCnt);
        		
        		//사각형중 가장 높은 사각형 리턴
        		int maxHeight = getSquareMaxHeight(inputSquare);
        		
        		//histogram 생성
        		int[][] histogram = makeHistogram(squareCnt, inputSquare, maxHeight);
        		
        		for (int i = 0; i < histogram.length; i++) {
        			System.out.println(Arrays.toString(histogram[i]));
				}
        		cut(histogram);
        		
        		System.out.println(maxCnt);
        	}
        	//cut(paper);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	private static void cut(int[][] num){
		if(checkSquare(num)) {
			return;
		}else {
			for (int i = 0; i < num.length - 1; i++) {
				int xS = i;
				int xE = i + 1;

				for (int k = 0; k < num.length - 1; k++) {
					int yS = k;
					int yE = k + 1;
					System.out.println(xS + "^" + xE + "^" + yS + "^" + yE);
					cutSquare(num, xS, xE, yS, yE);
				}
			}
		}
	}

	private static int[][] cutSquare(int[][] num, int xS, int xE, int yS, int yE) {
		int i = 0;
		int j = 0;
		int[][] tmp = new int[xE][yE];
		for(int x = xS; x < xE; x++) {
			for (int y = yS; y < yE; y++) {
				tmp[i][j++] = num[x][y];
			}
			i++;
			j = 0;
		}
		
		for (int k = 0; k < tmp.length; k++) {
			System.out.println(Arrays.toString(tmp[k]));
		}
		
		return tmp;
	}
	
	private static boolean checkSquare(int[][] num) {
		int[] numCnt = new int[2];
		for(int i = 0; i < num.length; i++) {
    		for (int j = 0; j < num[i].length; j++) {
    			if(num[i][j] == 0) {
    				numCnt[0] += 1;
    			}else {
    				numCnt[1] += 1;
    			}
			}
    	}
		if(isSameNumber(numCnt)) {
			countNumbers(numCnt);
			return true;
		}
		return false;
	}
	
	private static int[] makeInputSquare(String[] inputArr, int squareCnt) {
		int[] inputSquare = new int[squareCnt];
		for(int i = 1; i < inputArr.length; i++) {
			inputSquare[i-1] = Integer.parseInt(inputArr[i]);
		}
		return inputSquare;
	}

	private static int[][] makeHistogram(int squareCnt, int[] inputSquare, int maxHeight) {
		int[][] square = new int[squareCnt][maxHeight];
		for (int i = 0; i < square.length; i++) {
			int height = inputSquare[i];
			for (int j = 0; j < square[i].length; j++) {
				if(height > 0) {
					square[i][j] = 1;
					height--;
				}else {
					break;
				}
			}
		}
		
		return square;
	}

	private static int getSquareMaxHeight(int[] inputArr) {
		int[] arr = Arrays.copyOf(inputArr, inputArr.length);
		Arrays.sort(arr);
		return arr[inputArr.length - 1];
	}

	private static boolean isSameNumber(int[] numCnt) {
		if(numCnt[0] > 0 && numCnt[1] > 0) {
			return false;
		}
		return true;
	}

	static int maxCnt = 0;
	private static void countNumbers(int[] numCnt) {
		if(numCnt[1] > maxCnt) {
			maxCnt = numCnt[1];
		}
	}
}

