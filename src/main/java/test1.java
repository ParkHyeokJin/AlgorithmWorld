package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class test1 {
	public static void main(String[] args) {
		Queue<Integer> positive = new PriorityQueue<>();
    	Queue<Integer> negative = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
    	positive.add(2);
    	positive.add(1);
    	positive.add(3);
    	
    	negative.add(-1);
    	negative.add(1);
    	negative.add(-2);
    	negative.add(2);
    	negative.add(-1);
    	
    	
    	System.out.println(positive);
    	System.out.println(negative);
	}
}
