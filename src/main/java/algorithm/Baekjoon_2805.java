package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_2805 {
	
	private static int m = 0; //필요한 나무의 길이
	private static int[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputA = reader.readLine().split(" ");
		
		//나무의 수
		int n = Integer.parseInt(inputA[0]);
		//필요한 나무의 길이
		m = Integer.parseInt(inputA[1]);
		
		tree = new int[n];
		
		String[] inputTree = reader.readLine().split(" ");
		for (int i = 0; i < inputTree.length; i++) {
			tree[i] = Integer.parseInt(inputTree[i]);
		}
		Arrays.sort(tree);
		System.out.println(Bsearch(0, tree[tree.length - 1]));
	}
	
	private static long minLen = Integer.MAX_VALUE;
	private static long maxCut = 0;
	public static long Bsearch(long left, long right) {
		long treeSum = 0;
		long mid = (left + right) / 2;
		if(left > right) return maxCut;
		for (int i : tree) {
			if(i < mid) continue; 
			treeSum += i - mid;
		}
		if(treeSum >= m) {
			if(treeSum <= minLen) {
				minLen = treeSum;
				maxCut = mid;
			}
			return Bsearch(mid + 1, right);
		}else {
			return Bsearch(left, mid - 1);
		}
	}
}
