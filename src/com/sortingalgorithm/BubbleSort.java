package com.sortingalgorithm;

import java.util.Arrays;

/**
 * ð������ÿһ�����������Ƚϣ��ó����ֵ����Сֵ��
 *          ������ֵ���ڴ�������ĩλ
 */

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9};
		System.out.println("��ʼ���У�" + Arrays.toString(a));
		bubbleSort(a);
		System.out.println("�������У�" + Arrays.toString(a));
	}
	
	public static void bubbleSort(int[] src) {
		// �����n-1������
		for (int i = 0; i < src.length - 1; i++) {
			// ÿһ��ѭ���������м�һ
			// ���������Ƚ�
			for (int j = 1; j < src.length - i; j++) {
				// ����
				if (src[j-1] > src[j]) {
					int temp = src[j-1];
					src[j-1] = src[j];
					src[j] = temp;
				}
			}
			System.out.println("��"+(i+1)+"�������"+Arrays.toString(src));
		}
	}
}

