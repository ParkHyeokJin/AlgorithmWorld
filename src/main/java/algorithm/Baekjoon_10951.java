package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_10951 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	String str = "";
        	while((str = reader.readLine()) != null) {
        		sumPrint(str);
        	}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	private static void sumPrint(String v) {
		String[] numbers = v.split(" ");
		System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
	}
}
