import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
//		SelectionSortOrderByAsc(new int[]{3,6,5,1,7,8,2,9,4});
//		SelectionSortOrderByDesc(new int[]{3,6,5,1,7,8,2,9,4});
//		
//		System.out.println();
//		BubbleSortOrderByAsc(new int[]{3,6,5,1,7,8,2,9,4});
//		BubbleSortOrderByDesc(new int[]{3,6,5,1,7,8,2,9,4});
//		
//		System.out.println();
//		InsertionSortOrderByAsc(new int[]{3,6,5,1,7,8,2,9,4});
//		InsertionSortOrderByDesc(new int[]{3,6,5,1,7,8,2,9,4});
//		
//		System.out.println();
//		int[] nums = new int[]{3,6,5,1,7,8,2,9,4};
//		QuickSortOrderByAsc(nums, 0, nums.length-1);
//		System.out.println(Arrays.toString(nums));
//		
//		QuickSortOrderByDesc(nums, 0, nums.length-1);
//		System.out.println(Arrays.toString(nums));
		
		HeapSortOrderByAsc(new int[] {3,5,1,2,4,8,6,9,7});
	}

	//최대 힙 구조 변경
	private static void HeapSortOrderByAsc(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int c = i;
			while(c != 0) {
				int root = (c - 1) / 2;
				if(nums[root] < nums[c]) {
					int temp = nums[root];
					nums[root] = nums[c];
					nums[c] = temp;
				}
				c = root;
			}
		}		
		System.out.println(Arrays.toString(nums));
		
		// 크기를 줄여가며 반복적으로 힙을 구성
		for (int i = nums.length - 1; i == 0; i--) {
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			int root = 0;
			int c = 1;
			
			while(c < i){
				c = 2 * root + 1;
				if(nums[c] < nums[c + 1] && c < i - 1) {
					c++;
				}
				//루트보다 자식이 큰경우 교체
				if(nums[root] < nums[c] && c < i ) {
					int temp2 = nums[root];
					nums[root] = nums[c];
					nums[c] = temp2;
				}
				root = c;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	

	private static void QuickSortOrderByAsc(int[] nums, int start, int end) {
		int temp, left, pivot, right;
		
		if( start >= end ) return;
		
		left = start;
		right = end;
		pivot = nums[(start + end) / 2];
		
		while(left < right) {
			
			while(nums[left] < pivot) left++;
			
			while(nums[right] > pivot && right > left) right--;
			
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
		QuickSortOrderByAsc(nums, start, left - 1);
		QuickSortOrderByAsc(nums, right + 1, end);
	}
	
	private static void QuickSortOrderByDesc(int[] nums, int start, int end) {
		int temp, left, pivot, right;
		
		if( start >= end ) return;
		
		left = start;
		right = end;
		pivot = nums[(start + end) / 2];
		
		while(left < right) {
			
			while(nums[left] > pivot) left++;
			
			while(nums[right] < pivot && right > left) right--;
			
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
		QuickSortOrderByDesc(nums, start, left - 1);
		QuickSortOrderByDesc(nums, right + 1, end);
	}

	private static void SelectionSortOrderByAsc(int[] numbers) {
		int min, temp, idx = 0;
		int i, j;
		for (i = 0; i < numbers.length; i++) {
			min = numbers[i];
			for (j = i; j < numbers.length; j++) {
				if(min > numbers[j]) {
					min = numbers[j];
					idx = j;
				}
			}
			temp = numbers[idx];
			numbers[idx] = numbers[i];
			numbers[i] = temp;
		}
		System.out.println(Arrays.toString(numbers));
	}
	
	private static void SelectionSortOrderByDesc(int[] numbers) {
		int max, temp, idx = 0;
		int i, j;
		for (i = 0; i < numbers.length; i++) {
			max = 0;
			for (j = i; j < numbers.length; j++) {
				if(max < numbers[j]) {
					max = numbers[j];
					idx = j;
				}
			}
			temp = numbers[idx];
			numbers[idx] = numbers[i];
			numbers[i] = temp;
		}
		System.out.println(Arrays.toString(numbers));
	}

	private static void BubbleSortOrderByAsc(int[] numbers) {
		int temp;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if(numbers[j] > numbers[j + 1]) {
					temp = numbers[j + 1];
					numbers[j + 1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(numbers));
	}
	
	private static void BubbleSortOrderByDesc(int[] numbers) {
		int temp;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if(numbers[j] < numbers[j + 1]) {
					temp = numbers[j + 1];
					numbers[j + 1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(numbers));
	}

	private static void InsertionSortOrderByAsc(int[] numbers) {
		int idx;
		int num;
		for (int i = 1; i < numbers.length; i++) {
			idx = i - 1;
			num = numbers[i];
			while(idx >= 0 && numbers[idx] > num) {
				numbers[idx + 1] = numbers[idx];
				idx--;
			}
			numbers[idx + 1] = num;
		}
		System.out.println(Arrays.toString(numbers));
	}
	
	private static void InsertionSortOrderByDesc(int[] numbers) {
		int idx;
		int num;
		for (int i = 1; i < numbers.length; i++) {
			idx = i - 1;
			num = numbers[i];
			while(idx >= 0 && numbers[idx] < num) {
				numbers[idx + 1] = numbers[idx];
				idx--;
			}
			numbers[idx + 1] = num;
		}
		System.out.println(Arrays.toString(numbers));
	}
}
