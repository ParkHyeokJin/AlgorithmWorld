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
	    
	    if(left >= right) { // ���Ұ� 1���� ���
	    	return;
	    }
	    
        start = left;
        end = right;
        pivot = numbers[(left+right)/2];
        //���� ����
        while (start < end) {	//�������� ���
        	
        	while (numbers[start] < pivot) start++;    //�ǹ� �� ���� ū ���� ���������� �ݺ�
        	
        	// �� �κп��� arr[end-1]�� �����ؼ� �ͼ��� �߻������ϱ� ������ end > start ���� �ʿ�
            while (numbers[end] > pivot && end > start) end--;    //�ǹ� �� ���� ���� ���� ���������� �ݺ�

            tmp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = tmp;
        }
        //���� ����
        quickSort(numbers, left, start - 1);
        quickSort(numbers, end + 1, right);
    }
}