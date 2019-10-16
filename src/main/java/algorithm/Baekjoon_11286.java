package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baekjoon_11286 {
	public static void main(String[] args){
		
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
        	int N = Integer.parseInt(reader.readLine());

        	Queue<Integer> positive = new PriorityQueue<>(Comparator.naturalOrder());
        	Queue<Integer> negative = new PriorityQueue<>(Comparator.reverseOrder());
        	
        	for(int i = 0; i < N; i++) {
        		int input = Integer.parseInt(reader.readLine());
        		if(input != 0) {
        			if(input > 0) {
        				positive.add(input);
        			}else {
        				negative.add(input);
        			}
        		}else {
	        		if(positive.isEmpty() && negative.isEmpty()){
	        			System.out.println(0);
	        		}else {
	        			if(positive.isEmpty()) {
	        				System.out.println(negative.poll());
	        			}else if(negative.isEmpty()) {
	        				System.out.println(positive.poll());
	        			}else {
	        				if(Math.abs(negative.peek()) == Math.abs(positive.peek())){
	        					System.out.println(negative.poll());
	        				}else {
	        					if(Math.abs(negative.peek()) > Math.abs(positive.peek())){
	        						System.out.println(positive.poll());
	        					}else {
	        						System.out.println(negative.poll());
	        					}
	        				}
	        			}
	        		}
        		}
        	}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
