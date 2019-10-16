package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_10952 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	String str = "";
        	while(true) {
        		str = reader.readLine();
        		if(str.equals("0 0"))
        			break;
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
