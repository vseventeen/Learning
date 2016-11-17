package com.sortingalgorithm;

import java.util.Arrays;
/**
 * 插入排序：待排元素之前的序列为已排序列，将待排元素插入适当位置
 *
 */

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] a = { 3, 7, 1, 10, 5, 2, 4, 9 };
		System.out.println("初始序列：" + Arrays.toString(a));
		insertionSort(a);
		System.out.println("最终序列：" + Arrays.toString(a));
	}
	
	public static void insertionSort(int[] src) {
		// 从第二个元素开始比较
		for (int i = 1; i < src.length; i++) {
			// 若src[j] < src[j-1]不成立则i+1，故写入for循环判断条件
			// 与i之前的元素两两比较
			for (int j = i; j > 0 && src[j] < src[j-1]; j--) {
				int tmp = src[j];
				src[j] = src[j-1];
				src[j-1] = tmp;
			}
			System.out.println("第"+ i +"趟排序后："+Arrays.toString(src));
		}
	}

}
