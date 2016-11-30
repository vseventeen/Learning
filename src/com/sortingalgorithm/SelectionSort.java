package com.sortingalgorithm;

import java.util.Arrays;

/**
 * 选择排序：每一轮挑出最小值（最大值），置于待排序列首位 
 * （每一次比较都将较小的放到第i个位置，一轮过后，该值就为最小值）
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定排序
 */

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9};
		System.out.println("初始序列：" + Arrays.toString(a));
		selectionSort(a);
		System.out.println("最终序列：" + Arrays.toString(a));
	}
	
	public static void selectionSort(int[] src) {
		// 从0到n-1需要比较，第n个自然就是最后的最大值
		for (int i = 0; i < src.length - 1; i++) {
			for (int j = i + 1; j < src.length; j++) {
				// 固定一个，依次比较
				if (src[i] > src[j]) {
					int temp = src[i];
					src[i] = src[j];
					src[j] = temp;
				}
			}
			System.out.println("第"+(i+1)+"趟排序后："+Arrays.toString(src));
		}
	}

}
