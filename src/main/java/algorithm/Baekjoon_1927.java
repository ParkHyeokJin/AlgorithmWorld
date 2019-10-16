package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baekjoon_1927 {
	public static void main(String[] args){
		
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
        	int N = Integer.parseInt(reader.readLine());

        	Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        	
        	for(int i = 0; i < N; i++) {
        		int input = Integer.parseInt(reader.readLine());
        		if(input == 0) {
        			if(queue.isEmpty()){
        				System.out.println(0);
        			}else {
        				System.out.println(queue.poll());
        			}
        		}else {
        			queue.add(input);
        		}
        	}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
