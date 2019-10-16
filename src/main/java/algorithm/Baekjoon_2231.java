package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_2231 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	String N = reader.readLine();
        	separation(N);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	private static void separation(final String n) {
		int num = Integer.parseInt(n);
		int minValue = num;
		boolean flag = false;
		for(int i = num; i >= 0; i--) {
			if(num == sum(i)) {
				if(minValue > i) {
					minValue = i;
					flag = true;
				}
			}
		}
		if(!flag) {
			System.out.println(0);
			return;
		}
		System.out.println(minValue);
	}

	private static int sum(int num) {
		int result = num;
		char[] numArr = String.valueOf(num).toCharArray();
		for(int i = 0; i < numArr.length; i++) {
			result += Integer.parseInt(String.valueOf(numArr[i]));
		}
		return result;
	}
}
