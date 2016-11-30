package com.sortingalgorithm;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 3, 7, 1, 10, 5, 2, 4, 9, 6 };
		System.out.println("��ʼ���У�" + Arrays.toString(a));
		int[] b = mergeSort(a, 0, a.length - 1);
		System.out.println("�������У�" + Arrays.toString(b));
	}

	public static int[] mergeSort(int[] src, int low, int high) {
		// length of the input
		int len = high - low + 1;
		int[] tmp = new int[len];
		
		// base case, ��ֻ��һ��Ԫ��ʱֱ�ӷ���
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
			// ���ұȽϣ���С���Ƚ���tmp����
			if (tmpLeft[i] < tmpRight[j]) {
				tmp[index++] = tmpLeft[i++];
			} else {
				tmp[index++] = tmpRight[j++];
			}
		}
		while (index < len) {
			// �������ȫ������tmp���飬��ֻʣ�ұߣ�
			// ��ʱֱ�ӽ��ұ�������ӵ�tmp���ɡ�
			if (i == len / 2) {
			    tmp[index++] = tmpRight[j++];
			} else {
				tmp[index++] = tmpLeft[i++];
			}
		}
		
		return tmp;
	}

}
