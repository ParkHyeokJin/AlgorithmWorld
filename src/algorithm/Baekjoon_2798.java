package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_2798 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int year = Integer.parseInt(reader.readLine());
            if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
