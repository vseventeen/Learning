package com.sortingalgorithm;

import java.util.Arrays;

/**
 * 梳排序：希尔排序与冒泡排序的结合
 * 可以将位于后排的较小数值较快的置于序列前端
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 不稳定排序
 */

public class CombSort {
	
	public static void main(String[] args) {
//		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		int[] a = {3, 5, 0, 7, 6,1,10,7,2};

		System.out.println("初始序列：" + Arrays.toString(a));
		combSort(a);
		System.out.println("最终序列：" + Arrays.toString(a));
		System.out.println((int)(4/1.3));
		System.out.println(1&7);
		System.out.println(1^7);
	}

	public static void combSort(int[] src) {
		
		boolean isSwapped = true;
		int len = src.length;
		int gap = len;
		
		// gap必须到最小值1，确保两两比较
		while (isSwapped || gap > 1) {
			// 对gap使用固定的递减率1.3
			if (gap > 1) {
				gap = (int) (gap / 1.3); 
			}
			
			System.out.println(gap);
			
			isSwapped = false;
			
			// combSort11
			/*if (gap == 9 || gap == 10) {
				gap = 11;
			}*/
			
			// 每间隔gap比较
			for (int i = gap; i < len; i++) {
				if (src[i] < src[i - gap]) {
					int tmp = src[i];
					src[i] = src[i - gap];
					src[i - gap] = tmp;
					isSwapped = true;
				}
			}
			
			System.out.println(Arrays.toString(src));
		}
	}
}
