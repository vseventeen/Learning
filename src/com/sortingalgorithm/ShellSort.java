package com.sortingalgorithm;

import java.util.Arrays;

/**
 * 希尔排序：插入排序的一种。将数据分组（每间隔gap为一组），
 *          对每组进行插入排序。gap依次减半循环进行直到gap=1
 *          此时为直接插入排序。此法可减少交换次数。
 * 时间复杂度：不确定 n(logn)^2
 * 空间复杂度：O(1)
 * 不稳定排序
 */

public class ShellSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("初始序列：" + Arrays.toString(a));
		shellSort(a);
		System.out.println("最终序列：" + Arrays.toString(a));
	}
	
	public static void shellSort(int[] src) {
		int len = src.length;
		// 每隔gap为一组，进行分组插入排序
		// gap依次减半，直到gap=1，为直接插入排序
		for(int gap = len / 2; gap > 0; gap /= 2) {
			// 为每一组进行分组插入排序（组间交替进行）
			for (int i = gap; i < len; i++) {
				// 组内
				System.out.println(i);
				for (int j = i - gap; j > -1 && src[j + gap] < src[j]; j -= gap) {
					int tmp = src[j];
					src[j] = src[j+gap];
					src[j+gap] = tmp;
					System.out.println(gap);
					System.out.println(Arrays.toString(src));
				}
			}
			System.out.println(gap);
			System.out.println(Arrays.toString(src));
		}
	}

}
