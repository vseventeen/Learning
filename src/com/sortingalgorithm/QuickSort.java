package com.sortingalgorithm;

import java.util.Arrays;
/**
 * 快速排序：任意选择一个元素作为基准（pivot），拿剩余元素与其比较。
 *          比较后分为两组（大于基准的为一组，小于的为一组），对两组递归调用。
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 不稳定排序
 */

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("初始序列：" + Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println("最终序列：" + Arrays.toString(a));
	}
	
	public static void quickSort(int[] src, int low, int high) {
		int i = low;
		int j = high;
		int piovt = src[i];
		
		while (i < j) {
			while (i < j && src[j] > piovt) {
				j--;
			}
			if (i < j) {
				int tmp = src[i];
				src[i] = src[j];
				src[j] = tmp;
				i++;
			}
			
			while (i < j && src[i] < piovt) {
				i++;
			}
			if (i < j) {
				int tmp = src[i];
				src[i] = src[j];
				src[j] = tmp;
				j--;
			}
		}
		if (i > low) {
			quickSort(src, low, i - 1);
		}
		if (j < high) {
			quickSort(src, i + 1, high);
		}
	}
	
	public static void quickSortPlus(int[] src, int low, int high) {
		int i, j, x;
		if (low < high) {
			i = low;
			j = high;
			x = src[i]; // 第一位作为基准
			while (i < j) {
				// 从右往左，找出小于基准的元素
				while (i < j && src[j] > x) {
					j--;
				}
				// 找到后将 该元素覆盖到i对应的元素
				//（此时该元素已无用处，等待被覆盖）
				if(i < j) {
					src[i] = src[j];
					i++; // i已被覆盖，移动到下一个
				}
				// 从左往右，找出大于基准的元素
				while (i < j && src[i] < x) {
					i++;
				} // 找到后将 该元素覆盖到j对应的元素
				if (i < j) {
					src[j] = src[i];
					j--; // j已被覆盖，移动到上一个
				}
			}
			// i=j，所有元素都与基准比较过一次
			// 该位置元素已无用处，被基准覆盖
			// 此时，位于基准左边的都小于基准，右边都大于基准
			src[i] = x; 
			// 递归调用
			quickSortPlus(src, low, i-1);
			quickSortPlus(src, i+1, high);
		}
		
	}
}
