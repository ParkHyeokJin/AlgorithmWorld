package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_10950 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int cnt = Integer.parseInt(reader.readLine());
            for(int i = 0; i < cnt; i++) {
            	String[] numbers = reader.readLine().split(" ");
            	int a = Integer.parseInt(numbers[0]);
            	int b = Integer.parseInt(numbers[1]);
            	sumPrint(a, b);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	private static void sumPrint(int a, int b) {
		System.out.println(a + b);
	}
}
