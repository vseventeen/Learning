package com.sortingalgorithm;

import java.util.Arrays;

/**
 * ѡ������ÿһ��������Сֵ�����ֵ�������ڴ���������λ 
 * ��ÿһ�αȽ϶�����С�ķŵ���i��λ�ã�һ�ֹ��󣬸�ֵ��Ϊ��Сֵ��
 */

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9};
		System.out.println("��ʼ���У�" + Arrays.toString(a));
		selectionSort(a);
		System.out.println("�������У�" + Arrays.toString(a));
	}
	
	public static void selectionSort(int[] src) {
		// ��0��n-1��Ҫ�Ƚϣ���n����Ȼ�����������ֵ
		for (int i = 0; i < src.length - 1; i++) {
			for (int j = i + 1; j < src.length; j++) {
				// �̶�һ�������αȽ�
				if (src[i] > src[j]) {
					int temp = src[i];
					src[i] = src[j];
					src[j] = temp;
				}
			}
			System.out.println("��"+(i+1)+"�������"+Arrays.toString(src));
		}
	}

}
