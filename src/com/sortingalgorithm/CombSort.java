package com.sortingalgorithm;

import java.util.Arrays;

/**
 * 梳排序：希尔排序与冒泡排序的结合
 * 
 * 可以将位于后排的较小数值
 */

public class CombSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("初始序列：" + Arrays.toString(a));
		combSort(a);
		System.out.println("最终序列：" + Arrays.toString(a));
	}

	public static void combSort(int[] src) {
		
		boolean isSwapped = true;
		int len = src.length;
		int gap = len;
		
		// why gap > 1 ?
		while (gap > 0 || isSwapped) {
			// 对gap使用固定的递减率1.3
			gap = (int) (gap / 1.3);
			isSwapped = false;
			
			// combSort11
			/*if (gap == 9 || gap == 10) {
				gap = 11;
			}*/
			
			// 间隔gap比较一次
			for (int i = gap; i < len; i++) {
				if (src[i] < src[i - gap]) {
					int tmp = src[i];
					src[i] = src[i - gap];
					src[i - gap] = tmp;
					isSwapped = true;
				}
			}
			System.out.println(gap);
			System.out.println(Arrays.toString(src));
		}
	}
}
