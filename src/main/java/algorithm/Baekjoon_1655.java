package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baekjoon_1655 {
	public static void main(String[] args) {
		Queue<Integer> max = new PriorityQueue<>();
		Queue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
			int N = Integer.parseInt(reader.readLine());

			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(reader.readLine());
				max.add(num);
				if( !isEvenSize(max, min) ) {
					min.add(max.poll());
				}else if(min.peek() > max.peek()) {
					max.add(min.poll());
					min.add(max.poll());
				}
				System.out.println(min.peek());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isEvenSize(Queue<Integer> max, Queue<Integer> min) {
		return (min.size() + max.size()) % 2 == 0;
	}
}
