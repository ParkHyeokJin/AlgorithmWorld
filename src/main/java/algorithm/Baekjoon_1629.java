package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_1629 {
	private static long num = 1L;
	
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	String[] input = reader.readLine().split(" ");
        	long A = new Long(input[0]);
        	long B = new Long(input[1]);
        	long C = new Long(input[2]);
        	
        	multiplication(A, B, C);
        	
        	System.out.println(num % C);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	private static long multiplication(long a, long b, long c) {
		if(b == 0) return a / c;
		if(b % 2 == 0 ) {
			
		}else {
			
		}
	}
}

