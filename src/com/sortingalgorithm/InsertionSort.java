package com.sortingalgorithm;

import java.util.Arrays;
/**
 * �������򣺴���Ԫ��֮ǰ������Ϊ�������У�������Ԫ�ز����ʵ�λ��
 *
 */

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] a = { 3, 7, 1, 10, 5, 2, 4, 9 };
		System.out.println("��ʼ���У�" + Arrays.toString(a));
		insertionSort(a);
		System.out.println("�������У�" + Arrays.toString(a));
	}
	
	public static void insertionSort(int[] src) {
		// �ӵڶ���Ԫ�ؿ�ʼ�Ƚ�
		for (int i = 1; i < src.length; i++) {
			// ��src[j] < src[j-1]��������i+1����д��forѭ���ж�����
			// ��i֮ǰ��Ԫ�������Ƚ�
			for (int j = i; j > 0 && src[j] < src[j-1]; j--) {
				int tmp = src[j];
				src[j] = src[j-1];
				src[j-1] = tmp;
			}
			System.out.println("��"+ i +"�������"+Arrays.toString(src));
		}
	}

}
