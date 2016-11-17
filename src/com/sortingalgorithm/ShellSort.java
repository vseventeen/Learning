package com.sortingalgorithm;

import java.util.Arrays;

/**
 * ϣ�����򣺲��������һ�֡������ݷ��飨ÿ���gapΪһ�飩��
 *          ��ÿ����в�������gap���μ���ѭ������ֱ��gap=1
 *          ��ʱΪֱ�Ӳ������򡣴˷��ɼ��ٽ���������
 */

public class ShellSort {
	
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("��ʼ���У�" + Arrays.toString(a));
		shellSort(a);
		System.out.println("�������У�" + Arrays.toString(a));
	}
	
	public static void shellSort(int[] src) {
		int len = src.length;
		// ÿ��gapΪһ�飬���з����������
		// gap���μ��룬ֱ��gap=1��Ϊֱ�Ӳ�������
		for(int gap = len / 2; gap > 0; gap /= 2) {
			// Ϊÿһ����з����������
			for (int i = gap; i < len; i++) {
				// ����
				for (int j = i - gap; j > -1 && src[j] < src[j+gap]; j -= gap) {
					int tmp = src[j];
					src[j] = src[j+gap];
					src[j+gap] = tmp;
				}
			}
//			System.out.println(gap);
//			System.out.println(Arrays.toString(src));
		}
	}

}
