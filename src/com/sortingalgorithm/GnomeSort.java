package com.sortingalgorithm;

import java.util.Arrays;

/**
 * 地精排序：最简单的排序，只有一层循环
 *          发现逆序则交换且i减一，其他i加一
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定排序
 */

public class GnomeSort {
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("初始序列：" + Arrays.toString(a));
		gnomeSort(a);
		System.out.println("最终序列：" + Arrays.toString(a));
		}
	
	public static void gnomeSort(int[] src) {
		int i = 1;
		while (i < src.length) {
			if (i == 0 || src[i - 1] <= src[i]) {
				i++; // 若为顺序i加一
			} else {
				// 若为逆序，则交换且i减一
				int tmp = src[i - 1];
				src[i - 1] = src[i];
				src[i] = tmp;
				i--;
			}
		}
	}

}