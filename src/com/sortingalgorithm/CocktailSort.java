package com.sortingalgorithm;

import java.util.Arrays;

/**
 * ˫ð�����򣺵�������ֵ����ĩλ���ݼ���Сֵ������λ
 */

public class CocktailSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("��ʼ���У�" + Arrays.toString(a));
		cocktailSort(a);
		System.out.println("�������У�" + Arrays.toString(a));
	}
	
	public static void cocktailSort(int[] src) {
		boolean isSwapped = true;
	
		while (isSwapped) {
			isSwapped = false;
			// ���������ֵ����ĩλ
			for (int i = 0; i < src.length - 1; i++) {
				if (src[i] > src[i + 1]) {
					int tmp = src[i];
					src[i] = src[i + 1];
					src[i + 1] = tmp;
					isSwapped = true;
				}
			}
//			System.out.println(Arrays.toString(src));
			// ���޽�������������ϣ��˳�
			if(!isSwapped) break;
			// �ݼ�����Сֵ������λ
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
