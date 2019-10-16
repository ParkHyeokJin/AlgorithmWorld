package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon_10818 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int cnt = Integer.parseInt(reader.readLine());
            String[] numbers = reader.readLine().split(" ");
            List<Integer> nums = new ArrayList<>(cnt);
            for (String v : numbers) {
				nums.add(Integer.parseInt(v));
			}
            
            System.out.println(Collections.min(nums) + " " + Collections.max(nums));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
