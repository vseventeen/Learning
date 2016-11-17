package com.sortingalgorithm;

import java.util.Arrays;

/**
 * 双冒泡排序：递增将大值置于末位，递减将小值置于首位
 */

public class CocktailSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("初始序列：" + Arrays.toString(a));
		cocktailSort(a);
		System.out.println("最终序列：" + Arrays.toString(a));
	}
	
	public static void cocktailSort(int[] src) {
		boolean isSwapped = true;
	
		while (isSwapped) {
			isSwapped = false;
			// 递增将最大值置于末位
			for (int i = 0; i < src.length - 1; i++) {
				if (src[i] > src[i + 1]) {
					int tmp = src[i];
					src[i] = src[i + 1];
					src[i + 1] = tmp;
					isSwapped = true;
				}
			}
//			System.out.println(Arrays.toString(src));
			// 若无交换，则排序完毕，退出
			if(!isSwapped) break;
			// 递减将最小值置于首位
			for (int i = src.length - 2; i > -1; i--) {
				if (src[i] > src[i + 1]) {
					int tmp = src[i];
					src[i] = src[i + 1];
					src[i + 1] = tmp;
					isSwapped = true;
				}
			}
//			System.out.println(Arrays.toString(src));
		}
	}
}
