package com.sortingalgorithm;

import java.util.Arrays;
/**
 * ������������ѡ��һ��Ԫ����Ϊ��׼��pivot������ʣ��Ԫ������Ƚϡ�
 *          �ȽϺ��Ϊ���飨���ڻ�׼��Ϊһ�飬С�ڵ�Ϊһ�飩��������ݹ���á�
 * ʱ�临�Ӷȣ�O(nlogn)
 * �ռ临�Ӷȣ�O(1)
 * ���ȶ�����
 */

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {3, 7, 1, 10, 5, 2, 4, 9, 6};
		System.out.println("��ʼ���У�" + Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println("�������У�" + Arrays.toString(a));
	}
	
	public static void quickSort(int[] src, int low, int high) {
		int i = low;
		int j = high;
		int piovt = src[i];
		
		while (i < j) {
			while (i < j && src[j] > piovt) {
				j--;
			}
			if (i < j) {
				int tmp = src[i];
				src[i] = src[j];
				src[j] = tmp;
				i++;
			}
			
			while (i < j && src[i] < piovt) {
				i++;
			}
			if (i < j) {
				int tmp = src[i];
				src[i] = src[j];
				src[j] = tmp;
				j--;
			}
		}
		if (i > low) {
			quickSort(src, low, i - 1);
		}
		if (j < high) {
			quickSort(src, i + 1, high);
		}
	}
	
	public static void quickSortPlus(int[] src, int low, int high) {
		int i, j, x;
		if (low < high) {
			i = low;
			j = high;
			x = src[i]; // ��һλ��Ϊ��׼
			while (i < j) {
				// ���������ҳ�С�ڻ�׼��Ԫ��
				while (i < j && src[j] > x) {
					j--;
				}
				// �ҵ��� ��Ԫ�ظ��ǵ�i��Ӧ��Ԫ��
				//����ʱ��Ԫ�������ô����ȴ������ǣ�
				if(i < j) {
					src[i] = src[j];
					i++; // i�ѱ����ǣ��ƶ�����һ��
				}
				// �������ң��ҳ����ڻ�׼��Ԫ��
				while (i < j && src[i] < x) {
					i++;
				} // �ҵ��� ��Ԫ�ظ��ǵ�j��Ӧ��Ԫ��
				if (i < j) {
					src[j] = src[i];
					j--; // j�ѱ����ǣ��ƶ�����һ��
				}
			}
			// i=j������Ԫ�ض����׼�ȽϹ�һ��
			// ��λ��Ԫ�������ô�������׼����
			// ��ʱ��λ�ڻ�׼��ߵĶ�С�ڻ�׼���ұ߶����ڻ�׼
			src[i] = x; 
			// �ݹ����
			quickSortPlus(src, low, i-1);
			quickSortPlus(src, i+1, high);
		}
		
	}
}
