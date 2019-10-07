package main.java;

import java.util.Arrays;

public class QuickSort {
	private static int[] numbers = { 3, 5, 1, 2, 4, 8, 6, 9, 7 };
	public static void main(String[] args) {
		quickSort(numbers, 0, numbers.length-1);
		System.out.println(Arrays.toString(numbers));
	}
	
	public static void quickSort(int[] numbers, int left, int right) {
	    int start, end, pivot, tmp;
	    
	    if(left >= right) { // 원소가 1개일 경우
	    	return;
	    }
	    
        start = left;
        end = right;
        pivot = numbers[(left+right)/2];
        //분할 과정
        while (start < end) {	//엇갈렸을 경우
        	
        	while (numbers[start] < pivot) start++;    //피벗 값 보다 큰 값을 만날때까지 반복
        	
        	// 이 부분에서 arr[end-1]에 접근해서 익셉션 발생가능하기 때문에 end > start 조건 필요
            while (numbers[end] > pivot && end > start) end--;    //피벗 값 보다 작은 값을 만날때까지 반복

            tmp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = tmp;
        }
        //정렬 과정
        quickSort(numbers, left, start - 1);
        quickSort(numbers, end + 1, right);
    }
}