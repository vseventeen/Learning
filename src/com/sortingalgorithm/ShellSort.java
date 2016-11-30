package com.sortingalgorithm;

import java.util.Arrays;

/**
 * ϣ�����򣺲��������һ�֡������ݷ��飨ÿ���gapΪһ�飩��
 *          ��ÿ����в�������gap���μ���ѭ������ֱ��gap=1
 *          ��ʱΪֱ�Ӳ������򡣴˷��ɼ��ٽ���������
 * ʱ�临�Ӷȣ���ȷ�� n(logn)^2
 * �ռ临�Ӷȣ�O(1)
 * ���ȶ�����
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
			// Ϊÿһ����з������������佻����У�
			for (int i = gap; i < len; i++) {
				// ����
				System.out.println(i);
				for (int j = i - gap; j > -1 && src[j + gap] < src[j]; j -= gap) {
					int tmp = src[j];
					src[j] = src[j+gap];
					src[j+gap] = tmp;
					System.out.println(gap);
					System.out.println(Arrays.toString(src));
				}
			}
			System.out.println(gap);
			System.out.println(Arrays.toString(src));
		}
	}

}
