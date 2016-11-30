package com.sortingalgorithm;

import java.util.Arrays;

/**
 * �ؾ�������򵥵�����ֻ��һ��ѭ��
 *          ���������򽻻���i��һ������i��һ
 * ʱ�临�Ӷȣ�O(n^2)
 * �ռ临�Ӷȣ�O(1)
 * �ȶ�����
 */

public class GnomeSort {
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("��ʼ���У�" + Arrays.toString(a));
		gnomeSort(a);
		System.out.println("�������У�" + Arrays.toString(a));
		}
	
	public static void gnomeSort(int[] src) {
		int i = 1;
		while (i < src.length) {
			if (i == 0 || src[i - 1] <= src[i]) {
				i++; // ��Ϊ˳��i��һ
			} else {
				// ��Ϊ�����򽻻���i��һ
				int tmp = src[i - 1];
				src[i - 1] = src[i];
				src[i] = tmp;
				i--;
			}
		}
	}

}