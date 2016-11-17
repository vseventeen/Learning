package com.sortingalgorithm;

import java.util.Arrays;

/**
 * 冒泡排序：每一轮相邻两个比较，得出最大值（最小值）
 *          并将该值置于待排序列末位
 */

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9};
		System.out.println("初始序列：" + Arrays.toString(a));
		bubbleSort(a);
		System.out.println("最终序列：" + Arrays.toString(a));
	}
	
	public static void bubbleSort(int[] src) {
		// 最多做n-1趟排序
		for (int i = 0; i < src.length - 1; i++) {
			// 每一次循环待排序列减一
			// 相邻两个比较
			for (int j = 1; j < src.length - i; j++) {
				// 交换
				if (src[j-1] > src[j]) {
					int temp = src[j-1];
					src[j-1] = src[j];
					src[j] = temp;
				}
			}
			System.out.println("第"+(i+1)+"趟排序后："+Arrays.toString(src));
		}
	}
}

