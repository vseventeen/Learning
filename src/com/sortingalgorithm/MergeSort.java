package com.sortingalgorithm;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 3, 7, 1, 10, 5, 2, 4, 9, 6 };
		System.out.println("初始序列：" + Arrays.toString(a));
		int[] b = mergeSort(a, 0, a.length - 1);
		System.out.println("最终序列：" + Arrays.toString(b));
	}

	public static int[] mergeSort(int[] src, int low, int high) {
		// length of the input
		int len = high - low + 1;
		int[] tmp = new int[len];
		
		// base case, 当只有一个元素时直接返回
		if (low == high) {
			tmp[0] = src[low];
			return tmp;
		}
		
		// Partition
		int[] tmpLeft = new int[len / 2];
		int[] tmpRight = new int[len - len / 2];
		
		tmpLeft = mergeSort(src, low, low + (len / 2 - 1));
//		System.out.println("L: " + Arrays.toString(tmpLeft));
		tmpRight = mergeSort(src, low + len / 2, high);
//		System.out.println("R: " + Arrays.toString(tmpRight));
		// Merge
		int i = 0;
		int j = 0;
		int index = 0;
		while (i < len / 2 && j < len - len / 2) {
			// 左右比较，较小的先进入tmp数组
			if (tmpLeft[i] < tmpRight[j]) {
				tmp[index++] = tmpLeft[i++];
			} else {
				tmp[index++] = tmpRight[j++];
			}
		}
		while (index < len) {
			// 若左边已全部进入tmp数组，则只剩右边，
			// 此时直接将右边数组添加到tmp即可。
			if (i == len / 2) {
			    tmp[index++] = tmpRight[j++];
			} else {
				tmp[index++] = tmpLeft[i++];
			}
		}
		
		return tmp;
	}

}
