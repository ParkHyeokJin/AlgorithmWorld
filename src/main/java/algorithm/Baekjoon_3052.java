package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon_3052 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	List<Integer> numbers = new ArrayList<Integer>();
        	for(int i = 0 ; i < 9; i++) {
        		numbers.add(Integer.parseInt(reader.readLine()));
        	}
        	System.out.println(Collections.max(numbers));
        	System.out.println(numbers.indexOf(Collections.max(numbers)) + 1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
