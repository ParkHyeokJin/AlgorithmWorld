import java.util.Arrays;

public class HeapSort2 {
	public static void main(String[] args) {
		HeapSort(new int[] {3,5,1,2,4,8,6,9,7});
	}
	
	private static void HeapSort(int[] nums) {
		//������ �˰��� ����
		heapify(nums, 0, nums.length);
		//���� ����
		for(int i = nums.length - 1; i >= 0; i--) {
			//����ū ���� ù��° ���ڿ� ���� ������ ������ �ڸ��� ��ü �Ѵ�.
			swap(nums, 0, i);
			//�迭�� ù��° ���� ��ü�� �ε������� ������ �˰����� �����Ѵ�.
			heapify(nums, 0, i);
			System.out.println(Arrays.toString(nums));
		}
	}

	//�� ����
	private static void heapify(int[] nums, int start, int end) {
		for (int i = start; i < end; i++) {
			int childIdx = i;
			while(childIdx != 0) {
				int rootIdx = (childIdx - 1) / 2;
				if(nums[rootIdx] > nums[childIdx]) {
					swap(nums, childIdx, rootIdx);
				}
				childIdx = rootIdx;
			}
		}
	}

	//�ε��� ����
	private static void swap(int[] nums, int child, int root) {
		int temp = nums[root];
		nums[root] = nums[child];
		nums[child] = temp;
	}
}

