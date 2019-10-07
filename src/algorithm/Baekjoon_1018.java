package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1018 {
	
	static final String[][] caseA = {
			{"W","B","W","B","W","B","W","B"},
			{"B","W","B","W","B","W","B","W"},
			{"W","B","W","B","W","B","W","B"},
			{"B","W","B","W","B","W","B","W"},
			{"W","B","W","B","W","B","W","B"},
			{"B","W","B","W","B","W","B","W"},
			{"W","B","W","B","W","B","W","B"},
			{"B","W","B","W","B","W","B","W"}
	};
	
	static final String[][] caseB = {
			{"B","W","B","W","B","W","B","W"},
			{"W","B","W","B","W","B","W","B"},
			{"B","W","B","W","B","W","B","W"},
			{"W","B","W","B","W","B","W","B"},
			{"B","W","B","W","B","W","B","W"},
			{"W","B","W","B","W","B","W","B"},
			{"B","W","B","W","B","W","B","W"},
			{"W","B","W","B","W","B","W","B"}
	};
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] boardSize = reader.readLine().split(" ");
			String[][] inputBoard = inputReader(reader, Integer.parseInt(boardSize[0]), Integer.parseInt(boardSize[1]));
			
			int tmp = 0;
			int minPaint = 64;
			for(int i = 0; i <= inputBoard.length - 8; i++) {
				for(int j = 0; j <= inputBoard[i].length - 8; j++) {
					tmp = makeChess(inputBoard, i, j);
					minPaint = Math.min(minPaint, tmp);
				}
			}
			System.out.println(minPaint);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String[][] inputReader(BufferedReader reader, int M, int N) throws IOException {
		String[][] arr = new String[M][N];
		for(int i = 0; i < arr.length; i++) {
			String[] board = reader.readLine().split("");
			for (int j = 0; j < board.length; j++) {
				arr[i][j] = board[j];
			}
		}
		return arr;
	}

	private static int makeChess(String[][] arr, int x, int y) {
		String[][] board = new String[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = arr[i + x][j + y];
			}
		}
		return paintBoard(board);
	}

	private static int paintBoard(String[][] board) {
		int caseACnt = 0;
		int caseBCnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(caseA[i][j].equals(board[i][j])) {
					caseACnt++;
				}
				if(caseB[i][j].equals(board[i][j])) {
					caseBCnt++;
				}
			}
		}
		return Math.min(caseACnt, caseBCnt);
	}
	
	private static void print(String[][] arr) {
		for (String[] strings : arr) {
			for (String s : strings) {
				System.out.print(s);
			}
			System.out.println();
		}
	}
}
