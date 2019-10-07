package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_1629 {
	static long num = 1L;
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	String[] input = reader.readLine().split(" ");
        	int A = Integer.parseInt(input[0]);
        	int B = Integer.parseInt(input[1]);
        	int C = Integer.parseInt(input[2]);
        	multiplication(A, B);
        	System.out.println(num % C);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	private static void multiplication(int a, int cnt) {
		if(cnt == 0) return;
		num = num * a;
		multiplication(a, --cnt);
	}
}

