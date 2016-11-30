package com.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * LIS：Longest Increasing Subsequence
 * 最长上升（下降）子序列：给定一个数组，找出长度最长的上升（下降）序列
 *                       该序列不连续。
 * 时间复杂度：lis1 = O(n^2)
 *            lis2 = O(nlogn)
 * @author chile.chia
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = {2,1,6,4,5,2,7,4};
		System.out.println(lis2(input));
	}
	
	/**
	 * 说明：dp数组用来存储每一位以该位结尾的LIS个数
	 *      例: 输入数组为{2,1,6,4,5,2,7,4}，
	 *          对应的dp数组为{1,1,2,2,3,1,4,1}
	 * 方法：动态规划 dp[i] = max{1, dp[j]+1}
	 *          
	 * @param sequence
	 *        input array
	 * @return 
	 *         max value of the lis of the input sequence
	 */
	
	public static int lis1(int[] sequence) {
		// 输入为空则返回0
		if (sequence == null || sequence.length == 0) {
			return 0;
		}
		
		// 存储每一位以该位结尾的LIS个数
		int[] dp = new int[sequence.length];
		int max = 1;
		for (int i = 0; i < sequence.length; i++) {
			dp[i] = 1; // 以i结尾的lis最小为1
			for (int j = i - 1; j > -1; j--) {
				// 若存在比i小的元素
				if (sequence[i] > sequence[j]) {
					// i位置的LIS至少比j位置的多1，取最大值
					dp[i] = Math.max(dp[i], dp[j] + 1);
				    max = Math.max(dp[i], max);
				}
			}
		}
		return max;
	}
	
	
	/**
	 * 说明：dp数组为有序序列用来存储LIS个数i时末尾最小的值
	 *      步骤为：遍历输入序列，若存在大于该值的值，
	 *             则替换dp中的首个符合条件的值，否则将该值追加到dp末尾
	 *      例: 输入数组为{2,1,6,4,5,2,7,4}，dp为{1,2,4,7}
	 *      演化过程：{2}-{1}-{1,6}-{1,4}-{1,4,5}-{1,2,5}-{1,2,5,7}-{1,2,4,7}
	 * 方法：查找有序序列时，使用二分查找法
	 * 
	 * @param sequence
	 *        input array
	 * @return
	 *         max value of the lis of the input sequence
	 *        
	 */
	
	public static int lis2(int[] sequence) {
		// 输入为空则返回0
		if (sequence == null || sequence.length == 0) {
			return 0;
		}
		// 存储LIS个数i时末尾最小的值
		List<Integer> dp = new ArrayList<>();
		dp.add(sequence[0]);
		for (int item : sequence) {
			// item大于dp中的值，追加
			if (item > dp.get(dp.size()-1)) {
				dp.add(item);
			} else { // 
				// 查找首个大于(等于)item值的位置
				int index = findFirstGreater(dp, item);
				// 替换
				dp.set(index, item);  
			}
		}
		return dp.size();
	}
	
	/**
	 * 说明： 使用二分查找法，在给定序列中找出第一个大于比较值的位置
	 * @param arr
	 *        给定序列
	 * @param item
	 *        比较值
	 * @return
	 *         返回第一个比比较值大的值的索引位置
	 */
	private static int findFirstGreater(List<Integer> arr, int item) {

		int low = 0;
		int high = arr.size()-1;
		
		while (low < high) {
			int mid = (low + high) / 2;
			if (item == arr.get(mid)) { // 与中间值相等
				return mid;
			} else if (item > arr.get(mid)) { // 大于中间值，取下半部分
				low = mid + 1;
			} else { // 小于中间值，取上半部分
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

