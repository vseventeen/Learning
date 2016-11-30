package com.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * LIS��Longest Increasing Subsequence
 * ��������½��������У�����һ�����飬�ҳ���������������½�������
 *                       �����в�������
 * ʱ�临�Ӷȣ�lis1 = O(n^2)
 *            lis2 = O(nlogn)
 * @author chile.chia
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = {2,1,6,4,5,2,7,4};
		System.out.println(lis2(input));
	}
	
	/**
	 * ˵����dp���������洢ÿһλ�Ը�λ��β��LIS����
	 *      ��: ��������Ϊ{2,1,6,4,5,2,7,4}��
	 *          ��Ӧ��dp����Ϊ{1,1,2,2,3,1,4,1}
	 * ��������̬�滮 dp[i] = max{1, dp[j]+1}
	 *          
	 * @param sequence
	 *        input array
	 * @return 
	 *         max value of the lis of the input sequence
	 */
	
	public static int lis1(int[] sequence) {
		// ����Ϊ���򷵻�0
		if (sequence == null || sequence.length == 0) {
			return 0;
		}
		
		// �洢ÿһλ�Ը�λ��β��LIS����
		int[] dp = new int[sequence.length];
		int max = 1;
		for (int i = 0; i < sequence.length; i++) {
			dp[i] = 1; // ��i��β��lis��СΪ1
			for (int j = i - 1; j > -1; j--) {
				// �����ڱ�iС��Ԫ��
				if (sequence[i] > sequence[j]) {
					// iλ�õ�LIS���ٱ�jλ�õĶ�1��ȡ���ֵ
					dp[i] = Math.max(dp[i], dp[j] + 1);
				    max = Math.max(dp[i], max);
				}
			}
		}
		return max;
	}
	
	
	/**
	 * ˵����dp����Ϊ�������������洢LIS����iʱĩβ��С��ֵ
	 *      ����Ϊ�������������У������ڴ��ڸ�ֵ��ֵ��
	 *             ���滻dp�е��׸�����������ֵ�����򽫸�ֵ׷�ӵ�dpĩβ
	 *      ��: ��������Ϊ{2,1,6,4,5,2,7,4}��dpΪ{1,2,4,7}
	 *      �ݻ����̣�{2}-{1}-{1,6}-{1,4}-{1,4,5}-{1,2,5}-{1,2,5,7}-{1,2,4,7}
	 * ������������������ʱ��ʹ�ö��ֲ��ҷ�
	 * 
	 * @param sequence
	 *        input array
	 * @return
	 *         max value of the lis of the input sequence
	 *        
	 */
	
	public static int lis2(int[] sequence) {
		// ����Ϊ���򷵻�0
		if (sequence == null || sequence.length == 0) {
			return 0;
		}
		// �洢LIS����iʱĩβ��С��ֵ
		List<Integer> dp = new ArrayList<>();
		dp.add(sequence[0]);
		for (int item : sequence) {
			// item����dp�е�ֵ��׷��
			if (item > dp.get(dp.size()-1)) {
				dp.add(item);
			} else { // 
				// �����׸�����(����)itemֵ��λ��
				int index = findFirstGreater(dp, item);
				// �滻
				dp.set(index, item);  
			}
		}
		return dp.size();
	}
	
	/**
	 * ˵���� ʹ�ö��ֲ��ҷ����ڸ����������ҳ���һ�����ڱȽ�ֵ��λ��
	 * @param arr
	 *        ��������
	 * @param item
	 *        �Ƚ�ֵ
	 * @return
	 *         ���ص�һ���ȱȽ�ֵ���ֵ������λ��
	 */
	private static int findFirstGreater(List<Integer> arr, int item) {

		int low = 0;
		int high = arr.size()-1;
		
		while (low < high) {
			int mid = (low + high) / 2;
			if (item == arr.get(mid)) { // ���м�ֵ���
				return mid;
			} else if (item > arr.get(mid)) { // �����м�ֵ��ȡ�°벿��
				low = mid + 1;
			} else { // С���м�ֵ��ȡ�ϰ벿��
				high = mid - 1;
			}
		}
		if (low == 0 && arr.size() == 1) {
			return low;
		} else if (item > arr.get(low)) {
			System.out.println("print");
			return low + 1;
		} else {
			return low;
		}
	}
	
}

